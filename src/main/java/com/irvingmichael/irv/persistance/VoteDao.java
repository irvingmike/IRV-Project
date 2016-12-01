package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Vote;
import com.irvingmichael.irv.factories.SessionFactoryProvider;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron Anderson
 */
public class VoteDao extends GenericDao {

    private final Logger log = Logger.getLogger("debugLogger");
    Session session = SessionFactoryProvider.getSessionFactory().openSession();

    /**
     * Empty constructor
     */
    public VoteDao() {
        super(Vote.class);
    }

    /**
     * Get a vote for a specified user in a specified poll
     * @param voterId Id of voter to get vote for
     * @param pollId Id of poll the vote is in
     * @return Specified vote
     */
    public Vote getVoteByVoterIdPollId(int voterId, int pollId) {
        Vote vote = new Vote(voterId, pollId);

        LinkedHashMap<Integer, Integer> tempMap = new LinkedHashMap<Integer, Integer>();

        String sqlQuery = "SELECT choiceid, rank FROM Votes WHERE voterid = " + voterId + " AND pollid = " + pollId + " ORDER BY choiceid";

        List<Object[]> rows = session.createSQLQuery(sqlQuery).list();

        if (rows.size() == 0) { return null; }

        for (Object[] row : rows) {
            int choiceId = (int) row[0];
            int rank = (int) row[1];
            tempMap.put(choiceId, rank);
        }

        vote.setCurrentRankings(tempMap);
        vote.setVoteRankings(tempMap);

        return vote;
    }

    public ArrayList<Vote> getAllVotesForPoll(int pollid) {
        ArrayList<Vote> votes = new ArrayList<>();
        String sqlQuery = "SELECT DISTINCT `voterid` FROM Votes WHERE pollid = " + pollid;
        List<Integer> voters = session.createSQLQuery(sqlQuery).list();

        for (int voterid : voters) {
            votes.add(getVoteByVoterIdPollId(voterid, pollid));
        }
        return votes;
    }

    /**
     * Store supplied vote in the database
     * @param vote Vote to store in database
     * @return True if vote is stored in database
     */
    public Boolean recordRankingsInDatabase(Vote vote) {
        Boolean success = false;
        try {
            for (Map.Entry<Integer, Integer> entry : vote.getVoteRankings().entrySet()) {
                Transaction tx = session.beginTransaction();
                SQLQuery sql = session.createSQLQuery("INSERT INTO Votes (`voterid`, `pollid`, `choiceid`, `rank`) VALUES (:voter, :poll, :choice, :rank)");
                sql.setParameter("voter", vote.getVoterId());
                sql.setParameter("poll", vote.getPollId());
                sql.setParameter("choice", entry.getKey());
                sql.setParameter("rank", entry.getValue());
                sql.executeUpdate();
                tx.commit();
                success = true;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return success;
    }

}
