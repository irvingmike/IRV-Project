package com.irvingmichael.irv.entity;

import com.irvingmichael.irv.persistance.GenericDao;
import org.apache.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Aaron Anderson on 10/14/16.
 */

@Entity
@Table(name = "AccessRoles")
public class AccessRole {

    @Id
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

    public void setNewRole() {
        GenericDao<AccessRole> dao = new GenericDao<>(AccessRole.class);
        dao.create(this);
    }

}
