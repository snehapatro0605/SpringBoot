package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entities.Product;
import com.rest.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductId(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/getProductByName/{name}")
	public Product getProductName(@PathVariable String name ) {
		return service.getProductByName(name);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

}
