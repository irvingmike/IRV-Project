package com.irvingmichael.irv;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by aaron on 9/10/16.
 */

@Entity
@Table(name = "choices")
public class Choice {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "choiceId")
    private int id;
    private String name;

    public Choice() {};

    public Choice(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
