package com.sportyshoes.site.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sportyshoes.site.entity.Cart;

@Repository
public class CartDAOImpl implements CartDAO{

	private Map<String, Cart> listOfCarts;
	
	
	public CartDAOImpl() { listOfCarts = new HashMap<>(); }
	 

	@Override
	public Cart create(Cart cart) {
		if (listOfCarts.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException("Can not create cart, cart is already exists");
		}
		listOfCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public Cart read(String cartId) {
		return listOfCarts.get(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		if (!listOfCarts.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException("Can not update cart, cart doe not exists");
		}
		listOfCarts.put(cart.getCartId(), cart);
		
	}

	@Override
	public void delete(String cartId) {
		if (!listOfCarts.containsKey(cartId)) {
			throw new IllegalArgumentException("Can not delete cart, cart doe not exists");
		}
		listOfCarts.remove(cartId);
		
	}
	
	
}
