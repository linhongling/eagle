package com.eagle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.eagle.order.mapper")
public class EagleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagleApplication.class, args);
	}

}
