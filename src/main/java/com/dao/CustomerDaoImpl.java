package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Authorities;
import com.model.BillingAddress;
import com.model.Cart;
import com.model.Customer;
import com.model.Product;
import com.model.ShippingAddress;
import com.model.User;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addCustomer(Customer customer) {
		System.out.println("Adding customer in dao");
		Session session = sessionFactory.openSession();
		//customer - has users,shippingaddress
		//insert the users,billingaddress
		customer.getUsers().setEnabled(true);
		
		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USER");
		authorities.setEmailId(customer.getUsers().getEmailId());
		
		Cart cart = new Cart();
		//it is to set CartId for customer table
		customer.setCart(cart);//set the cart to the customer
		//if we omit this statement, hen it will insert null for customerid in cart
		//to set the customerid in cart table
		cart.setCustomer(customer);
		session.save(customer);
		session.save(authorities);
		session.flush();
		session.close();
	}
	
	public void updateCustomer(Customer customer, String emailId, String shippingAddressId, String billingAddressId) {
		System.out.println("Updating customer in dao");
		Session session = sessionFactory.openSession();
		Customer oCustomer = getCustomerByemailId(emailId);
		/* update email address */
		if(!customer.getUsers().getEmailId().equals(emailId))
			oCustomer.getUsers().setEmailId(customer.getUsers().getEmailId());
		/* update first and last name */
		if(!customer.getFirstName().equals(oCustomer.getFirstName()))
			oCustomer.setFirstName(customer.getFirstName());
		if(!customer.getLastName().equals(oCustomer.getLastName()))
			oCustomer.setLastName(customer.getLastName());
		/* update phone number */
		if(!customer.getCustomerPhone().equals(oCustomer.getCustomerPhone()))
			oCustomer.setCustomerPhone(customer.getCustomerPhone());
		/* update billing address */
		if(!customer.getBillingAddress().equals(oCustomer.getBillingAddress())) {
			oCustomer.setBillingAddress(customer.getBillingAddress());
			oCustomer.getBillingAddress().setBillingAddressId(billingAddressId);
			oCustomer.getBillingAddress().setCustomer(customer);
		}		
		/* update shipping address */
		if(!customer.getShippingAddress().equals(oCustomer.getShippingAddress())) {
			oCustomer.setShippingAddress(customer.getShippingAddress());
			oCustomer.getShippingAddress().setShippingAddressId(shippingAddressId);
			oCustomer.getShippingAddress().setCustomer(customer);
		}
		session.merge(oCustomer);		
		session.flush();
		session.close();
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		
		return customerList;
	}

	public Customer getCustomerByemailId(String emailId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where emailId=?");
		query.setString(0, emailId);
		User users = (User)query.uniqueResult();
		Customer customer = users.getCustomer();
		return customer;
	}
	
	
}
