package com.stl.ecommerce.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Nonnull
	private String name;
	private String imageUrl;
	@Nonnull
	private double price;
	@Nonnull
	private String description;
	
	
	
	//ManytoOne relationship
	@ManyToOne
	@JoinColumn(name="catalog_id")
	Catalog catalog;
	
	
	
	public Product(int id, String name, String imageUrl, double price, String description, Catalog catalog) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
		this.description = description;
		this.catalog = catalog;
	}
	
	
	public Product() {
		
	}
	public Product(int id2, String name2, String imageUrl2, String string, String description2, Class<Catalog> class1) {
		
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	
	

}
