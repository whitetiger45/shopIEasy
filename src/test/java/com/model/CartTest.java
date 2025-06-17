package com.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CartTest {
	
	private Cart cart;
	
	@Test
	public void setCartWithCartItemList() {
		CartItem cartItem0 = new CartItem();
		CartItem cartItem1 = new CartItem();
		CartItem cartItem2 = new CartItem();
		Product product0 = new Product("0","android","test product 0","test manufacturer 0","test product 0 name",19.99,"200");
		Product product1 = new Product("1","linux","test product 1","test manufacturer 1","test product 1 name",18.99,"200");
		Product product2 = new Product("2","windows","test product 2","test manufacturer 2","test product 2 name",20.99,"200");
		Assertions.assertNotNull(product0);
		Assertions.assertNotNull(product1);
		Assertions.assertNotNull(product2);
		cartItem0.setProduct(product0);
		cartItem1.setProduct(product1);
		cartItem2.setProduct(product2);
		Assertions.assertNotNull(cartItem0);
		Assertions.assertNotNull(cartItem1);
		Assertions.assertNotNull(cartItem2);
		List<CartItem> cartItems = Arrays.asList(cartItem0,cartItem1);		
		cart = new Cart();
		cart.setCartItem(cartItems);
		Assertions.assertNotNull(cart.getCartItem());
	}
	
	@Test
	public void cartPriceEqualsExpectedValue() {
		CartItem cartItem0 = new CartItem();
		CartItem cartItem1 = new CartItem();
		CartItem cartItem2 = new CartItem();
		Product product0 = new Product("0","android","test product 0","test manufacturer 0","test product 0 name",19.99,"200");
		Product product1 = new Product("1","linux","test product 1","test manufacturer 1","test product 1 name",18.99,"200");
		Product product2 = new Product("2","windows","test product 2","test manufacturer 2","test product 2 name",20.99,"200");
		Assertions.assertNotNull(product0);
		Assertions.assertNotNull(product1);
		Assertions.assertNotNull(product2);
		cartItem0.setProduct(product0);
		cartItem0.setPrice(product0.getProductPrice());
		cartItem1.setProduct(product1);
		cartItem1.setPrice(product1.getProductPrice());
		cartItem2.setProduct(product2);
		cartItem2.setPrice(product2.getProductPrice());
		Assertions.assertNotNull(cartItem0);
		Assertions.assertEquals(19.99,cartItem0.getProduct().getProductPrice());
		Assertions.assertNotNull(cartItem1);
		Assertions.assertEquals(18.99,cartItem1.getProduct().getProductPrice());
		Assertions.assertNotNull(cartItem2);
		Assertions.assertEquals(20.99,cartItem2.getProduct().getProductPrice());
		List<CartItem> cartItems = Arrays.asList(cartItem0,cartItem1);	
		cart = new Cart();
		cart.setCartItem(cartItems);
		Assertions.assertNotNull(cart.getCartItem());
		double totalOfCartItemPrices = cartItems.stream().mapToDouble( cartItem -> cartItem.getPrice() ).sum();
		cart.setTotalPrice(totalOfCartItemPrices);
		Assertions.assertEquals(totalOfCartItemPrices,cart.getTotalPrice());
	}
	
}
