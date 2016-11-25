package com.amsdams.sneakers.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.amsdams.sneakers.entity.Product;

public interface ProductRepo extends MongoRepository<Product, String> {
	Page<Product> findByBrand(@Param("brand") String brand, Pageable pageable);

	Page<Product> findByName(@Param("name") String name, Pageable pageable);
}
