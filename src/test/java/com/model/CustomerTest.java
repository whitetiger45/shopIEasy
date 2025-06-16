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
    
    @Test
    public void setCustomerShippingAddress() {
    	ShippingAddress sa = new ShippingAddress();
    	Assertions.assertNotNull(sa);
    	sa.setAddress("123 test street");
    	sa.setCity("test city");
    	sa.setState("test state");
    	sa.setCountry("test country");
    	sa.setZipcode("55555");
    	customer = new Customer();
    	Assertions.assertNotNull(customer);
    	customer.setShippingAddress(sa);
    	Assertions.assertNotNull(customer.getShippingAddress());
    }
    
    @Test
    public void setCustomerBillingAddress() {
    	BillingAddress ba = new BillingAddress();
    	Assertions.assertNotNull(ba);
    	ba.setAddress("123 test street");
    	ba.setCity("test city");
    	ba.setState("test state");
    	ba.setCountry("test country");
    	ba.setZipcode("55555");
    	customer = new Customer();
    	Assertions.assertNotNull(customer);
    	customer.setBillingAddress(ba);
    	Assertions.assertNotNull(customer.getBillingAddress());
    }
}