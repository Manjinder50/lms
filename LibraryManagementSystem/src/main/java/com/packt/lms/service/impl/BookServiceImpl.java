package com.packt.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.packt.lms.dao.BookDAO;
import com.packt.lms.dto.BookDetailsDTO;
import com.packt.lms.entity.BookDetails;
import com.packt.lms.service.BookService;


@Service("bookService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveBooks(BookDetails bookDetails) {

		bookDAO.saveBooks(bookDetails);	
	}

}