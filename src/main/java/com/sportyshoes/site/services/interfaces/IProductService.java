package com.sportyshoes.site.services.interfaces;

import java.io.IOException;
import java.util.List;

import com.sportyshoes.site.entity.Product;

public interface IProductService {

	public List<Product> getProductList();
	public Product getProduct(Integer productId) throws IOException;
	public void addProduct(Product product);
	public void deleteProduct(Integer id);
}
