package com.packt.lms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.packt.lms.dao.BookDAO;
import com.packt.lms.entity.BookDetails;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Autowired
	private HibernateTransactionManager transactionManager;*/

	public BookDAOImpl() {
	}

	public BookDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	/*@Override
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
*/	

	@Override
	public void update(int id, BookDetails book) {

		BookDetails bookNew = getById(book.getIsbn());
		 
		bookNew.setBookTitle(book.getBookTitle());
		bookNew.setNoOfActualCopies(book.getNoOfActualCopies());
		bookNew.setNoOfCurrentCopies(book.getNoOfCurrentCopies());
		getCurrentSession().update(bookNew);			
	}

	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	public void saveBooks(BookDetails bookDetails) {
		
		getCurrentSession().save(bookDetails);
	}

	@Override
	public List<BookDetails> getAllBooks() {
		List<BookDetails> books = getCurrentSession().createQuery("from BookDetails").getResultList();
		return books;
	}

	@Override
	public BookDetails getById(int id) {

		return getCurrentSession().get(BookDetails.class, id);
	}

	@Override
	public void delete(int id) {

		BookDetails book = getCurrentSession().load(BookDetails.class, new Integer(id));
		if(null !=book) {
			getCurrentSession().delete(book);
		}
	}
}
