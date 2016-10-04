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
        ChoiceDao choice001 = new ChoiceDao();
        assertEquals("Wrong number of choices returned", 4, choice001.getAllChoicesForPoll(1).size());
    }

    @Test
    public void getUserById() throws Exception {
        ChoiceDao choiceDao001 = new ChoiceDao();
        assertEquals("Bad name returned for choice", "Choice A", choiceDao001.getChoiceById(1).getName());
    }

    @Test
    public void addChoice() throws Exception {
        ChoiceDao choiceDao002 = new ChoiceDao();
        Choice choice002 = new Choice("Add Choice Test", 1);
        int choiceId001 = choiceDao002.addChoice(choice002);
        assertTrue(choiceId001 > 0);
        choiceDao002.deleteChoice(choiceId001);
    }

    @Test
    public void deleteChoice() throws Exception {
        ChoiceDao choiceDao003 = new ChoiceDao();
        Choice choice003 = new Choice("Add Choice Test", 1);
        int choiceId002 = choiceDao003.addChoice(choice003);
        assertTrue(choiceDao003.getChoiceById(choiceId002).getName().equals("Add Choice Test"));
        choiceDao003.deleteChoice(choiceId002);
        choiceDao003.getChoiceById(choiceId002);
        assertEquals("Bad delete choice occured", null, choiceDao003.getChoiceById(choiceId002));
    }

    @Test
    public void updateChoice() throws Exception {
        ChoiceDao choiceDao004 = new ChoiceDao();
        Choice choice004 = new Choice("Add Choice Test", 1);
        int choiceId003 = choiceDao004.addChoice(choice004);
        choice004.setDescription("New description");
        choiceDao004.updateChoice(choice004);
        Choice choice005 = choiceDao004.getChoiceById(choiceId003);
        assertEquals("Choice didn't update correctly", "New description", choice005.getDescription());
        choiceDao004.deleteChoice(choiceId003);
    }

}