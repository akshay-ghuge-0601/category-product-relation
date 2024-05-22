package com.online_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shop.model.Product;
import com.online_shop.repository.ProductRepository;
@Service
public class ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Product getProductById(int id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    public Product createOrUpdateProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public void deleteProduct(int id) {
	        productRepository.deleteById(id);
	    }

}
