package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Choice;
import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.Vote;
import com.irvingmichael.irv.entity.Voter;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aaron on 11/29/16.
 */

@WebServlet( name = "castvote", urlPatterns = { "/voter-access/castvote" })
public class CastVote extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");
    private final static String TARGET = "mypolls";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Vote newVote = new Vote();

        PollDao pollDao = new PollDao();
        Poll poll = (Poll) pollDao.getById(Integer.parseInt(request.getParameter("pollid")));
        newVote.setPollId(poll.getPollid());

        VoterDao voterDao = new VoterDao();
        Voter voter = voterDao.getVoterByEmail(request.getRemoteUser());
        newVote.setVoterId(voter.getVoterId());

        ChoiceDao choiceDao = new ChoiceDao();
        List<Choice> choices = choiceDao.getAllChoicesForPoll(poll.getPollid());

        LinkedHashMap<Integer, Integer> rankings = new LinkedHashMap<>();
        for (Choice choice : choices) {
            int rank = Integer.parseInt(request.getParameter(Integer.toString(choice.getChoiceid())));
            rankings.put(choice.getChoiceid(), rank);
        }
        newVote.setVoteRankings(rankings);

        VoteDao voteDao = new VoteDao();
        voteDao.recordRankingsInDatabase(newVote);

        response.sendRedirect(TARGET);
    }
}
