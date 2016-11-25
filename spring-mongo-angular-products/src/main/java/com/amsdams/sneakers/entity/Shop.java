package com.amsdams.sneakers.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
	@Id
	private String id;

	private String name;
	private String url;
	@DBRef
	private List<Product> products;
	public Shop(String name, String url, List<Product> products) {
		super();
		this.name = name;
		this.url = url;
		this.products = products;
	}

}
