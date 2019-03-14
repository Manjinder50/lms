package com.packt.lms.dao;

import java.util.List;

import com.packt.lms.entity.BookDetails;

public interface BookDAO {

		public void saveBooks(BookDetails bookDetails);
		
		public List<BookDetails> getAllBooks();
		
		public BookDetails getById(int id);
		
		public void update(int id, BookDetails book);

		public void delete(int id);

}
