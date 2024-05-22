package com.online_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
