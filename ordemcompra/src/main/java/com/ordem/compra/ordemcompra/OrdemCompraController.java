package com.ordem.compra.ordemcompra;

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

    @PostMapping
    public  ResponseEntity<Void> CriarOrdemCompra(@RequestBody OrdemCompraDTO ordemCompraReq){
        if (ordemCompraReq == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma ordem de compra valida");
        }
        if (ordemCompraReq.getCpfCliente() == null || ordemCompraReq.getCpfCliente().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um cpf");
        }
        if (ordemCompraReq.getValorMoedaEstrangeira() == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o valor da ordem de compra");
        }
        if (ordemCompraReq.getTipoMoeda() == null || ordemCompraReq.getTipoMoeda().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o tipo da moeda");
        }
        if (service.isTipoMoedaValido(ordemCompraReq.getTipoMoeda())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o tipo da moeda valido");
        }
        if (ordemCompraReq.getNumeroAgenciaRetirada() == null || ordemCompraReq.getNumeroAgenciaRetirada().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o número da agencia");
        }

        try{
            OrdemCompra ordemCompraRes = service.criar(ordemCompraReq.toEntity());
            return new ResponseEntity(ordemCompraRes,HttpStatus.CREATED);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro inesperado "+e.toString());
        }



    }

}