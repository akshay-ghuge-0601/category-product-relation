package com.online_shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.online_shop.model.Product;
import com.online_shop.model.ProductResponce;
import com.online_shop.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<ProductResponce> getAllProducts() {
		  List<Product> list = productService.getAllProducts();
	        List<ProductResponce> responceList = new ArrayList<>();
	        list.forEach(e -> {
	        	ProductResponce pResponce = new ProductResponce();
	        	pResponce.setP_Id(e.getP_Id());
	        	pResponce.setP_name(e.getP_name());
	        	pResponce.setPrice(e.getPrice());
	        	pResponce.setCategory(e.getCategory().getName());
	        	responceList.add(pResponce);
	        });
	       
	        	
		return responceList;
	}

	@GetMapping("/{id}")
	public ProductResponce getProductById(@PathVariable int id) {
		Product e = productService.getProductById(id);
		ProductResponce pResponce = new ProductResponce();
    	pResponce.setP_Id(e.getP_Id());
    	pResponce.setP_name(e.getP_name());
    	pResponce.setPrice(e.getPrice());
    	pResponce.setCategory(e.getCategory().getName());
		
    	return pResponce;
    	
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createOrUpdateProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		Product existingProduct = productService.getProductById(id);
		if (existingProduct != null) {
			existingProduct.setP_name(product.getP_name());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setCategory(product.getCategory());
			return productService.createOrUpdateProduct(existingProduct);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}

}
