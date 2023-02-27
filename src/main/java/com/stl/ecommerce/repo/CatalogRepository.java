package com.stl.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stl.ecommerce.entity.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog,Integer> {

}