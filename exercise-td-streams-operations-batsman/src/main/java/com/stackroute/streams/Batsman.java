package com.stackroute.streams;

public class Batsman {
	
	private String name;
	private int matchesPlayed;
	private int totalRuns;
	private int highestScore;
	private Country country;

	public Batsman(String name, int matches, int runs, int highest, Country country) {
		this.name = name;
		this.matchesPlayed = matches;
		this.totalRuns = runs;
		this.highestScore = highest;
		this.country = country;
	}

	public Batsman() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
	
}
