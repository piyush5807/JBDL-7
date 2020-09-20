package org.geeksforgeeks.jbdl7.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Person {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

//    @Id
    private String name;

//    public Person(String name) {
//        this.name = name;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
