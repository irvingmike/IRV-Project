package com.irvingmichael.irv;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 9/10/16.
 */
public class ChoiceTest {

    Choice choice = new Choice(1, "test name");

    @Test
    public void Choice() {
        assertEquals("Id doesn't match what was supplied", 1, choice.getId());
        assertEquals("Name doesn't match what was supplied", "test name", choice.getName());
    }
}