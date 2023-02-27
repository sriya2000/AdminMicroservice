package com.stl.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stl.ecommerce.common.ApiResponse;
import com.stl.ecommerce.dto.ProductDto;
import com.stl.ecommerce.entity.Catalog;
import com.stl.ecommerce.entity.Product;
import com.stl.ecommerce.exception.ResourceNotFoundException;
import com.stl.ecommerce.repo.CatalogRepository;
import com.stl.ecommerce.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productservice; 
	
	@Autowired
	CatalogRepository catalogRepo;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
		//first check whether category id is present or not if present then add products to it.
		Optional<Catalog> optionalCatalog=catalogRepo.findById(productDto.getCatalogId());
		if(!optionalCatalog.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Catalog not found"),HttpStatus.NOT_FOUND);
		}
		productservice.createProduct(productDto, optionalCatalog.get());
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Product has been created!!"),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getProduct(){
		List<ProductDto> products= productservice.getAllProduct();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	//create an API to edit the product
	@PutMapping("/update/{productId}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) throws Exception {
		Optional<Catalog> optionalCatalog=catalogRepo.findById(productDto.getCatalogId());
		if(!optionalCatalog.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"Catalog not found"),HttpStatus.NOT_FOUND);
		}
		productservice.updateProduct(productDto, productId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"Product has been updated!!"),HttpStatus.OK);
		
	} 
	
	//get product details by product id
	 @GetMapping("/pid/{pid}")
	    public ResponseEntity<Optional<Product>> getProduct(@PathVariable("pid") int  id) {
	       Optional<Product> product = productservice.getProductById(id);
	        if (product == null) {
	            throw new ResourceNotFoundException("Product is not present with the id:"+id);
	        }
	        return ResponseEntity.of(Optional.of(product));
	    }

		// get product by catalog id
		@GetMapping("/name/{catalogId}")
		public ResponseEntity<List<Product>> getProductByCatalogId(@PathVariable("catalogId") int catalogId) {
			List<Product> list = productservice.getProductByCatalogName(catalogId);
			if (list.size() <= 0) {
				throw new ResourceNotFoundException("No product present in the list with the given catalog id");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	 
	 @DeleteMapping("/deletebyId/{productid}")   
	    public ResponseEntity<Product> deleteProduct( @PathVariable("productid") int id) {
	        try {
	            this.productservice.deleteProduct(id);
	            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        throw new ResourceNotFoundException("Product is not present with the id:"+id);
	    }

	
	 @GetMapping("/search")
	    public ResponseEntity<List<Product>> searchProduct(@RequestParam("query") String query){
	        return ResponseEntity.ok(productservice.searchProducts(query));
	    }
	
	
	
	
	
	
	
	
	
	

}
