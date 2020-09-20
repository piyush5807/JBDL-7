package org.geeksforgeeks.jbdl7.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public void createBook(@RequestBody Book book){
        bookRepository.save(book);
    }
}
