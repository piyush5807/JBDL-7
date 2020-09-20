package org.geeksforgeeks.jbdl7.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.IdClass;

public interface Book2Repository extends JpaRepository<Book, IdClass> {

}
