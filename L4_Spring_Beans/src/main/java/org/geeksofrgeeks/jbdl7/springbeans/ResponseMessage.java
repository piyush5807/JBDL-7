package org.geeksofrgeeks.jbdl7.springbeans;

import java.util.List;

public class ResponseMessage {
    private List<User> users;

    public ResponseMessage(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
