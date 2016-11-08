package com.irvingmichael.irv.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 11/7/16.
 */
public class SecureTest {
    @Test
    public void hash() throws Exception {
        System.out.println(Secure.hash("voterpass"));
    }

}