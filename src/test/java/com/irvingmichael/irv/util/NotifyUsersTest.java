package com.irvingmichael.irv.util;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by aaron on 12/1/16.
 */
public class NotifyUsersTest {
    @Test
    public void sendSingleEmail() throws Exception {
        try {
            NotifyUsers.sendSingleEmail("irvingmichael@mac.com",
                    "irvingmichael@gmail.com",
                    "Send Single Email Test",
                    "If you are seeing this this test worked.");
            assertTrue(true);
        } catch (IOException e) {
            assertEquals("Bad sending email attempt", e, new IOException());
        }
    }

}