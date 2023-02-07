package com.ordemcompra.apicentral;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/ordemcompra")
public class OrdemCompraController {
    private final OrdemCompraService service;
    @GetMapping("{Id}")
    public ResponseEntity<OrdemCompraDTO> getById(@PathVariable String id){
        if (id == null || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nâo foi informado nenhum ID");
        }
        OrdemCompra entity = service.getById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não foi possivel encontrar uma ordem de compra."));
        return ResponseEntity.ok(OrdemCompraDTO.of(entity));
    }

    @PostMapping("api/adicionarordemcompra")
    public  ResponseEntity<Void> CriarOrdemCompra(@RequestBody OrdemCompraDTO ordemcompra){
        if (ordemcompra == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra valida");
        }
        if (ordemcompra.getCpf() == null || ordemcompra.getCpf().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cpf");
        }
        if (ordemcompra.getValor_ordem_compra() == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o valor da ordem de compra");
        }
        if (ordemcompra.getTipo_moeda() == null || ordemcompra.getTipo_moeda().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o tipo da moeda");
        }
        if (service.isTipoMoedaValido(ordemcompra.getTipo_moeda())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o tipo da moeda valido");
        }
        if (ordemcompra.getNumero_agencia() == null || ordemcompra.getNumero_agencia().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o número da agencia");
        }

        try{
            service.criar(ordemcompra.toEntity());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro inesperado "+e.toString());
        }

        //TODO logica do metodo
        return ResponseEntity.created(URI.create("/api/ordemcompra/")).build();

    }

}