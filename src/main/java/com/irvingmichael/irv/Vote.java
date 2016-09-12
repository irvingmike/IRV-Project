package com.irvingmichael.irv;

import java.util.LinkedHashMap;

/**
 * Created by aaron on 9/10/16.
 */
public class Vote {

    private int voteId;
    private LinkedHashMap<Integer, Integer> voteRankings;
    private LinkedHashMap<Integer, Integer> currentRankings;

    public Vote(int id) {
        voteRankings = new LinkedHashMap<Integer, Integer>();
        currentRankings = new LinkedHashMap<Integer, Integer>();
    }

    public int getVoteId() {
        return voteId;
    }

    public LinkedHashMap<Integer, Integer> getVoteRankings() {
        return voteRankings;
    }

    public void setVoteRankings(LinkedHashMap<Integer, Integer> voteRankings) {
        this.voteRankings = voteRankings;
    }

    public LinkedHashMap<Integer, Integer> getCurrentRankings() {
        return currentRankings;
    }

    public void setCurrentRankings(LinkedHashMap<Integer, Integer> currentRankings) {
        this.currentRankings = currentRankings;
    }
}
