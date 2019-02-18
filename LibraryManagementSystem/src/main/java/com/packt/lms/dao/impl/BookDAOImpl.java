package com.packt.lms.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.packt.lms.dao.BookDAO;
import com.packt.lms.entity.BookDetails;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTransactionManager transactionManager;

	public BookDAOImpl() {
	}

	public BookDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveBooks(BookDetails bookDetails) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(bookDetails);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<BookDetails> getAllBooks() {

		Session session = sessionFactory.openSession();
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<BookDetails> criteiaQuery = cBuilder.createQuery(BookDetails.class);
		Root<BookDetails> root = criteiaQuery.from(BookDetails.class);
		criteiaQuery.select(root);
		Query<BookDetails> query = session.createQuery(criteiaQuery);

		return query.getResultList();
	}

	@Override
	public BookDetails getById(int id) {

		return sessionFactory.openSession().get(BookDetails.class, id);
	}

	@Override
	public void update(int id, BookDetails book) {

		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		
		Session session = sessionFactory.openSession();
		BookDetails bookNew = session.byId(BookDetails.class).load(id);
		 
		bookNew.setBookTitle(book.getBookTitle());
		bookNew.setNoOfActualCopies(book.getNoOfActualCopies());
		bookNew.setNoOfCurrentCopies(book.getNoOfCurrentCopies());
		transaction.flush();	
		session.flush();
		session.close();
	}

}
