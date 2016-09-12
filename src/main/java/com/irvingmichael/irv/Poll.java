package com.irvingmichael.irv;

import org.apache.log4j.Logger;

import java.util.*;

import org.apache.commons.lang.RandomStringUtils;

import static com.irvingmichael.irv.PollStatus.*;


/**
 * Created by aaron on 9/10/16.
 */
public class Poll {

    private final Logger logger = Logger.getLogger(this.getClass());

    private int id;
    private String title;
    private ArrayList<Choice> choices;
    private ArrayList<Vote> votes;
    private HashMap<Integer, Integer> voteCounts;
    private int winner;
    private String pollCode;
    private int winThreshold;
    private PollStatus status;

    public Poll(int id, String title) {
        this.id = id;
        this.title = title;
        winner = -1;
        choices = new ArrayList<Choice>();
        votes = new ArrayList<Vote>();
        voteCounts = new HashMap<Integer, Integer>();
        pollCode = "";
        status = initial;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public void setVotes(ArrayList<Vote> votes) {
        this.votes = votes;
    }

    public HashMap<Integer, Integer> getVoteCounts() {
        return voteCounts;
    }

    public void setVoteCounts(LinkedHashMap<Integer, Integer> voteCounts) {
        this.voteCounts = voteCounts;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    String getPollCode() {
        if (pollCode.length() != 8) {
            pollCode = RandomStringUtils.random(8, true, true);
        }
        return pollCode;
    }

    int getWinThreshold() {
        if (votes.size() < 1) {
            winThreshold = -1;
        } else if (votes.size() % 2 == 0) {
            winThreshold = votes.size() / 2;
        } else {
            winThreshold = (votes.size() - 1) / 2;
        }
        return winThreshold;
    }

    void determineWinner() {

        status = PollStatus.closed;

        for (Vote vote : votes) {
            vote.setCurrentRankings(vote.getVoteRankings());
        }

        while (winner == -1) {
            resetChoiceCounts();
            countVotes();
            if (!winnerExists()) {
                int choiceToRemove = getLowestVoteGetter();
                removeChoiceFromContention(choiceToRemove);
            }
        }
    }

    void countVotes() {
        for (Vote vote : votes) {
            int currentChoice = findHighestRankedChoice(vote);
            voteCounts.put(currentChoice, voteCounts.get(currentChoice) + 1);
        }
    }

    void resetChoiceCounts() {
        voteCounts = new HashMap<Integer, Integer>();
        for (Choice choice : choices) {
            voteCounts.put(choice.getId(), 0);
        }
    }

    int findHighestRankedChoice(Vote vote) {
        int idToReturn = -1;
        int highestRank = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : vote.getCurrentRankings().entrySet()) {
            if (entry.getValue() > lowestRank) {
                lowestRank = entry.getValue();
                idToReturn = entry.getKey();
            }
        }

        return idToReturn;
    }

    Boolean winnerExists() {
        for (Map.Entry<Integer, Integer> entry : voteCounts.entrySet()) {
            if (entry.getValue() > winThreshold) {
                return true;
            }
        }
        return false;
    }


}
