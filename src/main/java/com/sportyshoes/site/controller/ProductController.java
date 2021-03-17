package com.sportyshoes.site.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sportyshoes.site.entity.Product;
import com.sportyshoes.site.services.interfaces.IProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
	
	private final IProductService productService;
	
	@GetMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products",products);
		return "productList";
	}
	
	@GetMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable Integer productId, Model model) throws IOException {
		Product product = productService.getProduct(productId);
		model.addAttribute(product);
		return "productDisplayPage";
	}

}
