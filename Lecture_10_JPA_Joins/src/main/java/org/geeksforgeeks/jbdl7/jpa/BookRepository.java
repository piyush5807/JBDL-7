package org.geeksforgeeks.jbdl7.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.IdClass;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, IdClass> {

//    @Query("select * from Book b")
//    public List<Book> findBooks();

    @Query("select b from Book b where b.authorName=:author")
    List<Book> findBooksByAuthor(String author);

    @Query(value = "select * from Book b where b.author_name=:name_of_author", nativeQuery = true)
    List<Book> findBookByAuthorSQL(String name_of_author);


    // JPQL - Java Persistence Query Language

    // SQL - Native SQL queries

}
