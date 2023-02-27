package com.stl.ecommerce.dto;

import jakarta.annotation.Nonnull;

public class ProductDto {
	//for create it is optional
	//for update we need this id
	private Integer id;
	@Nonnull
	private String name;
	private String imageUrl;
	@Nonnull
	private double price;
	@Nonnull
	private String description;
	private @Nonnull Integer catalogId;
	
	
	
	public ProductDto() {
		super();
		
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
	public Integer getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	

}
