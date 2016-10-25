package com.irvingmichael.irv.entity;

import com.irvingmichael.irv.persistance.PollDao;
import com.irvingmichael.irv.persistance.VoterDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Aaron Anderson on 10/21/16.
 */
public final class VoterPollsPage {

    private final static Logger log = Logger.getLogger("debugLogger");

    public final static List<Poll> getPollsForCurrentVoter (HttpServletRequest request) {
        PollDao pollDao = new PollDao();
        return pollDao.getAllPollsByEmail(request.getUserPrincipal().getName());
    }
}
