package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Choice;
import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.persistance.ChoiceDao;
import com.irvingmichael.irv.persistance.PollDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by aaron on 11/23/16.
 */
@WebServlet( name = "voteinpoll", urlPatterns = { "/voter-access/voteinpoll" } )
public class VoteInPoll  extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");
    private final static String TARGET = "/voter-access/votingInPoll.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PollDao pollDao = new PollDao();
        int pollId = Integer.parseInt(request.getParameter("pollid"));
        Poll poll = (Poll) pollDao.getById(pollId);

        ChoiceDao choiceDao = new ChoiceDao();
        poll.setChoices((ArrayList<Choice>) choiceDao.getAllChoicesForPoll(pollId));

        request.setAttribute("poll", poll);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(TARGET);
        rd.forward(request, response);

    }
}
