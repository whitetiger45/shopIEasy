package com.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CustomerTest {
	
    private Customer customer;
    
    @Test
    public void nullCustomer() {
    	Assertions.assertNull(customer);
    }

    @Test
    public void nonNullCustomer() {
    	customer = new Customer();
    	Assertions.assertNotNull(customer);
    }
    
    @Test
    public void setCustomerFirstAndLastName() {
    	customer = new Customer();
    	customer.setFirstName("test");
    	customer.setLastName("user");
    	Assertions.assertEquals("test",customer.getFirstName());
    	Assertions.assertEquals("user",customer.getLastName());
    } 
}