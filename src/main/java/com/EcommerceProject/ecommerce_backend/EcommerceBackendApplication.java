package com.EcommerceProject.ecommerce_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EcommerceBackendApplication  {



	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);
	}
}
