package com.example.quiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.quiz.mapper")
public class HeyteaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeyteaApplication.class, args);
	}
}
