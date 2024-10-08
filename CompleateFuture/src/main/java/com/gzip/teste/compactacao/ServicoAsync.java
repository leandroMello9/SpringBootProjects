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

    @Async
    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono1() throws Exception {
        // Lógica assíncrona

        StopWatch start = new StopWatch();

        start.start();

        ResponseEntity<Cep> cep = buscarCep("43810170");

        start.stop();

        logger.info("Tempo request metodo 1 = " + start.getTotalTimeMillis());
        return CompletableFuture.completedFuture(cep);
    }

    @Async
    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono2() {
        // Lógica assíncrona
        StopWatch start = new StopWatch();

        start.start();

        ResponseEntity<Cep> cep = buscarCep("15050305");

        start.stop();

        logger.info("Tempo request metodo 2 = " + start.getTotalTimeMillis());

        return CompletableFuture.completedFuture(cep);
    }

    @Async
    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono3() throws Exception {
        // Lógica assíncrona
        StopWatch start = new StopWatch();

        start.start();

        ResponseEntity<Cep> cep = buscarCep("15050305");

        start.stop();

        logger.info("Tempo request metodo 3 = " + start.getTotalTimeMillis());

        return CompletableFuture.completedFuture(cep);
    }
    @Async
    public CompletableFuture<ResponseEntity<Cep>> metodoAssincrono4() throws Exception {
        // Lógica assíncrona
        StopWatch start = new StopWatch();

        start.start();

        ResponseEntity<Cep> cep = buscarCep("43810170");

        start.stop();

        logger.info("Tempo request metodo 4 = " + start.getTotalTimeMillis());

        return CompletableFuture.completedFuture(cep);
    }

}
