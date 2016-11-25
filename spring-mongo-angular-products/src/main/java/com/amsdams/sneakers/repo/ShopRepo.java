package com.amsdams.sneakers.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.amsdams.sneakers.entity.Shop;

public interface ShopRepo extends MongoRepository<Shop, String> {
	Page<Shop> findByName(@Param("name") String name, Pageable pageable);

}
