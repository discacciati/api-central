package com.ordem.compra.ordemcompra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class OrdemCompraService {
    private CrudRepository<OrdemCompra, String> repository;
    public Optional<OrdemCompra> getById(String id) {
        return repository.findById(id);
    }

    public boolean isTipoMoedaValido(String tipoMoeda){
        final Set<String> MOEDAS_VALIDAS = Set.of("USD", "EUR");
        return MOEDAS_VALIDAS.contains(tipoMoeda);

    }

    public OrdemCompra criar(OrdemCompra entity){
        CadastroClientApi cadastroClientApi = new CadastroClientApi();
        CotacaoClientApi cotacaoClientApi = new CotacaoClientApi();
        CadastroDTO cadastro = cadastroClientApi.getCadastroPessoa(entity.getCpfCliente());

        try{
            if (cadastro == null){
                throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Cadastro nao encontrado");
            }
            entity.setCpfCliente(cadastro.getCpf());
            entity.setId(cadastro.getId());
            CotacaoDTO cotacao = cotacaoClientApi.getCotacaoMoeda(entity.getTipoMoeda());
            entity.setValorCotacao(cotacao.getAsk());
            entity.setDataSolicitacao(LocalDate.now());
            entity.setTipoMoeda(cotacao.getCode());
            entity.setValorTotalOperacao(cotacao.getAsk()*entity.getValorMoedaEstrangeira());
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro inesperado no service" + e.toString());
        }
        return repository.save(entity);
    }


}
