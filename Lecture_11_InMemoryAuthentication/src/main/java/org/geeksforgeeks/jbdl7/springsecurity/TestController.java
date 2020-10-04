package org.geeksforgeeks.jbdl7.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public String getUser(@RequestParam("name") String name){
        return "Hello user - " + name;
    }

    @GetMapping("/admin")
    public String getAdmin(@RequestParam("name") String name){
        return "Hello Admin - " + name;
    }

    @GetMapping("/general")
    public String getPerson(@RequestParam("name") String name){
        return "Hello Person - " + name;
    }
}
