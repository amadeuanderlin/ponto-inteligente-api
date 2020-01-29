package com.anderlin.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//desabilita a autenticação
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
public class PontoInteligenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoInteligenteApplication.class, args);
	}

}
