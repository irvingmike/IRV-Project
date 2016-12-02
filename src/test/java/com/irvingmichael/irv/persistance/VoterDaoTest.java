package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Voter;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/4/16.
 */
public class VoterDaoTest {
    @Test
    public void getNotifyVoterForPoll() throws Exception {
        VoterDao voterDao = new VoterDao();
        int voterid = 1;
        int pollid = 3;
        assertFalse(voterDao.getNotifyVoterForPoll(voterid, pollid));
    }

    @Test
    public void toggleNotifyForVoterInPoll() throws Exception {
        VoterDao voterDao = new VoterDao();
        int voterid = 1;
        int pollid = 1;
        Boolean notifyOrg = voterDao.getNotifyVoterForPoll(voterid, pollid);
        voterDao.toggleNotifyForVoterInPoll(voterid, pollid);
        Boolean notifyChg = voterDao.getNotifyVoterForPoll(voterid, pollid);
        assertEquals("Bad notify toggle", notifyOrg, !notifyChg);
    }

    @Test
    public void getVoterByEmail() throws Exception {
        VoterDao voterDao = new VoterDao();
        String email = "irvingmichael@gmail.com";
        Voter voter = voterDao.getVoterByEmail(email);
        assertEquals("Bad voter returned by getVoterByEmail", 11, voter.getVoterId());
    }

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void setPasswordInDB() throws Exception {
        VoterDao voterDao = new VoterDao();
        voterDao.setPasswordInDB(2, "testpass");
    }

    @Test
    public void testGetAllVotersForPoll() throws Exception {
        VoterDao voterDao = new VoterDao();
        assertEquals("Incorrect number of voters retrieved", 10, voterDao.getAllVotersForPoll(1).size());
    }
}
