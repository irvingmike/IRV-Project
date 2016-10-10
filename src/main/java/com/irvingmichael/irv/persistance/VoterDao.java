package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Choice;
import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.persistance.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Anderson on 10/4/16.
 */
public class VoterDao extends GenericDao {

    public VoterDao() { super(Choice.class); }

    List<Voter> getAllVotersForPoll(int pollId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        List<Voter> voters;
        voters = session.createSQLQuery("SELECT Voters.voterid, Voters.firstname, Voters.lastname, Voters.email FROM Voters JOIN VotersPolls ON Voters.voterid = VotersPolls.voterid WHERE VotersPolls.pollid = 1").addEntity(Voter.class).list();
        return voters;
    }
}
