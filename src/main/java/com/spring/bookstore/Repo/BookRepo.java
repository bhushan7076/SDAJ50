package com.spring.bookstore.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bookstore.Entity.Book;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
	Book findByName(String Name);
}
