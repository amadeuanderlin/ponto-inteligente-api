package com.anderlin.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//desabilita a autenticação
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class PontoInteligenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoInteligenteApplication.class, args);
	}

}
