package com.irvingmichael.irv.persistance;

import com.irvingmichael.irv.entity.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Aaron Anderson
 */
public class ChoiceDaoTest {
    @Test
    public void getAllChoicesForPoll() throws Exception {
        ChoiceDao choice = new ChoiceDao();
        assertEquals("Wrong number of choices returned", 4, choice.getAllChoicesForPoll(1).size());
    }

    @Test
    public void getUserById() throws Exception {
        ChoiceDao choiceDao = new ChoiceDao();
        assertEquals("Bad name returned for choice", "Choice A", choiceDao.getChoiceById(1).getName());
    }

    @Test
    public void addChoice() throws Exception {
        ChoiceDao choiceDao = new ChoiceDao();
        Choice choice = new Choice("Add Choice Test");
        int choiceId = choiceDao.addChoice(choice);
        assertTrue(choiceId > 0);
    }

}