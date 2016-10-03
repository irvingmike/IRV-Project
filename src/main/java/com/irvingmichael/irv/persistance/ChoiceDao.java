package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.Choice;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Anderson on 10/3/16.
 */
public class ChoiceDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all choices in the database
     * @return
     */
    public List<Choice> getAllChoices() {
        List<Choice> choices;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        choices = session.createCriteria(Choice.class).list();
        session.close();
        return choices;
    }
}
