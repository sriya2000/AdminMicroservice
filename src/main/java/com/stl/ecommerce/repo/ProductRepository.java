package com.stl.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stl.ecommerce.entity.Catalog;
import com.stl.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer > {

	//List<Product> searchProducts(String query);
	
	
	  @Query("SELECT p FROM Product p WHERE " +
	            "p.name LIKE CONCAT('%',:query, '%')" +
	            "Or p.description LIKE CONCAT('%', :query, '%')")
	List<Product> searchitems(String query);

	

	List<Product> findByCatalogId(int catalogId);

	

}
