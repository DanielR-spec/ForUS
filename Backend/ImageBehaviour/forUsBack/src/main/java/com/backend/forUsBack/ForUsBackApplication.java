package com.backend.forUsBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForUsBackApplication {

	public static void main(String[] args) {
		System.out.println("================ STARTING SERVER... ================");

		try {
			SpringApplication.run(ForUsBackApplication.class, args);
			System.out.println("================ SERVER Up :) ================");

		} catch (Exception e) {
			throw new RuntimeException(e+"================ SERVER DOWN :( ================");
		}
	}

}
