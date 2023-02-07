package com.ordem.compra.calculocotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/calculocotacao")
public class CalculoCotacaoController {

    private final CalculoCotacaoService service;

    @GetMapping("/{moeda}")
    public ResponseEntity getCotacao(@PathVariable String moeda){
        if(moeda == null || moeda.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda não informada");
        } else if (moeda.equals("USD") || moeda.equals("EUR")){
            CalculoCotacaoDTO valor = service.getCotacao(moeda);
            return new ResponseEntity(valor, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Moeda incorreta");}
    }



}
