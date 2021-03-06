package org.geeksforgeeks.jbdl7.jdbc;

public class Book {

    private int id;
    private String name;
    private String authorName;
    private int cost;

    public Book(int id, String name, String authorName, int cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
        this.id = id;
    }

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
}
