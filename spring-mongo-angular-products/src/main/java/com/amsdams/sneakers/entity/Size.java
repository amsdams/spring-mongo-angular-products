package com.amsdams.sneakers.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size {
	@Id
	private String id;

	private String size;
	public Size(String size) {
		super();
		this.size = size;
	}
}
