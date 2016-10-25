package com.irvingmichael.irv.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/14/16.
 */
public class SecurityToolsTest {

    private final Logger log = Logger.getLogger("debugLogger");

    @Test
    public void hashString() throws Exception {
        String testString = SecurityTools.hashString("voterpass");
        log.debug(testString);
        //assertEquals("Bad hash returned", "cae5ac5bc4ad1283dd3a86d0389703e7dbe478e822dcd2af29287f21de21514a$1$de547961838becf96955450f9b984a8d18cfe541f0f1419ec018f3ac873be02a", testString);
    }

}