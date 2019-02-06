package com.packt.lms.dto;

import java.io.Serializable;

public class BookDetailsDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bookTitle;
	
	private int quantity;
	
	public BookDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BookDetailsDTO [bookTitle=" + bookTitle + ", quantity=" + quantity + "]";
	}
	
}
