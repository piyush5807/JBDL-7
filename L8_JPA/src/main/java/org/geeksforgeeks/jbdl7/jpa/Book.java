package org.geeksforgeeks.jbdl7.jpa;

import javax.persistence.*;

@Entity
@IdClass(BookPrimaryKey.class)
public class Book {

    // book

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;

    @Id
    private String name;

    @Id
    private String authorName;

    @Column(name = "price")
    private int cost;

//    @JoinColumn
//    Person person;

//    public Book(String name, String authorName, int cost) {
//        this.name = name;
//        this.authorName = authorName;
//        this.cost = cost;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
