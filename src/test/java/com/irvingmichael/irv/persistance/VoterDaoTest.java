package com.irvingmichael.irv.persistance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/4/16.
 */
public class VoterDaoTest {

    @Test
    public void testGetAllVotersForPoll() throws Exception {
        VoterDao voterDao = new VoterDao();
        assertEquals("Incorrect number of voters retrieved", 10, voterDao.getAllVotersForPoll(1).size());
    }
}
