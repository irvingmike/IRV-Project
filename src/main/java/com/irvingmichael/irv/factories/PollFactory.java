package com.irvingmichael.irv.factories;

import com.irvingmichael.irv.entity.Choice;
import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.Vote;
import com.irvingmichael.irv.persistance.ChoiceDao;
import com.irvingmichael.irv.persistance.PollDao;
import com.irvingmichael.irv.persistance.VoteDao;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by aaron on 11/30/16.
 */
public final class PollFactory {

    public static Poll getPoll(int pollid) {

        PollDao pollDao = new PollDao();
        ChoiceDao choiceDao = new ChoiceDao();
        VoteDao voteDao = new VoteDao();
        Poll poll = null;

        poll = (Poll) pollDao.getById(pollid);

        if (poll != null) {
            ArrayList<Choice> choices = (ArrayList<Choice>) choiceDao.getAllChoicesForPoll(pollid);
            poll.setChoices(choices);

            ArrayList<Vote> votes = voteDao.getAllVotesForPoll(pollid);
            poll.setVotes(votes);
        }

        return poll;
    }

}
