package org.geeksofrgeeks.jbdl7.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    User user;

    @GetMapping
    @ResponseBody
    public ResponseMessage getUser(){
        user.setAge(20);
        user.setName("ABC");
        System.out.println(user);
        return new ResponseMessage(Collections.singletonList(user));
    }
}
