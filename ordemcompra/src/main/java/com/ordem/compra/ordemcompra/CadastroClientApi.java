package com.ordem.compra.ordemcompra;


import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CadastroClientApi {

    private String ENDPOINT = "http://localhost:8081/api/cadastro/";

    private WebClient client = WebClient.create();

    public CadastroDTO getCadastroPessoa(String cpf) {
        ENDPOINT = ENDPOINT + cpf;
        //Fazer o GET no endpoint com a sigla da moeda e transformar o Body recebido em Classe
        Mono<CadastroDTO> cadastroPessoa = client.get().uri(ENDPOINT).retrieve().bodyToMono(CadastroDTO.class);

        //Primeiro pega a Lista do Body gerado. Usar o block para o Flux esperar o Corpo ser copiado,
        //E retorna a Lista que tem como objeto, na posição[0] que a api envia.
        return cadastroPessoa.block();
    }
}
