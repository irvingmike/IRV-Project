package com.irvingmichael.irv;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static javax.swing.UIManager.put;
import static org.junit.Assert.*;

/**
 * Created by aaron on 9/10/16.
 */
public class PollTest {

    private Poll poll;

    @Before
    public void setup() {
        poll = new TestPollSetup().testPoll;
    }

    @Test
    public void removeChoiceFromVote() throws Exception {
        ArrayList<Vote> testVotes = poll.getVotes();
        Vote testVote = testVotes.get(0);
        int beforeLength = testVote.getCurrentRankings().size();
        poll.removeChoiceFromVote(1, testVote);
        assertEquals("Bad array length after removing vote", beforeLength - 1, testVote.getCurrentRankings().size());
        assertEquals("Removed wrong choice", (Integer) 2, testVote.getCurrentRankings().get(2));
        assertEquals("Removed wrong choice", (Integer) 3, testVote.getCurrentRankings().get(3));
        assertEquals("Removed wrong choice", (Integer) 4, testVote.getCurrentRankings().get(4));
    }

    @Test
    public void setVotesCountsToZero() throws Exception {
        poll.setVoteCounts(new HashMap<Integer, Integer>() {{
                put(1,1);
                put(2,2);
                put(3,3);
        }});
        poll.setVotesCountsToZero();
        assertEquals("Vote count 1 didn't set to zero", (Integer) 0, poll.getVoteCounts().get(1));
        assertEquals("Vote count 2 didn't set to zero", (Integer) 0, poll.getVoteCounts().get(2));
        assertEquals("Vote count 3 didn't set to zero", (Integer) 0, poll.getVoteCounts().get(3));
    }

    @Test
    public void getPollCode() throws Exception {
        String pollCode = poll.getPollCode();
        String pollCodeVerify = poll.getPollCode();

        assertEquals("Poll code generated at incorrect size", 8, pollCode.length());
        assertTrue(pollCode == pollCodeVerify);

    }

    @Test
    public void getWinThreshold() throws Exception {
        Poll testPollTemp = new Poll("Win Threshold Test Poll");
        testPollTemp.setVotes(new ArrayList<Vote>());
        assertEquals("Empty vote array handled incorrectly", -1, poll.getWinThreshold());
        ArrayList<Vote> testVotes = new ArrayList<Vote>();
        testVotes.add(new Vote(1));
        testVotes.add(new Vote(2));
        testVotes.add(new Vote(3));
        testVotes.add(new Vote(4));
        testVotes.add(new Vote(5));
        testVotes.add(new Vote(6));
        poll.setVotes(testVotes);
        assertEquals("Bad win threshold for even number of votes", 3, poll.getWinThreshold());
        testVotes.add(new Vote(7));
        poll.setVotes(testVotes);
        assertEquals("Bad win threshold for odd number of votes", 3, poll.getWinThreshold());
    }

    @Test
    public void getChoiceNameById() throws Exception {
        assertEquals("Wrong name returned for choice 1", "Test Choice A", poll.getChoiceNameById(1));
        assertEquals("Wrong name returned for choice 2", "Test Choice B", poll.getChoiceNameById(2));

    }

}