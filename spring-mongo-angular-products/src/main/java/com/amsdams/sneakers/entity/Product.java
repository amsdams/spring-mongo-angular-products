package com.amsdams.sneakers.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	private String id;
	private String name;
	private String brand;
	private BigDecimal priceNew;
	private BigDecimal priceOld;
	private String url;
	@DBRef
	private List<Size> sizes;

	public Product(String name, String brand, BigDecimal priceNew, BigDecimal priceOld, String url, List<Size> sizes) {
		super();
		this.name = name;
		this.brand = brand;
		this.priceNew = priceNew;
		this.priceOld = priceOld;
		this.url = url;
		this.sizes = sizes;

	}
}
