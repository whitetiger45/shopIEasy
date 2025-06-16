package com.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProductTest {

	private Product product;
	
	@Test
	public void notNullProductConstructor0() {
		product = new Product();
		Assertions.assertNotNull(product);
	}
	
	@Test
	public void notNullProductConstructor1() {
		product = new Product("0","android","test product","test manufacturer","test product name",19.99,"200");
		Assertions.assertNotNull(product);
	}
	
	@Test
	public void notNullGetProductValues() {
		product = new Product("0","android","test product","test manufacturer","test product name",19.99,"200");
		Assertions.assertNotNull(product);
		Assertions.assertNotNull(product.getProductCategory());
		Assertions.assertNotNull(product.getProductDescription());
		Assertions.assertNotNull(product.getProductManufacturer());
		Assertions.assertNotNull(product.getProductName());
		Assertions.assertNotNull(product.getProductPrice());
		Assertions.assertNotNull(product.getUnitStock());
	}
	
	@Test
	public void productPriceChangesAsExpected() {
		product = new Product("0","android","test product","test manufacturer","test product name",19.99,"200");
		Assertions.assertEquals(19.99,product.getProductPrice());
		product.setProductPrice(18.99);
		Assertions.assertEquals(18.99,product.getProductPrice());
	}
}
