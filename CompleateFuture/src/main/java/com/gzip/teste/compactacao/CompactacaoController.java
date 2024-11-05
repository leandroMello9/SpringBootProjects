package com.gzip.teste.compactacao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
public class CompactacaoController {



    @Autowired
    private RestTemplateConfig restTemplateConfig;

    @Autowired
    private ServicoAsync servicoAsync;

    private static final Logger logger = LoggerFactory.getLogger(CompactacaoController.class);


    @GetMapping("/compactacao")
    @Async
    public ResponseEntity<?> getMessage(@RequestParam(name = "cep", required = true) String cep) throws Exception {

        String uri = "https://pokeapi.co/";

        StopWatch start = new StopWatch();

        start.start();
        CompletableFuture<ResponseEntity<Cep>> resposta1 = this.servicoAsync.metodoAssincrono1();
        CompletableFuture<ResponseEntity<Cep>> resposta2 = this.servicoAsync.metodoAssincrono1();
        CompletableFuture<ResponseEntity<Cep>> resposta3 = this.servicoAsync.metodoAssincrono1();
        CompletableFuture<ResponseEntity<Cep>> resposta4 = this.servicoAsync.metodoAssincrono1();

        CompletableFuture.allOf(resposta1, resposta2, resposta3, resposta4).join();

        start.stop();

        logger.info("Tempo de resposta controller" + start.getTotalTimeSeconds());

        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(resposta1.get().getBody());
    }
}
