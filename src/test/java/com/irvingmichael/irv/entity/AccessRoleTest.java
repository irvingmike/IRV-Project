package com.irvingmichael.irv.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/14/16.
 */
public class AccessRoleTest {
    @Test
    public void setNewRole() throws Exception {
        AccessRole testRole = new AccessRole("fake2@fake.com", "voterStd");
        testRole.setNewRole();
    }

}