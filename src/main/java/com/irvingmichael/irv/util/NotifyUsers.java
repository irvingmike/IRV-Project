package com.irvingmichael.irv.util;

import java.io.IOException;
import java.util.List;

import com.irvingmichael.irv.entity.Choice;
import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.factories.PollFactory;
import com.irvingmichael.irv.persistance.ChoiceDao;
import com.irvingmichael.irv.persistance.VoterDao;
import org.apache.http.client.fluent.*;
import org.apache.log4j.Logger;

/**
 * Created by aaron on 12/1/16.
 */
public final class NotifyUsers {

    private final static Logger log = Logger.getLogger("debugLogger");

    /**
     * Notify all users that requested notification for a poll by sending them an email.
     * @param pollid Id of poll to notify voters for
     */
    public static void byEmail(int pollid) {

        Poll poll = PollFactory.getPoll(pollid);

        VoterDao voterDao = new VoterDao();
        ChoiceDao choiceDao = new ChoiceDao();

        String winner = ((Choice) choiceDao.getById(poll.getWinner())).getName();
        String from = ((Voter) voterDao.getById(poll.getCreator())).getEmail();

        List<Voter> voters = voterDao.getAllVotersForPollToNotify(pollid);

        String subject = "Poll: " + poll.getTitle() + " is completed!";
        String body = "The poll " + poll.getTitle() + " is completed and the winner is " + winner + "!";

        for (Voter voter : voters) {
            try {
                sendSingleEmail(from, voter.getEmail(), subject, body);
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    /**
     * Send a single email via MailGun
     * @param from email address to send email from
     * @param to email address to send to
     * @param subject Subject of email
     * @param body Body of email
     * @throws IOException
     */
    public static void sendSingleEmail(String from, String to, String subject, String body) throws IOException {
        try {

            // Create request
            Content content = Request.Post("https://api.mailgun.net/v3/irvingmichael.com/messages")

            // Add headers
            .addHeader("Authorization", "Basic YXBpOmtleS01ZjRmNWZhMGFlNDAyMThhYjU4Nzc4NjYzZjZiY2NjNA==")
            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")

            // Add body
            .bodyForm(Form.form()
                    .add("from", from)
                    .add("to", to)
                    .add("subject", subject)
                    .add("text", body)
                    .build())

            // Fetch request and return content
            .execute().returnContent();

            // Log content for debugging
            log.debug(content);

        } catch (IOException e) {
            log.error(e);
            throw e;
        }
    }
}
