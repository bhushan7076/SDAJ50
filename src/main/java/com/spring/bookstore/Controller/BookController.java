package com.spring.bookstore.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookstore.Entity.Book;
import com.spring.bookstore.Repo.BookRepo;



@RestController
@RequestMapping("/bookstore")
public class BookController {
	@Autowired
	BookRepo repo;
	 @GetMapping("/run")
	 public String test() {
	return "Bookstore is running";

	 }
	 @PostMapping("/add")
	 public Book addBook(@RequestBody Book bk) {
	return repo.save(bk);
	 }
	 @GetMapping("/list")
	 public List<Book>getBooks(){
	return repo.findAll();

	 }
	 @GetMapping("/get/{name}")
	 public Book getBook(@PathVariable String name){
	return repo.findByName(name);
	 
	}
	 @DeleteMapping("/remove/{id}")
	 public String removeBook(@PathVariable Long id) {
	try {
	Book p=repo.findById(id).get();
	if(p!=null) {
	repo.deleteById(id);
	return "Product deleted successfully";
	}else {
	return "Product didn't found";
	}
	}catch(Exception e) {
	return "Record not found";
	}

	 }
	 @PutMapping("/update")
	 public Book updateBook(@RequestBody Book bk) {
	Book BookResponse=new Book();
	try {
	Book p=repo.findById(bk.getId()).get();
	if(p!=null) {

	 p.setAuthor(bk.getAuthor());

	p.setName(bk.getName());

	p.setPrice(bk.getPrice());
	BookResponse=repo.save(p);
	}
	 }
	catch (Exception e) {
	e.printStackTrace();
	}
	return BookResponse;
	 }
}

