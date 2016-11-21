package com.irvingmichael.irv.util;

import org.apache.catalina.realm.RealmBase;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/25/16.
 */
public class HashTestTool {

    private final Logger log = Logger.getLogger("debugLogger");

    @Test
    public void makeHashOfString() throws Exception{

        // Voter password hashing
        String toHash = "voterpass";
        String hashedString = Secure.hash(toHash);
        assertEquals("Bad Hash", "1cf311c819be2d73ab4a3c8cb5327418c4f9e30cb17adb4c9330272fcc8e984c", hashedString);

        // Admin password hashing
        toHash = "adminpass";
        hashedString = Secure.hash(toHash);
        assertEquals("Bad Hash", "713bfda78870bf9d1b261f565286f85e97ee614efe5f0faf7c34e7ca4f65baca", hashedString);
    }
}
