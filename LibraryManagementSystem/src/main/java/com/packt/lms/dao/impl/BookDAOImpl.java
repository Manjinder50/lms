package com.packt.lms.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.packt.lms.dao.BookDAO;
import com.packt.lms.entity.BookDetails;

public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BookDAOImpl() {
	}

	public BookDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveBooks(BookDetails bookDetails) {
		
		Session session = sessionFactory.openSession();
		session.save(bookDetails);
	}
	

}
