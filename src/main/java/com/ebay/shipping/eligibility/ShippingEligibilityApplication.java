package com.ebay.shipping.eligibility;

import com.ebay.util.seed.GlobalSeeder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShippingEligibilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingEligibilityApplication.class, args);
		new GlobalSeeder().seedAllTables();
	}
}
