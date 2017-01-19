package com.teamz.config;

import java.time.ZonedDateTime;
import java.util.HashSet;

import javax.inject.Inject;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import com.teamz.domain.Authority;
import com.teamz.domain.User;
import com.teamz.repository.AuthorityRepository;
import com.teamz.repository.UserRepository;
import com.teamz.security.AuthoritiesConstants;
import com.teamz.security.Http401UnauthorizedEntryPoint;
import com.teamz.security.jwt.JWTConfigurer;
import com.teamz.security.jwt.TokenProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Inject
	private Http401UnauthorizedEntryPoint authenticationEntryPoint;

	@Inject
	private UserDetailsService userDetailsService;

	@Inject
	private TokenProvider tokenProvider;

	@Inject
	private UserRepository userRepository;
	
	@Inject
	private AuthorityRepository authorityRepository;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Inject
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		try {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		} catch (Exception e) {
			throw new BeanInitializationException("Security configuration failed", e);
		}
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").antMatchers("/app/**/*.{js,html}")
				.antMatchers("/bower_components/**").antMatchers("/i18n/**").antMatchers("/content/**")
				.antMatchers("/swagger-ui/index.html").antMatchers("/test/**").antMatchers("/h2-console/**");
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	http
	    	.csrf()
	        .disable()
	        .headers()
	        .frameOptions()
	        .disable()
        .and()
        	.authorizeRequests()
    		//.antMatchers("/login.html").hasAuthority(AuthoritiesConstants.ADMIN)
//    		.antMatchers("/api/authenticate").permitAll()
//    		.antMatchers("/bower_components/**").permitAll()
//    		.antMatchers("/js/**").permitAll()
//    		.antMatchers("/css/**").permitAll()
    		//.antMatchers("/question").hasAuthority(AuthoritiesConstants.ADMIN)
        	.antMatchers("/**").permitAll()
    		;//.antMatchers("/**").hasAuthority(AuthoritiesConstants.ADMIN);

    }


	private JWTConfigurer securityConfigurerAdapter() {
		return new JWTConfigurer(tokenProvider);
	}

	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
		return new SecurityEvaluationContextExtension();
	}

	
	
	@Inject
	public void foo() {
		Authority adminAuthority = new Authority();
		adminAuthority.setName(AuthoritiesConstants.ADMIN);
		authorityRepository.save(adminAuthority);
		Authority userAuthority = new Authority();
		userAuthority.setName(AuthoritiesConstants.USER);
		authorityRepository.save(userAuthority);
		

		User user = new User();
		user.setLogin("admin");
		user.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
		user.setFirstName("Admin");
		user.setLastName("Adminson");
		user.setEmail("areg.shahbazian@youngcolfield.nl");
		user.setActivated(true);
		user.setCreatedBy("system");
		user.setCreatedDate(ZonedDateTime.now());
		
		
		HashSet<Authority> authorities = new HashSet<>();
		authorities.add(userAuthority);
		authorities.add(adminAuthority);
		user.setAuthorities(authorities);

		userRepository.save(user);
	}
}
