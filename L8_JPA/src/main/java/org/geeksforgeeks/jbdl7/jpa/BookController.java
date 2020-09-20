package org.geeksforgeeks.jbdl7.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;

//    @Autowired
//    UserRepository userRepository;

//    @Autowired
//    PersonRepository personRepository;

//    @PostMapping("/user")
//    public void createUser(@RequestBody User user){
//        userRepository.save(user);
//    }

//    @PostMapping("/person")
//    public void createPerson(@RequestBody Person user){
//        personRepository.save(user);
//    }

    @GetMapping("/books")
    public List<Book> getBooks() throws SQLException {
        return repository.findAll();
    }
//
    @PostMapping("/book")
    public void createBook(@RequestBody Book book) throws SQLException {
        repository.save(book);
    }
//
    @GetMapping("/book")
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World!");
    }
    public List<Book> getBooksByAuthorName(@RequestParam("author") String author) throws SQLException {
        return repository.findBooksByAuthor(author);

    }
//
    @GetMapping("/book/{author}")
    public List<Book> getBooksByAuthorName2(@PathVariable("author") String author) throws SQLException {
        return repository.findBookByAuthorSQL(author);
    }
//
//    @PostMapping("/create_table")
//    public void createTable(@RequestParam("table") String table) throws SQLException {
//        manager.createTable(table);
//    }

}
