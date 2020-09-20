package org.geeksforgeeks.jbdl7.jpa;

import javax.persistence.*;

@Entity
//@IdClass(BookPrimaryKey.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String authorName;

    @Column(name = "price")
    private int cost;

    // Many - One

    @ManyToOne
    @JoinColumn(name = "joined_bookCategory")
    private BookCategory bookCategory;

//    @JoinColumn
//    Person person;

//    public Book(String name, String authorName, int cost) {
//        this.name = name;
//        this.authorName = authorName;
//        this.cost = cost;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
