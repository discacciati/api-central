package com.ordem.compra.ordemcompra;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdemCompraDTO {


    private Long Id;
    private Long idCliente;
    private String cpfCliente;
    private LocalDate dataSolicitacao;
    private String tipoMoeda;
    private Double valorMoedaEstrangeira;
    private Double valorCotacao;
    private Double valorTotalOperacao;
    private String numeroAgenciaRetirada;

    public static OrdemCompraDTO of(OrdemCompra ordemCompra) {
        OrdemCompraDTO dto = new OrdemCompraDTO();
        dto.setId(ordemCompra.getId());
        dto.setIdCliente(ordemCompra.getIdCliente());
        dto.setCpfCliente(ordemCompra.getCpfCliente());
        dto.setDataSolicitacao(ordemCompra.getDataSolicitacao());
        dto.setTipoMoeda(ordemCompra.getTipoMoeda());
        dto.setValorCotacao(ordemCompra.getValorCotacao());
        dto.setValorTotalOperacao(ordemCompra.getValorTotalOperacao());
        dto.setValorMoedaEstrangeira(ordemCompra.getValorMoedaEstrangeira());
        dto.setNumeroAgenciaRetirada(ordemCompra.getNumeroAgenciaRetirada());

        return dto;
    }

    public OrdemCompra toEntity (){
        OrdemCompra entity = new OrdemCompra();
        entity.setId(Id);
        entity.setIdCliente(idCliente);
        entity.setCpfCliente(cpfCliente);
        entity.setDataSolicitacao(dataSolicitacao);
        entity.setTipoMoeda(tipoMoeda);
        entity.setValorCotacao(valorCotacao);
        entity.setValorTotalOperacao(valorTotalOperacao);
        entity.setValorMoedaEstrangeira(valorMoedaEstrangeira);
        entity.setNumeroAgenciaRetirada(numeroAgenciaRetirada);
        return entity;
    }
}