package com.gzip.teste.compactacao;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

    private WebClient.Builder webClientBuilder;

    public WebClient.Builder obterRestTemplate() {

        if(webClientBuilder != null) {
            return webClientBuilder;
        }

        WebClient.Builder webClient = WebClient.builder();

        this.webClientBuilder = webClient;

        return webClientBuilder;
    }
}
