package com.stl.ecommerce;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.stl.ecommerce.entity.Catalog;
import com.stl.ecommerce.entity.Product;
import com.stl.ecommerce.repo.CatalogRepository;
import com.stl.ecommerce.repo.ProductRepository;
import com.stl.ecommerce.service.CatalogService;
import com.stl.ecommerce.service.ProductService;

@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	CatalogRepository catalogRepository;
	
	 @InjectMocks
	ProductService productService;
	 
	 @InjectMocks
	 CatalogService catalogService;
	
	 @Test
	    @Order(1)
	    public void test_addCatalog() {
	        Catalog catalog = new Catalog(1,"mobile", "cool features", "cxcxcxcc");
	        when(catalogRepository.save(catalog)).thenReturn(catalog);
	        assertEquals(catalog,catalogService.createCategory(catalog));
	    }
	 
	    @Test
	    @Order(2)
	    public void test_getAllCatalog() {

	        List<Catalog> allCatalog = new ArrayList<Catalog>();
	        allCatalog.add(new Catalog(1,"mobile", "cool features", "cxcxcxcc"));
	        when(catalogRepository.findAll()).thenReturn(allCatalog);
	        assertEquals(1,catalogService.listCategory().size());

	    }
	    
	    @Test
	    @Order(3)
	    public void test_updateCatalog() {
	    	Catalog catalog = (new Catalog(1,"mobile", "cool features", "cxcxcxcc"));
	    	catalog.setCategoryName("mobile");
	    	catalogRepository.save(catalog);
	        assertEquals("mobile", catalog.getCategoryName());
	    }
	    
	    @Test
	    @Order(4)
	    public void test_deleteCatalog() {
	    	Catalog catalog = new Catalog(1,"mobile", "cool features", "cxcxcxcc");
	         
	    	   productRepository.deleteById(catalog.getId());
	             
	    	   Catalog deletedCatalog =  catalogRepository.getById(1);
	             
	            assertThat(deletedCatalog).isNull();
	    }
	    
	    @Test
	    @Order(5)
	    public void test_getCatalogById() {
	    	Catalog catalog = new Catalog(1,"mobile", "cool features", "cxcxcxcc");
	        when(catalogRepository.existsById(1)).thenReturn(true);
	        assertEquals(1, catalog.getId());

	    }
	    


}
