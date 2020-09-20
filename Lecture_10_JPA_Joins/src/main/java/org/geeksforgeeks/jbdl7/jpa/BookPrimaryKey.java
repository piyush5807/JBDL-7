package org.geeksforgeeks.jbdl7.jpa;

import java.io.Serializable;

public class BookPrimaryKey implements Serializable {

    private String name;
    private String authorName;

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
}
