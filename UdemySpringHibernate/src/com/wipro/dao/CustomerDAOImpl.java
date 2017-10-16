package com.wipro.dao;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	//need to inject sessionfactory
	@Autowired
	SessionFactory sessionFactory;
	

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		//get the hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//execute query -- order by firstName and get result
		List<Customer> list=currentSession.createQuery("from Customer order by firstName").list();
		
		//return result
		return list;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		//get Session 
		Session curSession=sessionFactory.getCurrentSession();
		
		//save object
		curSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session curSession=sessionFactory.getCurrentSession();
		Customer cus=(Customer)curSession.get(Customer.class,id);
		return cus;
	}


	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session curSession=sessionFactory.getCurrentSession();
		
		Query query=curSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId",id);
		query.executeUpdate();
		
	}

}
