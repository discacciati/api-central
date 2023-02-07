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

    WebClient calculoCotacaoClient = WebClient.builder()
            .baseUrl("https://economia.awesomeapi.com.br/")
            .defaultHeader(HttpHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE)
            .build();


    private final CalculoCotacaoService service;

    @GetMapping("{moeda}")






    public ResponseEntity<CalculoCotacaoDTO> getByCode(@PathVariable String moeda){
        if(moeda == null || moeda.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda não informada");
        } else if (moeda == "USD"){
            CalculoCotacao entity = service.getByCode(moeda)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moeda não foi localizada!"));
            return ResponseEntity.ok(CalculoCotacaoDTO.of(entity));
        } else if (moeda == "EUR") {
            CalculoCotacao entity = service.getByCode(moeda)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moeda não foi localizada!"));
            return ResponseEntity.ok(CalculoCotacaoDTO.of(entity));

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda incorreta");}

    }



}
