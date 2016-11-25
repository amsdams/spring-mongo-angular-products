package com.amsdams.sneakers.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.amsdams.sneakers.entity.Shop;
import com.amsdams.sneakers.entity.Size;

public interface SizeRepo extends MongoRepository<Size, String> {
	Page<Shop> findBySize(@Param("size") String name, Pageable pageable);

}
