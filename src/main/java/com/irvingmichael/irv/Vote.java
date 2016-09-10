package com.irvingmichael.irv;

import java.util.HashMap;

/**
 * Created by aaron on 9/10/16.
 */
public class Vote {

    private int voteId;
    private HashMap<Integer, Integer> voteRankings;
    private HashMap<Integer, Integer> currentRankings;

    public Vote(int id) {
        voteRankings = new HashMap<Integer, Integer>();
        currentRankings = new HashMap<Integer, Integer>();
    }

    public int getVoteId() {
        return voteId;
    }

    public HashMap<Integer, Integer> getVoteRankings() {
        return voteRankings;
    }

    public void setVoteRankings(HashMap<Integer, Integer> voteRankings) {
        this.voteRankings = voteRankings;
    }

    public HashMap<Integer, Integer> getCurrentRankings() {
        return currentRankings;
    }

    public void setCurrentRankings(HashMap<Integer, Integer> currentRankings) {
        this.currentRankings = currentRankings;
    }
}
