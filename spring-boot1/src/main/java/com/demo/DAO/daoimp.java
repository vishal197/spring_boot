package com.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.modal.insVO;
@Repository
public class daoimp implements DAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public insVO insert(insVO InsVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(InsVO);
		return InsVO;
	}

	public List search(insVO insvo) {
			List ls= new ArrayList();
			try {
				Session session=sessionFactory.openSession();
				 
				 Query q = session.createQuery("from insVO where username='"+insvo.getUsername()+"' and password='"+insvo.getPassword()+"'"); 
				 ls = q.list();
			} catch (Exception e) {
				System.out.println(e);
			}return ls;
		}

	public void deluser(insVO customer) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(customer);
	}
		
	}


