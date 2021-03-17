package com.sportyshoes.site.services;

//import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.site.entity.Product;
import com.sportyshoes.site.repository.ProductRepository;
import com.sportyshoes.site.services.interfaces.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService implements IProductService{
	
	private final ProductRepository productRepository;
	
	@Override
	public List<Product> getProductList() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProduct(Integer productId) {
		Product product = productRepository.findByProductId(productId);
		return product;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
	
	
	
	
	

}
