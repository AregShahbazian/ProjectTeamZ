package com.teamz;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

	@RequestMapping("quiz")
	public String post() {
		
		String display;
		
		Question q1 = new Question();
		
		display = q1.generate("tt0468569");
		
		return display;
	}

}
