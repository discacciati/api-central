package com.ordem.compra.calculocotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CalculoCotacaoService {

    private final CalculoCotacaoRepository repository;
    private final CalculoCotacaoApiClient calculoCotacaoApiClient;

    public Double getCotacao(String moeda) {
        CalculoCotacaoApiClient cotacaoMoeda = new CalculoCotacaoApiClient();
        CalculoCotacaoDTO valorMoeda = (CalculoCotacaoDTO) cotacaoMoeda.getCotacaoMoeda(moeda).get(0);

        return valorMoeda.getBid();

    }

}
