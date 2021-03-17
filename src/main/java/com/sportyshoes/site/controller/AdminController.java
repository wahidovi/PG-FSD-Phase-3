package com.sportyshoes.site.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sportyshoes.site.entity.Product;
import com.sportyshoes.site.services.interfaces.IProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {
	

	private final IProductService productService;
	private Path path;
	
	@RequestMapping("/admin")
    public String getAdmin() {
        return "admin";
    }
	
	@GetMapping("/admin/productInventory")
	public String getProductInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products",products);
		return "productInventory";
	}
	
	
	
	@RequestMapping("/admin/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setCondition("New");
		product.setStatus("Active");
		product.setCategory("Casual Shoes");
		model.addAttribute(product);
		return "addProduct";
	}
	 
	 
	
	@RequestMapping("/admin/productInventory/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Integer id,  HttpServletRequest request) {
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //String rootDirectory = "/home/cropin/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/SportyShoes/src/main/static";
        rootDirectory = rootDirectory.replace("webapp", "resources");
        path = Paths.get(rootDirectory + "/static/resources/images/"+id+".png");

        if(Files.exists(path)) {
        	try {
        		Files.delete(path);
        	} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        productService.deleteProduct(id);
        
		return "redirect:/admin/productInventory";
	}
	
	
	/*
	 * @PostMapping("/admin/productInventory/addProduct") public String
	 * addProduct(@ModelAttribute("product") Product product) {
	 * productService.addProduct(product); return
	 * "redirect:/admin/productInventory"; }
	 */
	 
	
	@PostMapping(value = "/admin/productInventory/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, HttpServletRequest request) {
		productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //String rootDirectory = "/home/cropin/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/SportyShoes/src/main/static";
        rootDirectory = rootDirectory.replace("webapp", "resources");
        path = Paths.get(rootDirectory + "/static/resources/images/"+product.getProductId()+".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        return "redirect:/admin/productInventory";
    }
	
}
