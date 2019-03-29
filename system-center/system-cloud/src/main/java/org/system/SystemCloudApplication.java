package org.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SystemCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(SystemCloudApplication.class, args);
	}
}
