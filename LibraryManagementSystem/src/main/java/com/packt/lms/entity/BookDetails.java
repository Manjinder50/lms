package com.packt.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_DETAILS")
public class BookDetails implements Serializable{

	private static final long serialVersionUID = 1L;

		public BookDetails() {
		super();
	}

	@Id
	@Column(name = "ISBN",updatable = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int isbn;
	
	@Column(name = "BOOK_TITLE")
	private String bookTitle;
	
	@Column(name = "NO_COPIES_ACTUAL")
	private int noOfActualCopies;
	
	@Column(name = "NO_COPIES_CURRENT")
	private int noOfCurrentCopies;

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getNoOfActualCopies() {
		return noOfActualCopies;
	}

	public void setNoOfActualCopies(int noOfActualCopies) {
		this.noOfActualCopies = noOfActualCopies;
	}

	public int getNoOfCurrentCopies() {
		return noOfCurrentCopies;
	}

	public void setNoOfCurrentCopies(int noOfCurrentCopies) {
		this.noOfCurrentCopies = noOfCurrentCopies;
	}	
}
