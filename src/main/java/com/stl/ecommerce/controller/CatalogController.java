package com.stl.ecommerce.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stl.ecommerce.common.ApiResponse;
import com.stl.ecommerce.entity.Catalog;
import com.stl.ecommerce.service.CatalogService;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CatalogController {
	
	@Autowired
	CatalogService catalogservice;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCatalog(@RequestBody Catalog catalog) {
		catalogservice.createCategory(catalog);
		return new ResponseEntity<>(new ApiResponse(true, "create a new catalog"), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public List<Catalog> listCatalog(){
		return catalogservice.listCategory();
	}
	
	@PutMapping("/update/{catalogId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("catalogId") int catalogId, @RequestBody Catalog catalog) {
		System.out.println("catalog id "+ catalogId);
		if(!catalogservice.findById(catalogId)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "catalog does not exists"), HttpStatus.NOT_FOUND);
		}
		catalogservice.editCatelog(catalogId,catalog);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "catalog has been updated"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{catalogId}")
	public ResponseEntity<ApiResponse> deleteCatalogById(@PathVariable("catalogId") int catalogId){
		if(!catalogservice.findById(catalogId)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "catalog does not exists"), HttpStatus.NOT_FOUND);
		}
		catalogservice.deleteCatalog(catalogId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "catalog has been deleted"), HttpStatus.OK);
		
	
	}

}

