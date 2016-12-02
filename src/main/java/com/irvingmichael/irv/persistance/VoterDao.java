package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.factories.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Objects;

/**
 * Created by Aaron Anderson on 10/4/16.
 */
public class VoterDao<T> extends GenericDao {

    private Session session = SessionFactoryProvider.getSessionFactory().openSession();
    private final Logger log = Logger.getLogger("debugLogger");

    /**
     * Empty constructor
     */
    public VoterDao() { super(Voter.class); }

    /**
     * Retrieve a list of voter for a specified poll
     * @param pollId Poll id to get all the voter for
     * @return List of voters for the poll
     */
    public List<Voter> getAllVotersForPoll(int pollId) {
        List<Voter> voters = session.createSQLQuery("SELECT Voters.voterid, Voters.firstname, Voters.lastname, Voters.email, Voters.securedby FROM Voters JOIN VotersPolls ON Voters.voterid = VotersPolls.voterid WHERE VotersPolls.pollid = " + pollId).addEntity(Voter.class).list();
        return voters;
    }

    /**
     * Retrieve all voters for a poll that have requested to be notified.
     * @param pollid Id of poll to notify people for
     * @return List of voters requesting to be notified
     */
    public List<Voter> getAllVotersForPollToNotify(int pollid) {
        List<Voter> voters = session.createSQLQuery("SELECT Voters.voterid, Voters.firstname, Voters.lastname, Voters.email, Voters.securedby FROM Voters JOIN VotersPolls ON Voters.voterid = VotersPolls.voterid WHERE VotersPolls.notify = 1 AND VotersPolls.pollid = " + pollId).addEntity(Voter.class).list();
        return voters;
    }

    /**
     * Set the password for the specified voter in the Voters database
     * @param id Id of the voter to set the password for
     * @param password Hashed password to store in database
     */
    public void setPasswordInDB(int id, String password) {
        Transaction tx = session.beginTransaction();
        SQLQuery sql = session.createSQLQuery("UPDATE Voters SET securedby=:pass WHERE voterid=:id");
        sql.setString("pass", password);
        sql.setParameter("id", id);
        sql.executeUpdate();
        tx.commit();
    }

    /**
     * Get the voter associated with specified email
     * @param email Email to get voter for
     * @return Voter with specified email
     */
    public Voter getVoterByEmail(String email) {
        return (Voter) session.createCriteria(Voter.class)
                .add(Restrictions.eq("email", email))
                .list()
                .get(0);
    }

    /**
     * Verifies that valid voter credentials were supplied
     * @param email Email of voter to validate
     * @param password Password of voter to validate
     * @return True if the voter credentials are valid
     */
    public Boolean verifyUser(String email, String password) {
        Transaction tx = session.beginTransaction();
        SQLQuery sql = session.createSQLQuery("SELECT voterId FROM Voters WHERE email=:email AND securedby=:pass");
        sql.setString("email", email);
        sql.setString("pass", password);
        Object valid = sql.uniqueResult();
        tx.commit();

        return Objects.nonNull(valid);
    }

    /**
     * Validate a voter is in the database
     * @param voterId Voter id find in database
     * @return True if voter exists
     */
    public Boolean validateVoterId(int voterId) {
        Transaction tx = session.beginTransaction();
        SQLQuery sql = session.createSQLQuery("SELECT * FROM Voters WHERE voterid=:id");
        sql.setParameter("id", voterId);
        Object valid = sql.uniqueResult();
        tx.commit();
        return Objects.nonNull(valid);
    }

    /**
     * Gets the current notify status of a voter/poll combination.
     * @param voterid Voter to check the notify status for
     * @param pollid Poll to check the notify status of
     * @return True if voter wants to be notified
     */
    public Boolean getNotifyVoterForPoll(int voterid, int pollid) {
        Transaction tx = session.beginTransaction();
        SQLQuery sql = session.createSQLQuery("SELECT `notify` FROM VotersPolls WHERE voterid=:idvoter AND pollid=:idpoll");
        sql.setParameter("idvoter", voterid);
        sql.setParameter("idpoll", pollid);
        List<Boolean> result = sql.list();
        tx.commit();
        return result.get(0);
    }

    /**
     * Toggle the boolean in the database for a poll/voter combination as to wether or not to notify the user upon completion of the poll.
     * @param voterid Id of the voter to notify
     * @param pollid Id of the poll to notify for
     */
    public void toggleNotifyForVoterInPoll(int voterid, int pollid) {
        Transaction tx = session.beginTransaction();
        SQLQuery sql = session.createSQLQuery("UPDATE VotersPolls SET `notify` = IF (`notify`, 0, 1) WHERE voterid=:idvoter AND pollid=:idpoll");
        sql.setParameter("idvoter", voterid);
        sql.setParameter("idpoll", pollid);
        sql.executeUpdate();
        tx.commit();
    }

    /**
     * Closes the session when the object is garbage collected
     */
    @Override
    protected void finalize() {
        session.close();
    }

}
