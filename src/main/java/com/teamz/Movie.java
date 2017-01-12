package com.teamz;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	
	private String Title;
	private int Year;
	private String Rated;
	private String Released;
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private double imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Response;



	
    @Override
    public String toString() {
        return this.Title + ", " + this.Year + "\n" + Plot.substring(0, 50) + "...";
    }




	public String getTitle() {
		return Title;
	}




	public void setTitle(String title) {
		Title = title;
	}




	public int getYear() {
		return Year;
	}




	public void setYear(int year) {
		Year = year;
	}




	public String getRated() {
		return Rated;
	}




	public void setRated(String rated) {
		Rated = rated;
	}




	public String getReleased() {
		return Released;
	}




	public void setReleased(String released) {
		Released = released;
	}




	public String getRuntime() {
		return Runtime;
	}




	public void setRuntime(String runtime) {
		Runtime = runtime;
	}




	public String getGenre() {
		return Genre;
	}




	public void setGenre(String genre) {
		Genre = genre;
	}




	public String getDirector() {
		return Director;
	}




	public void setDirector(String director) {
		Director = director;
	}




	public String getWriter() {
		return Writer;
	}




	public void setWriter(String writer) {
		Writer = writer;
	}




	public String getActors() {
		return Actors;
	}




	public void setActors(String actors) {
		Actors = actors;
	}




	public String getPlot() {
		return Plot;
	}




	public void setPlot(String plot) {
		Plot = plot;
	}




	public String getLanguage() {
		return Language;
	}




	public void setLanguage(String language) {
		Language = language;
	}




	public String getCountry() {
		return Country;
	}




	public void setCountry(String country) {
		Country = country;
	}




	public String getAwards() {
		return Awards;
	}




	public void setAwards(String awards) {
		Awards = awards;
	}




	public String getPoster() {
		return Poster;
	}




	public void setPoster(String poster) {
		Poster = poster;
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
		return imdbID;
	}




	public void setImdbId(String imdbID) {
		this.imdbID = imdbID;
	}




	public String getResponse() {
		return Response;
	}




	public void setResponse(String response) {
		Response = response;
	}
		
	
}