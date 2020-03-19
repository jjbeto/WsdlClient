package com.thetaris.goldprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GoldpriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldpriceApplication.class, args);
	}

}
