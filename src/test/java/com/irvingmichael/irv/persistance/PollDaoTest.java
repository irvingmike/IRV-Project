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

    private PollDao pollDao;

    public PollDaoTest() {
        pollDao = new PollDao();
    }

    @Test
    public void isVoterRegisterdForPoll() throws Exception {
        assertTrue(pollDao.isVoterRegisterdForPoll(1,1));
        assertFalse(pollDao.isVoterRegisterdForPoll(11,1));
    }

    @Test
    public void pollsVoterIsRegisterFor() throws Exception {
        assertTrue(pollDao.pollsVoterIsRegisterFor(1).size() == 3);
        assertTrue(pollDao.pollsVoterIsRegisterFor(3).size() == 1);
    }

    @Test
    public void getAllPollsByVoterId() throws Exception {
        List<Poll> polls = pollDao.getAllPollsByVoterId(1);
        assertTrue(polls.size() > 0);
    }

}