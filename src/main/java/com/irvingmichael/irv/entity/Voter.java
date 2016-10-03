package com.irvingmichael.irv.entity;

/**
 * Created by aaron on 9/10/16.
 */
public class Voter {

    private int voterId;
    private String firstName;
    private String lastName;
    private String email;

    public Voter(int id, String email) {
        voterId = id;
        email = this.email;
    }

    public int getVoterId() {
        return voterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
}
