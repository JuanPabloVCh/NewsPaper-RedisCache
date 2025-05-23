package com.uptc.frw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NewsPapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsPapperApplication.class, args);
	}

}
