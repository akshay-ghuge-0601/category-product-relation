package com.online_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_shop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
