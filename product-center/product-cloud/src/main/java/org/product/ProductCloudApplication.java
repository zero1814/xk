package org.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCloudApplication.class);
	}
}
