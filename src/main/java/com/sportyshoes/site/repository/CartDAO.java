package com.sportyshoes.site.repository;

import com.sportyshoes.site.entity.Cart;

public interface CartDAO {
	
	Cart create(Cart cart);
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	void delete(String cartId);

}
