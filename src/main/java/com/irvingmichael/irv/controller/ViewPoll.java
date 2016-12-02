package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.*;
import com.irvingmichael.irv.persistance.ChoiceDao;
import com.irvingmichael.irv.persistance.PollDao;
import com.irvingmichael.irv.persistance.VoteDao;
import com.irvingmichael.irv.persistance.VoterDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Anderson on 11/9/16.
 */

@WebServlet( name = "viewpoll", urlPatterns = { "/voter-access/viewpoll" } )
public class ViewPoll extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PollDao pollDao = new PollDao();
        Poll poll = (Poll) pollDao.getById(Integer.parseInt(request.getParameter("pollid")));

        ChoiceDao choiceDao = new ChoiceDao();
        ArrayList<Choice> choices = (ArrayList<Choice>) choiceDao.getAllChoicesForPoll(poll.getPollid());
        log.debug("Choices found: " + choices.size());
        poll.setChoices(choices);

        if (poll.getWinner() == -1) {
            request.setAttribute("winner", "To Be Determined");
        } else {
            Choice winner = (Choice) choiceDao.getById(poll.getWinner());
            request.setAttribute("winner", winner.getName());
        }

        request.setAttribute("votable", false);
        VoterDao voterDao = new VoterDao();
        Voter voter = voterDao.getVoterByEmail(request.getRemoteUser());
        request.setAttribute("currentuser", voter.getVoterId());
        VoteDao voteDao = new VoteDao();
        Vote vote = voteDao.getVoteByVoterIdPollId(voter.getVoterId(), poll.getPollid());
        if (poll.getStatus() == PollStatus.OPEN &&
                vote == null &&
                pollDao.isVoterRegisterdForPoll(voter.getVoterId(), poll.getPollid())) {
            request.setAttribute("votable", true);
        }
        request.setAttribute("notify", voterDao.getNotifyVoterForPoll(voter.getVoterId(), poll.getPollid()));
        request.setAttribute("poll", poll);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/voter-access/viewPoll.jsp");
        rd.forward(request, response);
    }
}
