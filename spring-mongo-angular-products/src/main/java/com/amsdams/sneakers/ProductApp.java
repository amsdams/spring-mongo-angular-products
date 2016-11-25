package com.amsdams.sneakers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.amsdams.sneakers.entity.Product;
import com.amsdams.sneakers.entity.Shop;
import com.amsdams.sneakers.repo.ProductRepo;
import com.amsdams.sneakers.repo.ShopRepo;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@SpringBootApplication
@EnableSwagger2
public class ProductApp implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ShopRepo shopRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productRepo.deleteAll();

		// save a couple of products

		productRepo.save(new Product("Air Max", "Nike", BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com"));
		productRepo.save(new Product("ZX Flux", "Adidas", BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com"));
		productRepo.save(new Product("Blaze of Glory", "Puma", BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com"));

		// fetch all products
		log.info("Products found with findAll():");
		log.info("-------------------------------");
		List<Product> products = productRepo.findAll();

		for (Product product : products) {
			log.info(product.toString());
		}

		// fetch an individual product
		log.info("Product found with findByBrand('Nike'):");
		log.info("--------------------------------");
		for (Product product : productRepo.findByBrand("Nike", new PageRequest(0, 20))) {
			log.info(product.toString());
		}

		log.info("Products found with findByName('Air Max'):");
		log.info("--------------------------------");
		for (Product product : productRepo.findByName("Air Max", new PageRequest(0, 20))) {
			log.info(product.toString());
		}

		shopRepo.save(new Shop("shopName", "http://www.google.com/shops", products));

		log.info("Shops found with findAll():");
		log.info("--------------------------------");
		for (Shop shop : shopRepo.findAll()) {
			log.info(shop.toString());
		}

	}
}
