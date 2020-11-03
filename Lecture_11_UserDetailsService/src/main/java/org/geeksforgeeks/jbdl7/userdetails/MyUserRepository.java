package org.geeksforgeeks.jbdl7.userdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    // select * from my_user where username = username
    public MyUser findByusername(String username);

}
