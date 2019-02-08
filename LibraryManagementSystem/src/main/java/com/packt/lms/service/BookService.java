package com.packt.lms.service;

import java.util.List;

import com.packt.lms.entity.BookDetails;

public interface BookService {

	public void saveBooks(BookDetails bookDetails);

	public List<BookDetails> getAllBooks();

}
