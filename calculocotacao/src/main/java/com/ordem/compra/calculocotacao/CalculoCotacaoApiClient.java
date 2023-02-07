package com.ordem.compra.calculocotacao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CalculoCotacaoApiClient<InstanceInfo> {
    private String ENDPOINT = "https://economia.awesomeapi.com.br/";

    private WebClient client = WebClient.create();

    public List<CalculoCotacaoDTO> getCotacaoMoeda(String moeda) {
        ENDPOINT = ENDPOINT + moeda;
        //Fazer o GET no endpoint com a sigla da moeda e transformar o Body recebido em Classe
        Flux<CalculoCotacaoDTO> valorCotacao = client.get().uri(ENDPOINT).retrieve().bodyToFlux(CalculoCotacaoDTO.class);

        //Primeiro pega a Lista do Body gerado. Usar o block para o Flux esperar o Corpo ser copiado,
        //E retorna a Lista que tem como objeto, na posição[0] que a api envia.
        return valorCotacao.collect(Collectors.toList()).share().block();
    }
}
