package com.irvingmichael.irv.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Choice class to store information about a choice for a poll.
 *
 * @author Aaron Anderson
 */

@Entity
@Table(name = "Choices")
public class Choice {

    @Id
    @GeneratedValue
    @Column(name = "choiceid")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "pollid")
    private int pollId;

    public Choice() {}

    public Choice(String name) { this(); this.name = name; }

    Choice(int id, String name) { this(name); this.id = id; }

    void setId(int id) { this.id = id; }

    public int getId() {
        return id;
    }

    void setName(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    void setDescription(String description) { this.description = description; }

    public String getDescription() { return description; }

    int getPollId() { return pollId; }

    void setPollId(int pollId) { this.pollId = pollId; }

}
