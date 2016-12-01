package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.factories.PollFactory;
import com.irvingmichael.irv.persistance.PollDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aaron on 11/30/16.
 */

@WebServlet( name = "determinewinner", urlPatterns = { "/voter-access/determinewinner" })
public class DetermineWinner extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pollid = Integer.parseInt(request.getParameter("pollid"));
        Poll poll = PollFactory.getPoll(pollid);
        poll.completePoll();

        PollDao pollDao = new PollDao();
        pollDao.update(poll);

        response.sendRedirect("viewpoll?pollid=" + pollid);

    }
}
