package com.stl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stl.ecommerce.dto.ProductDto;
import com.stl.ecommerce.entity.Catalog;
import com.stl.ecommerce.entity.Product;
import com.stl.ecommerce.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;

	public void createProduct(ProductDto productDto, Catalog catalog) {
		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImageUrl());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setCatalog(catalog);
		productRepo.save(product);
		
	}
	
	public ProductDto getProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setDescription(product.getDescription());
		productDto.setImageUrl(product.getImageUrl());
		productDto.setCatalogId(product.getCatalog().getId());
		productDto.setPrice(product.getPrice());
		productDto.setName(product.getName());
		productDto.setId(product.getId());
		return productDto;
	}

	public List<ProductDto> getAllProduct() {
		List<Product> allProducts= productRepo.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for(Product product:allProducts) {
			productDtos.add(getProductDto(product));
		}
		
		return productDtos;
	}

	public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
		Optional<Product> optionalProduct=productRepo.findById(productId);
		//throw an exception if product does not exists
		if(!optionalProduct.isPresent()) {
			throw new Exception("Product not present");
		}
		Product product = optionalProduct.get();
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImageUrl());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		productRepo.save(product);
		
	}

	

	public Optional<Product> getProductById(int id) {
		
		 return this.productRepo.findById(id);
	}
	

	public List<Product> searchProducts(String query) {
        List<Product> products = productRepo.searchitems(query);
        return products;
    }

	public List<Product> getProductByCatalogName(int catalogId) {
		
		 return this.productRepo.findByCatalogId(catalogId);

	}

	public void deleteProduct(int id) {
		productRepo.deleteById(id);

		
	}


	

}
