package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.persistance.PollDao;
import com.irvingmichael.irv.persistance.VoterDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aaron Anderson on 11/9/16.
 */
@WebServlet( name = "usepollcode", urlPatterns = { "/voter-access/usepollcode" } )
public class UsePollCode extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");
    private final static String TARGET = "/voter-access/mypolls";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VoterDao voterDao = new VoterDao();
        Voter voter = voterDao.getVoterByEmail(request.getRemoteUser());

        PollDao pollDao = new PollDao();
        pollDao.registerVoterForPoll(request.getParameter("newpollcode"), voter.getVoterId());

        RequestDispatcher rd = getServletContext().getRequestDispatcher(TARGET);
        rd.forward(request, response);

    }
}
