package com.packt.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.packt.lms.dao.BookDAO;
import com.packt.lms.entity.BookDetails;
import com.packt.lms.service.BookService;


@Service("bookService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveBooks(BookDetails bookDetails) {

		bookDAO.saveBooks(bookDetails);	
	}

	@Override
	public List<BookDetails> getAllBooks() {
		
		return bookDAO.getAllBooks();
	}

	@Override
	public BookDetails getById(int id) {

		return bookDAO.getById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(int id, BookDetails book) {

		bookDAO.update(id, book);
	}

}
