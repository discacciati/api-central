package com.ordemcompra.apicentral;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public class OrdemCompraService {
    private CrudRepository<OrdemCompra, String> repository;
    public Optional<OrdemCompra> getById(String id) {
        return repository.findById(id);
    }

    public boolean isTipoMoedaValido(String tipoMoeda){
        final Set<String> MOEDAS_VALIDAS = Set.of("USD", "EUR");
        return MOEDAS_VALIDAS.contains(tipoMoeda);

    }

    public void criar(OrdemCompra entity){

    }


}
