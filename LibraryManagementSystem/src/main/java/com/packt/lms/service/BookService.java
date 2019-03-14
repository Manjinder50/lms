package com.packt.lms.service;

import java.util.List;

import com.packt.lms.entity.BookDetails;

public interface BookService {

	public void saveBooks(BookDetails bookDetails);

	public List<BookDetails> getAllBooks();

	public BookDetails getById(int id);

	public void update(int id, BookDetails book);

	public void delete(int id);

}
