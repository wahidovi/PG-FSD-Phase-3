package com.sportyshoes.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.site.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByProductId(Integer productId);
	
}
