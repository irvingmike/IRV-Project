package com.irvingmichael.irv;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by aaron on 9/14/16.
 */
public class TestPollSetup {

    Poll testPoll;

    TestPollSetup() {
        testPoll = new Poll("Test Poll");
        testPoll.setChoices(makeTestChoices());
        testPoll.setVotes(makeTestVotes());
    }

    private ArrayList<Choice> makeTestChoices() {
        ArrayList<Choice> testChoices = new ArrayList<Choice>();
        testChoices.add(new Choice(1, "Test Choice A"));
        testChoices.add(new Choice(2, "Test Choice B"));
        testChoices.add(new Choice(3, "Test Choice C"));
        testChoices.add(new Choice(4, "Test Choice D"));
        return testChoices;
    }

    private ArrayList<Vote> makeTestVotes() {
        ArrayList<Vote> testVotes = new ArrayList<Vote>();

        Vote testVote = new Vote(101);
        int[] rankings = {1,2,3,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(102);
        rankings = new int[] {2,1,3,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(103);
        rankings = new int[] {2,1,3,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(104);
        rankings = new int[] {2,1,3,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(105);
        rankings = new int[] {3,4,1,2};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(106);
        rankings = new int[] {2,3,4,1};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(107);
        rankings = new int[] {1,2,3,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(108);
        rankings = new int[] {4,1,3,2};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(109);
        rankings = new int[] {2,3,1,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        testVote = new Vote(110);
        rankings = new int[] {1,2,3,4};
        testVote.setVoteRankings(createRanking(rankings));
        testVote.setCurrentRankings(createRanking(rankings));

        return testVotes;
    }

    private LinkedHashMap<Integer, Integer> createRanking(int[] rankings) {
        LinkedHashMap<Integer, Integer> testRankings = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < 4; i++) {
            testRankings.put(i, rankings[i]);
        }
        return testRankings;
    }
}
