package com.irvingmichael.irv.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.irvingmichael.irv.entity.Choice;
import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.persistance.ChoiceDao;
import com.irvingmichael.irv.persistance.PollDao;
import com.irvingmichael.irv.persistance.VoterDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Aaron Anderson on 11/7/16.
 */
@WebServlet( name = "generatenewpoll", urlPatterns = { "/voter-access/generatenewpoll" } )
public class GenerateNewPoll extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("In generate new poll servlet");

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(request.getParameter("json"), JsonObject.class);

        Poll poll = new Poll(jsonObject.get("title").getAsString());
        poll.setDescription(jsonObject.get("description").getAsString());
        poll.setAvailable(false);
        log.debug("Pollcode: " + poll.getPollcode());

        JsonArray jsonChoices = jsonObject.getAsJsonArray("choices");

        ArrayList<Choice> newChoices = new ArrayList<Choice>();
        for (JsonElement jsonChoice : jsonChoices) {
            Choice choice = new Choice(jsonChoice.getAsString());
            newChoices.add(choice);
        }
        poll.setChoices(newChoices);

        VoterDao voterDao = new VoterDao();
        Voter voter = voterDao.getVoterByEmail(request.getRemoteUser());
        poll.setCreator(voter.getVoterId());

        PollDao pollDao = new PollDao();
        poll.setPollid(pollDao.create(poll));

        ChoiceDao choiceDao = new ChoiceDao();
        for (Choice choice : poll.getChoices()) {
            choice.setPollId(poll.getPollid());
            choiceDao.create(choice);
            log.debug(choice.getName());
        }

        pollDao.registerVoterForPoll(poll.getPollcode(), poll.getCreator());
    }
}
