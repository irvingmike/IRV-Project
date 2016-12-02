package com.irvingmichael.irv.entity;

import com.irvingmichael.irv.persistance.GenericDao;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Aaron Anderson on 10/14/16.
 */
public class AccessRoleTest {
    @Test
    public void setNewRole() throws Exception {
        AccessRole testRole = new AccessRole("fake2@fake.com", "voterStd");
        int roleid = testRole.setNewRole();
        GenericDao<AccessRole> dao = new GenericDao<>(AccessRole.class);
        AccessRole confirmRole = dao.getById(roleid);
        assertTrue(confirmRole.getEmail().equals(testRole.getEmail()));
        assertTrue(confirmRole.getAccessrole().equals(testRole.getAccessrole()));
    }

}