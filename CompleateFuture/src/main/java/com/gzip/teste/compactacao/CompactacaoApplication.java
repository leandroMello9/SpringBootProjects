package com.gzip.teste.compactacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class CompactacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompactacaoApplication.class, args);
	}

}
