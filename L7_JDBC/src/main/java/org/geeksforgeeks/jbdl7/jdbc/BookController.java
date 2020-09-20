package org.geeksforgeeks.jbdl7.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Value("${my_var}")
    String var;

    @Autowired
    DBManager manager;

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam("table") String table) throws SQLException {
        System.out.println(var);
        return manager.getBooks(table);
    }

    @PostMapping("/book")
    public void createBook(@RequestBody Book book, @RequestParam("table") String table) throws SQLException {
        manager.createBook(book, table);
    }

    @GetMapping("/book")
    public List<Book> getBooksByAuthorName(@QueryParam("author") String author, @RequestParam("table") String table) throws SQLException {
        return manager.findBooksByAuthor(author, table);
    }

    @GetMapping("/book/{author}")
    public List<Book> getBooksByAuthorName2(@PathVariable("author") String author, @RequestParam("table") String table) throws SQLException {
        return manager.findBooksByAuthor(author, table);
    }

    @PostMapping("/create_table")
    public void createTable(@RequestParam("table") String table) throws SQLException {
        manager.createTable(table);
    }

}
