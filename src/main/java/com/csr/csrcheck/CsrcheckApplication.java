package com.csr.csrcheck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.csr.csrcheck.mapper")
public class
CsrcheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsrcheckApplication.class, args);
	}

}
