package com.irvingmichael.irv.util;

import org.apache.catalina.realm.RealmBase;

public final class Secure {

    public static String hash(String stringToHash) {
        return RealmBase.Digest(stringToHash, "Sha-256", "UTF-8");
    }

}
