package com.gzip.teste.compactacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.CompletableFuture;


@Service
public class ServicoAsync {

    private static final Logger logger = LoggerFactory.getLogger(ServicoAsync.class);

    @Autowired
    private RestTemplateConfig restTemplateConfig;

    private ResponseEntity<Cep> buscarCep(String cep) {
        ResponseEntity<Cep> resposta = this.restTemplateConfig.obterRestTemplate().getForEntity(
                "https://opencep.com/v1/".concat(cep.concat(".json")),
                Cep.class
        );
        logger.info("Cep response - ".concat(resposta.getBody().toString()));
        return resposta;
    }

    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono1() {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("Executando metodoAssincrono1 na thread: " + Thread.currentThread().getName());
            // Lógica do método
            return buscarCep("43810170");
        });
    }

    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono2() {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("Executando metodoAssincrono2 na thread: " + Thread.currentThread().getName());
            // Lógica do método
            return buscarCep("43810170");
        });
    }

    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono3() {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("Executando metodoAssincrono3 na thread: " + Thread.currentThread().getName());
            // Lógica do método
            return buscarCep("43810170");
        });
    }

    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono4() {
        return CompletableFuture.supplyAsync(() -> {
            logger.info("Executando metodoAssincrono4 na thread: " + Thread.currentThread().getName());
            // Lógica do método
            return buscarCep("43810170");
        });
    }

}
