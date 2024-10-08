package com.gzip.teste.compactacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    private static final Logger logger = LoggerFactory.getLogger(TesteController.class);

    @GetMapping("/teste")
    public String getTeste(
            @RequestParam(name = "agencia") String agencia,
            @RequestParam(name = "conta") String conta,
            @RequestParam(name = "dac") String dac
    ) {
        logger.error("GET teste conta = ".concat(conta).concat(", agencia = ").concat(agencia).concat(" e dac = ".concat(dac)));
        return "Teste";
    }
}
