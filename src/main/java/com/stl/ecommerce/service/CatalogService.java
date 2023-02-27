package com.stl.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.ecommerce.entity.Catalog;
import com.stl.ecommerce.repo.CatalogRepository;

@Service
public class CatalogService {
	
	@Autowired
	CatalogRepository catalogRepo;
	
	public Catalog createCategory(Catalog catalog) {
		return catalogRepo.save(catalog);
		
	}

	public List<Catalog> listCategory() {
		return catalogRepo.findAll();
	}

	public void editCatelog(int catalogId, Catalog updatecatalog) {
		Catalog catalog= catalogRepo.getById(catalogId);
		catalog.setCategoryName(updatecatalog.getCategoryName());
		catalog.setDescription(updatecatalog.getDescription());
		catalog.setImageUrl(updatecatalog.getImageUrl());
		catalogRepo.save(catalog);
		
	}

	public boolean findById(int catalogId) {
		
		return catalogRepo.findById(catalogId).isPresent();
	}

	public void deleteCatalog(int catalogId) {
		 catalogRepo.deleteById(catalogId);
		
	}
	

}
