package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Poll;
import com.irvingmichael.irv.entity.Voter;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Aaron Anderson on 10/9/16.
 */
public class PollDao extends GenericDao {

    private final Logger log = Logger.getLogger("debugLogger");

    public PollDao() {
        super(Poll.class);
    }

    public List<Poll> getAllPollsByVoterId(int voterId) {
        List<Poll> polls;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        polls = session.createCriteria(Poll.class)
                .add(Restrictions.eq("creator", voterId))
                .addOrder(Order.desc("pollid"))
                .list();
        session.close();
        log.debug(polls.size());
        return polls;
    }

    public Poll getPollByPollcode(String pollcode) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (Poll) session.createCriteria(Poll.class)
                .add(Restrictions.eq("pollcode", pollcode))
                .list()
                .get(0);
    }

    public Boolean registerVoterForPoll(String pollcode, int voterId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Poll> polls  = session.createCriteria(Poll.class)
                .add(Restrictions.eq("pollcode", pollcode))
                .list();
        if (polls.size() > 0) {
            Poll poll  = polls.get(0);
            Transaction tx = session.beginTransaction();
            SQLQuery sql = session.createSQLQuery("INSERT INTO VotersPolls (`voterid`, `pollid`) VALUES (:voter, :poll)");
            sql.setParameter("voter", voterId);
            sql.setParameter("poll", poll.getPollid());
            sql.executeUpdate();
            tx.commit();
            return true;
        } else {
            return false;
        }
    }

    public List<Poll> getAllPollsByEmail(String email) {
        VoterDao voterDao = new VoterDao();
        return getAllPollsByVoterId(voterDao.getVoterByEmail(email).getVoterId());
    }
}
