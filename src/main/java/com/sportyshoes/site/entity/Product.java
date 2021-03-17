package com.sportyshoes.site.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String name;
	private String category;
	private String description;
	private Double price;
	private String condition;
	private String status;
	private Integer unitInStock;
	private String manufacturer;
	@Transient
	private MultipartFile productImage;
	
}
