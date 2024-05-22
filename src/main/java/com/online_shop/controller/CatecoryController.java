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

import com.online_shop.model.Category;
import com.online_shop.model.CategoryResponce;
import com.online_shop.model.Product;
import com.online_shop.services.CategoryService;
@RestController
@RequestMapping("/api/categories")
public class CatecoryController {
	
	 @Autowired
	 private CategoryService categoryService;

	    @GetMapping
	    public List<CategoryResponce> getAllCategories() {
	        List<Category> list = categoryService.getAllCategories();
	        List<CategoryResponce> responceList = new ArrayList<>();
	        list.forEach(e -> {
	        	CategoryResponce cResponce = new CategoryResponce();
	        	cResponce.setId(e.getId());
	        	cResponce.setName(e.getName());
	        	List<String> pro =new ArrayList<>();
	        	for(Product p : e.getProduct()) {
	        		pro.add(p.getP_name());
	        	}
	        	cResponce.setProduct(pro);
	        	responceList.add(cResponce);
	        });
	        
	        return responceList;
	        
	    }

	    @GetMapping("/{id}")
	    public CategoryResponce getCategoryById(@PathVariable int id) {
	    	Category category = categoryService.getCategoryById(id);
	    	
	    	CategoryResponce cat1 = new CategoryResponce();
	    	cat1.setId(category.getId());
	    	cat1.setName(category.getName());
	    	List<String> pro =new ArrayList<>();
        	for(Product p : category.getProduct()) {
        		pro.add(p.getP_name());
        	}
        	cat1.setProduct(pro);
	    	
	    	
	        return cat1;
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createOrUpdateCategory(category);
	    }

	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
	        Category existingCategory = categoryService.getCategoryById(id);
	        if (existingCategory != null) {
	            existingCategory.setName(category.getName());
	            existingCategory.setProduct(category.getProduct());
	            return categoryService.createOrUpdateCategory(existingCategory);
	        }
	        return null;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable int id) {
	        categoryService.deleteCategory(id);
	    }

}
