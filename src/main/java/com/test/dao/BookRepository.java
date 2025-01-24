package com.test.dao;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.test.entities.Book;


public interface BookRepository extends CrudRepository<Book,Integer>{

	public Book findById(int id);
}
