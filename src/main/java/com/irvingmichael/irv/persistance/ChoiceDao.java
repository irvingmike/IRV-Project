package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Choice;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Dao class for accessing the Choice information in database
 *
 * @author Aaron Anderson
 */
public class ChoiceDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all choices in the database
     * @return
     */
    public List<Choice> getAllChoicesForPoll(int pollid) {
        List<Choice> choices;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        choices = session.createCriteria(Choice.class)
                .add(Restrictions.eq("pollId", pollid))
                .addOrder(Order.asc("name"))
                .list();
        session.close();
        return choices;
    }

    public Choice getChoiceById(int choiceId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Choice choice = (Choice) session.get(Choice.class, choiceId);
        session.close();
        return choice;
    }

    public int addChoice(Choice choice) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int id = 0;
        Transaction tx = session.beginTransaction();
        id = (Integer) session.save(choice);
        tx.commit();
        session.close();
        return id;
    }
}
