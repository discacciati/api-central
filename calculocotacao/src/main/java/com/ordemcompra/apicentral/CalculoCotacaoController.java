package com.ordemcompra.apicentral;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/calculocotacao")
public class CalculoCotacaoController {

/*    WebCliente

    WebClient clientCompra = WebClient.builder()
            .baseUrl("http://localhost:8082/v1/compra")
            .defaultHeader(HttpHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE)
            .build();
    WebClient clientCotacao = WebClient.builder()
            .baseUrl("http://localhost:8083/v1/cotacao")
            .defaultHeader(HttpHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE)
            .build();*/


    private final CalculoCotacaoService service;

/*    @GetMapping("{code}")
    public ResponseEntity<CalculoCotacaoDTO> getByCode(@PathVariable String code){
        if(code == null || code.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada a sigla da moeda");
        } else if (code == "USD"){
            CalculoCotacao entity = service.getByCode(code)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada a moeda informada!"));
            return ResponseEntity.ok(CalculoCotacaoDTO.of(entity));
        } else if (code == "EUR") {
            CalculoCotacao entity = service.getByCode(code)
                    .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizada a moeda informada!"));
            return ResponseEntity.ok(CalculoCotacaoDTO.of(entity));

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Sigla da moeda está incorreta");}

    }*/



}
