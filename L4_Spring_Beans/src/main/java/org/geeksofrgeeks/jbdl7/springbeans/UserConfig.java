//package org.geeksofrgeeks.jbdl7.springbeans;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//@Configuration
//public class UserConfig {
//
//    @Autowired
//    User user;
//
//    @Bean
//    @Scope("prototype")
//    public User getMyUser(){
//        // Just check whether this is executing multiple times or not
//        System.out.println("In UserConfig: getMyUser function");
//        return user;
//    }
//
//}
