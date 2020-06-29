package com.spring.interview.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.interview.entities.User;

@Repository
public class UserDAOImpl implements UserDAO{
	private SessionFactory sessionFactory;

//	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	@Override
	public void save(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}

	@Override
	public List<User> list() {
		Session session = this.sessionFactory.openSession();
		List<User> personList = session.createQuery("from User").list();
		session.close();
		return personList;
	}

}
