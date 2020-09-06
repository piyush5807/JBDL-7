package com.example.My.App8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {
    HashMap<String,String> storage =
            new HashMap<String,String>();

    ArrayList<User> userTable =
            new ArrayList<>();

    public DB(){
        storage.put("sachin","A Great Batsman");
        storage.put("Dravid","Wall of Indian Cricket");

        userTable.add(new User(10,20,"Ramu"));
        userTable.add(new User(30,25,"Raka"));
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

    public boolean deleteAUser(String name){
        for(User user: userTable){
            if(user.getName().equals(name)){
                userTable.remove(user);
                return true;
            }
        }
        System.out.println("Could not find");
        return false;
    }

    public boolean upDateAUser(User user1){
        for(User user: userTable){
            if(user.getName().equals(user1.getName())){
                user.setAge(user1.getAge());
                return true;
            }
        }
        System.out.println("Could not find");
        return false;
    }
    public List<User> getList(){
        return userTable;
    }
}
