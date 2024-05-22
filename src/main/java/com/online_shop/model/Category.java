package com.online_shop.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	@Column
	String name;
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL )
    private List<Product> product;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	  public List<Product> getProduct() { return product; }
	  
	  public void setProduct(List<Product> product) { this.product = product; }
	  
	 
}
