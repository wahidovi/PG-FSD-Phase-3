package com.sportyshoes.site.entity;

import lombok.Data;

@Data
public class CartItem {

	private Product product;
	private Integer quantity;
	private Double totalPrice;
	
	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getPrice();
	}
	
}
