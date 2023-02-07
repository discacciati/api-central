package com.ordem.compra.cadastro;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CadastroService {
    private final CrudRepository<Cadastro, String> repository;

    public Optional<Cadastro> getById(String id) {
        return repository.findById(id);
    }

    public void adicionar(Cadastro entity) throws Exception {
        if (repository.existsById(entity.getCpf())) {
            throw new Exception();
        }
        repository.save(entity);
    }
}
