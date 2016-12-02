package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.PollStatus;
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

@WebServlet( name = "changepollstatus", urlPatterns = { "/voter-access/changepollstatus" })
public class ChangePollStatus extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");
    private final static String TARGET = "viewpoll?pollid=";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pollid = Integer.parseInt(request.getParameter("pollid"));
        String status = request.getParameter("status").toUpperCase();

        Poll poll = PollFactory.getPoll(pollid);
        poll.setStatus(PollStatus.valueOf(status));
        PollDao pollDao = new PollDao();
        pollDao.update(poll);

        response.sendRedirect(TARGET + pollid);
    }
}
