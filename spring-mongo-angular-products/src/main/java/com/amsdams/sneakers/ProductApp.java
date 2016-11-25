package com.amsdams.sneakers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;

import com.amsdams.sneakers.entity.Product;
import com.amsdams.sneakers.entity.Shop;
import com.amsdams.sneakers.entity.Size;
import com.amsdams.sneakers.repo.ProductRepo;
import com.amsdams.sneakers.repo.ShopRepo;
import com.amsdams.sneakers.repo.SizeRepo;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
@Import({ springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class,
		springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class })

public class ProductApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ShopRepo shopRepo;

	@Autowired
	private SizeRepo sizeRepo;

	private ApiInfo apiInfo() {
		return new ApiInfo("title", "description", "version", "termsOfServiceUrl", "contact", "license", "licenseUrl");
	}

	@Override
	public void run(String... args) throws Exception {
		shopRepo.deleteAll();
		productRepo.deleteAll();
		sizeRepo.deleteAll();
		// save a couple of Sizes

		sizeRepo.save(new Size("43"));
		sizeRepo.save(new Size("XL"));
		sizeRepo.save(new Size("XXS"));

		// fetch all Sizes
		log.info("Sizes found with findAll():");
		log.info("-------------------------------");
		List<Size> sizes = sizeRepo.findAll();

		for (Size size : sizes) {
			log.info(size.toString());
		}
		// save a couple of Products
		productRepo.save(new Product("Air Max", "Nike", BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com", sizes));
		productRepo.save(new Product("ZX Flux", "Adidas", BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com", sizes));
		productRepo.save(new Product("Blaze of Glory", "Puma", BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com", sizes));

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

		// save a couple of Shops
		shopRepo.save(new Shop("shopName", "http://www.google.com/shops", products));

		// fetch all Shops
		log.info("Shops found with findAll():");
		log.info("--------------------------------");
		for (Shop shop : shopRepo.findAll()) {
			log.info(shop.toString());
		}

	}

	@Bean
	public Docket swaggerSpringfoxDocket() {
		log.debug("Starting Swagger");

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();

	}
}
