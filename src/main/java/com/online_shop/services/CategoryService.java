package com.online_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_shop.model.Category;
import com.online_shop.repository.CategoryRepository;
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cRepo;

	public List<Category> getAllCategories() {
		return cRepo.findAll();
	}

	public Category getCategoryById(int id) {
		return cRepo.findById(id).orElse(null);
	}

	public Category createOrUpdateCategory(Category category) {
		return cRepo.save(category);
	}

	public void deleteCategory(int id) {
		cRepo.deleteById(id);
	}
}
