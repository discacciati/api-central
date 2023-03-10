package com.ordem.compra.cadastro;

import lombok.RequiredArgsConstructor;
//import neves.cristiano.comum.exceptions.EntidadeDuplicadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {
    private final CadastroService service;
    @GetMapping("{cpf}")
    public ResponseEntity<CadastroDTO> getByCpf(@PathVariable String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado um CPF!");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        Optional<Cadastro> encontrado = service.getById(cpf);
        Cadastro entity = encontrado.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não foi localizada uma pessoa com o CPF informado!"));
        return ResponseEntity.ok(CadastroDTO.of(entity));
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CadastroDTO cadastro) {
        if (cadastro == null || cadastro.getCpf() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa válida");
        }
        String clearCpf = cadastro.getCpf().replaceAll("[\\.-]", "");
        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com CPF válido");
        }
        if (cadastro.getNome() == null || cadastro.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com Nome válido");
        }
        try {
            service.adicionar(cadastro.toEntity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe uma pessoa com o CPF informado");
        }
        return ResponseEntity.created(URI.create("/api/cadastro/" + clearCpf)).build();
    }
}

