package com.amsdams.sneakers.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

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

	public Product(String name, String brand, BigDecimal priceNew, BigDecimal priceOld, String url) {
        this.name = name;
        this.brand = brand;
        this.priceNew =priceNew;
        this.priceOld = priceOld;
        this.url = url;
        
        
        
    }
}
