package com.irvingmichael.irv.entity;

import com.irvingmichael.irv.persistance.GenericDao;
import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Created by Aaron Anderson on 10/14/16.
 */

@Entity
@Table(name = "AccessRoles")
public class AccessRole {

    @Id
    @GeneratedValue
    @Column(name="accessroleid")
    private int accessRoleId;

    @Column(name = "email")
    private String email;

    @Column(name = "accessrole")
    private String accessrole;

    public AccessRole() {}

    public AccessRole(String email, String accessrole) {
        this();
        this.email = email;
        this.accessrole = accessrole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessrole() {
        return accessrole;
    }

    public void setAccessrole(String accessrole) {
        this.accessrole = accessrole;
    }

    public int getAccessRoleId() {
        return accessRoleId;
    }

    public void setAccessRoleId(int accessRoleId) {
        this.accessRoleId = accessRoleId;
    }

    public int setNewRole() {
        GenericDao<AccessRole> dao = new GenericDao<>(AccessRole.class);
        return dao.create(this);
    }

}
