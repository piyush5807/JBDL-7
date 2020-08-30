package com.example.My.App8;

import java.util.ArrayList;
import java.util.HashMap;

public class DB {
    HashMap<String,String> storage =
            new HashMap<String,String>();

    ArrayList<User> userTable =
            new ArrayList<>();

    public DB(){
        storage.put("sachin","A Great Batsman");
        storage.put("Dravid","Wall of Indian Cricket");

        userTable.add(new User(10,20,"Ramu"));
    }

    public String search(String word){
        if(!storage.containsKey(word)){
            return "Not Found this word";
        }
        return storage.get(word);
    }

    public boolean addUser(User user){
        userTable.add(user);
        return true;
    }

    public User findAUser(String name){
        for(User user: userTable){
            if(user.getName().equals(name)){
                return user;
            }
        }
        System.out.println("Could not find");
        return null;
    }
}
