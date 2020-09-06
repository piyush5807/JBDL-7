package com.example.My.App8;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
public class Controller {

    DB db = new DB();
    @GetMapping("/hi")
    public String sayHello(){
        return "Hello Coders";
    }

    // https://www.google.com/search?q=sachin
    // http://localhost:9090/search?q=sachin

    @ApiOperation("This API will search a word")
    @GetMapping("/search")
    public String searchAWord(@RequestParam String q){

        return db.search(q);
    }

    @PostMapping("/users")
    public boolean createANewUser(@RequestBody User user){

        return db.addUser(user);
    }
    // http://localhost:9090/users?name=Ramu : query param
    // https://api.github.com/users/shashipk : path param
    @GetMapping("/users")
    public User findAUser(@RequestParam String name){

        return db.findAUser(name);
    }

    // good : nice , well
    // http://localhost:9090/users/Ramu
    @GetMapping("/users/{name}")
    public ResponseEntity<User> findUser(@PathVariable String name){

        User user1 = db.findAUser(name);
        MultiValueMap<String, String> headers =
                new LinkedMultiValueMap<>();
        LinkedList<String> list = new LinkedList<>();
        list.add("local-server2");
        list.add("something else");
        headers.put("server2",list);

        headers.put("server", Collections.singletonList("local-server"));
        headers.put("set-cookies", Collections.singletonList("abc"));

        ResponseEntity<User> responseEntity =
                new ResponseEntity<User>(user1,headers, HttpStatus.CREATED);
        return responseEntity;

    }

    @DeleteMapping("/users/{name}")
    public boolean deleteAUser(@PathVariable String name){
        return db.deleteAUser(name);
    }

    @PutMapping("/users")
    public boolean updateAUser(@RequestBody User user){
        return db.upDateAUser(user);
    }

    @GetMapping("/usersAll")
    public List<User> abc(){
        return db.getList();
    }
    




















/*
    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(User user) {
        return Response.status(201).entity(user).build();
    }

 */

}
