package com.irvingmichael.irv.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Choice class testing.
 *
 * @author Aaron Anderson
 */
public class ChoiceTest {

    @Test
    public void Choice() {
        Choice choice = new Choice();
        choice.setName("Test Choice");
        choice.setChoiceid(1);
        assertEquals("Id doesn't match what was supplied", 1, choice.getChoiceid());
        assertEquals("Name doesn't match what was supplied", "Test Choice", choice.getName());
    }
}