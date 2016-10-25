package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.VoterPollsPage;
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
import java.util.List;

/**
 * Created by Aaron Anderson on 10/21/16.
 */

@WebServlet(
        name = "mypolls",
        urlPatterns = { "/voter-access/mypolls" }
)
public class MyPolls extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Poll> polls = VoterPollsPage.getPollsForCurrentVoter(request);
        log.debug("Test poll status: " + polls.get(0).getStatus().getClassString());
        request.setAttribute("polls", polls);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/voter-access/myPolls.jsp");
        rd.forward(request, response);

    }
}
