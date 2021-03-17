package com.sportyshoes.site.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Cart {

	private String cartId;
	private Map<Integer, CartItem> cartItems;
	private Double grandTotal;
	
	private Cart() {
		cartItems = new HashMap<>();
		grandTotal=0.0;
	}
	
	public Cart(String cartId) {
		this();
		this.cartId=cartId;
	}
	
	public void addCartItem(CartItem cartItem) {
		if(cartItems.containsKey(cartItem.getProduct().getProductId())) {
			CartItem existingCartItem = cartItems.get(cartItem.getProduct().getProductId());
			existingCartItem.setQuantity(existingCartItem.getQuantity()+cartItem.getQuantity());
			cartItems.put(cartItem.getProduct().getProductId(), existingCartItem);
		} else {
			cartItems.put(cartItem.getProduct().getProductId(), cartItem);
		}
		updateGrandTotal();
	}
	
	public void removeCartItem (CartItem cartItem) {
		cartItems.remove(cartItem.getProduct().getProductId());
		updateGrandTotal();
	}
	
	public void updateGrandTotal() {
		grandTotal = 0.0;
		for(CartItem cartItem : cartItems.values()) {
			grandTotal = grandTotal + cartItem.getTotalPrice();
		}
	}
}
