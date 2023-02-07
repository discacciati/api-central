package com.calculocotacao.apicentral;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CalculoCotacaoService {

    private final CalculoCotacaoRepository repository;
    private final CalculoCotacaoApiClient calculoCotacaoApiClient;

    public Optional<CalculoCotacao> getByCode(String code) {
        return repository.findById(code);
    }

}
