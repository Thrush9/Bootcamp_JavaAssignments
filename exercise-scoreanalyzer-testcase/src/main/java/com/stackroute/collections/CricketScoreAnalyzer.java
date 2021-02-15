package com.stackroute.collections;

import java.util.*;

/* This class is used to analyze the runs scored by batsman in one innings of one day cricket*/
public class CricketScoreAnalyzer {

    private Map<String, Integer> scoreCard;

    public CricketScoreAnalyzer() {
        scoreCard = new HashMap<>();
    }

    public Map<String, Integer> getScoreCard() {
        return scoreCard;
    }

    /* This method adds the batsman and runs scored to scorecard*/
    public boolean addRunsToScoreCard(String batsmanName, int runs) {
        if (batsmanName == null) {
            return false;
        } else {
            scoreCard.put(batsmanName, runs);
            return true;
        }
    }

    /*This method gets the runs scored by a batsman*/
    public Integer getRunsScored(String batsmanName) {
        return scoreCard.get(batsmanName);
    }

    /*This method gets the total score of the innings*/
    public int getTotalRuns() {
        int total = 0;
        for (int runs : scoreCard.values()) {
            total += runs;
        }
        return total;
    }

    /*This method returns a list of names of batsman from scorecard in descending order*/
    public List<String> getSortedBatsmanName() {
        List<String> players = new ArrayList<>(scoreCard.keySet());
        Comparator<String> nameComparator = new Comparator<String>() {
            @Override
            public int compare(String firstPlayer, String secondPlayer) {
                return secondPlayer.compareTo(firstPlayer);
            }
        };
        Collections.sort(players, nameComparator);
        return players;
    }

    /*This method gets highest runs scored by a batsman*/
    public Integer getHighestRunsScored() {
        return Collections.max(scoreCard.values());
    }

    /*This method gets name of the batsmen who scored highest runs*/
    public List<String> getBatsmenNamesWithHighestRuns() {
        Integer highestRuns = Collections.max(scoreCard.values());
        List<String> batsmenNames = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scoreCard.entrySet()) {
            if (entry.getValue().equals(highestRuns)) {
                batsmenNames.add(entry.getKey());
            }
        }
        return batsmenNames;
    }
}