package com.amsdams.sneakers.entity;

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
	private String priceNew;
	private String priceOld;
	private String url;

}
