package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	
	void updateCustomer(Customer customer, String emailId, String shippingAddressId, String billingAddressId);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

}
