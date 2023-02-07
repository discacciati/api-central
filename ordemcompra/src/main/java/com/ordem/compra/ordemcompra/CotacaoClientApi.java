package com.ordem.compra.ordemcompra;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CotacaoClientApi<InstanceInfo> {
    private String ENDPOINT = "http://localhost:8082/api/calculocotacao/";

    private WebClient client = WebClient.create();

    public CotacaoDTO getCotacaoMoeda(String moeda) {
        ENDPOINT = ENDPOINT + moeda;
        //Fazer o GET no endpoint com a sigla da moeda e transformar o Body recebido em Classe
        Mono<CotacaoDTO> valorCotacao = client.get().uri(ENDPOINT).retrieve().bodyToMono(CotacaoDTO.class);

        //Primeiro pega a Lista do Body gerado. Usar o block para o Flux esperar o Corpo ser copiado,
        //E retorna a Lista que tem como objeto, na posição[0] que a api envia.
        return valorCotacao.block();
    }
}
