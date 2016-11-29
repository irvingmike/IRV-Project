package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.PollStatus;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/21/16.
 */
public class PollDaoTest {
    @Test
    public void getAllPollsByVoterId() throws Exception {
        PollDao pollDao = new PollDao();
        List<Poll> polls = pollDao.getAllPollsByVoterId(1);
        assertTrue(polls.size() > 0);

        Poll poll = polls.get(polls.size() - 1);
        assertEquals("Bad polls status", PollStatus.OPEN, poll.getStatus());
        assertEquals("Bad poll name returned for oldest poll", "Test Poll", poll.getTitle());
    }

}