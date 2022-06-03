package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//inject hibernate session factory
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		//create query
		Query<Customer> query = session.createQuery("From Customer", Customer.class);
		
		
		//get result list
		List<Customer> customers = query.getResultList();
		
		//return list of customers
		return customers;
	}

}
