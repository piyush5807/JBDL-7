package com.example.My.App8;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    DB db = new DB();
    @GetMapping("/hi")
    public String sayHello(){
        return "Hello Coders";
    }

    // https://www.google.com/search?q=sachin
    // http://localhost:9090/search?q=sachin

    @GetMapping("/search")
    public String searchAWord(@RequestParam String q){

        return db.search(q);
    }

    @PostMapping("/users")
    public boolean createANewUser(@RequestBody User user){

        return db.addUser(user);
    }
    // http://localhost:9090/users?q=Ramu
    @GetMapping("/users")
    public User findAUser(@RequestParam String name){
        return db.findAUser(name);
    }

}
