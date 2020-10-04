package org.geeksforgeeks.jbdl7.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    private String name;
    private String authorName;
    private String cost;

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
