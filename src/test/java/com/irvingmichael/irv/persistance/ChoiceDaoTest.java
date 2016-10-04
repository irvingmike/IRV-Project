package com.irvingmichael.irv.persistance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/3/16.
 */
public class ChoiceDaoTest {
    @Test
    public void getAllChoices() throws Exception {
        ChoiceDao choice = new ChoiceDao();
        assertEquals("Wrong number of choices returned", 4, choice.getAllChoices().size());
    }

}