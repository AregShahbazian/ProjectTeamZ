package com.teamz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	
	private String title;
	private int year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private double imdbRating;
	private String imdbVotes;
	private String imdbId;
	private String response;



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getRated() {
		return rated;
	}



	public void setRated(String rated) {
		this.rated = rated;
	}



	public String getReleased() {
		return released;
	}



	public void setReleased(String released) {
		this.released = released;
	}



	public String getRuntime() {
		return runtime;
	}



	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getActors() {
		return actors;
	}



	public void setActors(String actors) {
		this.actors = actors;
	}



	public String getPlot() {
		return plot;
	}



	public void setPlot(String plot) {
		this.plot = plot;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getAwards() {
		return awards;
	}



	public void setAwards(String awards) {
		this.awards = awards;
	}



	public String getPoster() {
		return poster;
	}



	public void setPoster(String poster) {
		this.poster = poster;
	}



	public double getImdbRating() {
		return imdbRating;
	}



	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}



	public String getImdbVotes() {
		return imdbVotes;
	}



	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}



	public String getImdbId() {
		return imdbId;
	}



	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}
	
	
    @Override
    public String toString() {
        return this.title + ", " + this.year + "\n" + plot.substring(0, 50) + "...";
    }
		
	
}