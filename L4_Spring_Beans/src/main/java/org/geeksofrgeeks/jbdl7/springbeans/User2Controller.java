package org.geeksofrgeeks.jbdl7.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/user2")
@ResponseBody
public class User2Controller {

    @Autowired
    User user;

    @GetMapping
    @ResponseBody
    public ResponseMessage getUser(){
//        User user = new User();
//        User user = config.getMyUser();
        user.setAge(30);
        user.setName("DEF");
        System.out.println(user);
        return new ResponseMessage(Collections.singletonList(user));
    }

    @PostMapping
    public String postCall(){
        return "Just to test post call";
    }


}
