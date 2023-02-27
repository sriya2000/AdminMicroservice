package com.stl.ecommerce.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Catalog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="catalogName")
	@Nonnull
	private String categoryName;
	@Column(name="description")
	@Nonnull
	private String description;
	
	private String imageUrl;
	
	
	public Catalog(int id, String categoryName, String description, String imageUrl) {
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
		
}
