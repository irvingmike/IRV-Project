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
    List<Choice> getAllChoicesForPoll(int pollid) {
        List<Choice> choices;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        choices = session.createCriteria(Choice.class)
                .add(Restrictions.eq("pollId", pollid))
                .addOrder(Order.asc("name"))
                .list();
        session.close();
        return choices;
    }

    Choice getChoiceById(int choiceId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Choice choice = (Choice) session.get(Choice.class, choiceId);
        session.close();
        return choice;
    }

    int addChoice(Choice choice) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int id = 0;
        Transaction tx = session.beginTransaction();
        id = (Integer) session.save(choice);
        tx.commit();
        session.close();
        return id;
    }

    void deleteChoice(int choiceId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Choice choice = getChoiceById(choiceId);
        session.delete(choice);
        tx.commit();
        session.close();
    }

    void updateChoice(Choice choice) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(choice);
        session.flush();
        tx.commit();
        session.close();
    }
}
