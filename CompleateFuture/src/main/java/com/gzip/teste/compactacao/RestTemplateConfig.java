package com.gzip.teste.compactacao;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfig {

    private RestTemplate restTemplate;

    public RestTemplate obterRestTemplate() {
        if(restTemplate != null) {
            return this.restTemplate;
        }
        return new RestTemplate();
    }
}
