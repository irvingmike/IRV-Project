package com.irvingmichael.irv.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by Aaron Anderson on 10/14/16.
 */

/*
 * Working hash (make changes to db and then use these to log in to have it work)
  * Username: fake1@fake.com
  * Password: voterpass
  * Hash: cae5ac5bc4ad1283dd3a86d0389703e7dbe478e822dcd2af29287f21de21514a$1$de547961838becf96955450f9b984a8d18cfe541f0f1419ec018f3ac873be02a
 */
public final class SecurityTools {

    private final static Logger log = Logger.getLogger("debugLogger");

    public final static String hashString(String stringToHash) {
        String encryptedString = "Bad hash";
        encryptedString = org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringToHash);
        //encryptedString = Hashing.sha256().hashString(stringToHash, Charsets.UTF_8).toString();
        /*
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(stringToHash.getBytes());
            encryptedString = new String(messageDigest.digest(), "UTF-8");
            encryptedString = Hex.encodeHexString(encryptedString.getBytes());;
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        };*/
        return encryptedString;
    }
}
