package com.ordemcompra.apicentral;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/ordemcompra")
public class OrdemCompraController {

    @GetMapping("{Id}")
    public ResponseEntity<String> getById(@PathVariable String Id){

        return ResponseEntity.ok("{CPF_MOCKADO : 'TO DO'");
    }

    @PostMapping("api/adicionarordemcompra")
    public  ResponseEntity<Void> CriarOrdemCompra(@RequestBody OrdemCompraDTO ordemcompra){
    //TODO logica do metodo
        return ResponseEntity.created(URI.create("/api/ordemcompra/")).build();

    }

}
