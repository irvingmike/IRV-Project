package com.irvingmichael.irv.factories;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.PollStatus;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 11/30/16.
 */
public class PollFactoryTest {
    @Test
    public void getPoll() throws Exception {
        Poll poll = PollFactory.getPoll(1);

        assertEquals("Bad poll title", "Test Poll", poll.getTitle());
        assertNotEquals("Bad poll id", null, poll.getPollid());
        assertTrue(poll.getAvailable() || !poll.getAvailable());
        assertTrue(poll.getCreator() == 1);
        assertTrue(poll.getPollcode().equals("abcdefgh"));
        assertTrue(poll.getStatus().getClass().getSimpleName().equals("PollStatus"));
        assertTrue(poll.getChoices().size() == 4);
        assertTrue(poll.getVotes().size() >= 10);
    }

}