package com.irvingmichael.irv;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by aaron on 9/10/16.
 */
public class PollTest {

    Poll poll = new Poll(1, "test");

    @Test
    public void getPollCode() throws Exception {
        String pollCode = poll.getPollCode();
        String pollCodeVerify = poll.getPollCode();

        assertEquals("Poll code generated at incorrect size", 8, pollCode.length());
        assertTrue(pollCode == pollCodeVerify);

    }

    @Test
    public void getWinThreshold() throws Exception {
        poll.setVotes(new ArrayList<Vote>());
        assertEquals("Empty vote array handle incorrectly", -1, poll.getWinThreshold());
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

}