package com.ordem.compra.calculocotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/calculocotacao")
public class CalculoCotacaoController {

    private final CalculoCotacaoService service;

    @GetMapping("{moeda}")
    public Double getCotacao(@PathVariable String moeda){
        if(moeda == null || moeda.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda não informada");
        } else if (moeda == "USD" || moeda == "EUR"){
            Double valor = service.getCotacao(moeda);
            return valor;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda incorreta");}
    }



}
