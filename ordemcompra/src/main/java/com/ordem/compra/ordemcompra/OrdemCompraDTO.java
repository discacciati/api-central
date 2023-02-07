package com.ordem.compra.ordemcompra;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdemCompraDTO {


    private Long Id;
    private Long idCliente;
    private String cpfCliente;
    private LocalDate dataSolicitacao;
    private String tipoMoedaEstrangeira;
    private Double valorMoedaEstrangeira;
    private Double valorCotacao;
    private Double valorTotalOperacao;
    private String numeroAgenciaDeRetirada;

    public static OrdemCompraDTO of(OrdemCompra ordemCompra) {
        OrdemCompraDTO dto = new OrdemCompraDTO();
        dto.setId(ordemCompra.getId());
        dto.setIdCliente(ordemCompra.getIdCliente());
        dto.setCpfCliente(ordemCompra.getCpfCliente());
        dto.setDataSolicitacao(ordemCompra.getDataSolicitacao());
        dto.setTipoMoedaEstrangeira(ordemCompra.getTipoMoedaEstrangeira());
        dto.setValorCotacao(ordemCompra.getValorCotacao());
        dto.setValorTotalOperacao(ordemCompra.getValorTotalOperacao());
        dto.setNumeroAgenciaDeRetirada(ordemCompra.getNumeroAgenciaDeRetirada());

        return dto;
    }

    public OrdemCompra toEntity (){
        OrdemCompra entity = new OrdemCompra();
        entity.setId(Id);
        entity.setIdCliente(idCliente);
        entity.setCpfCliente(cpfCliente);
        entity.setDataSolicitacao(dataSolicitacao);
        entity.setTipoMoedaEstrangeira(tipoMoedaEstrangeira);
        entity.setValorCotacao(valorCotacao);
        entity.setValorTotalOperacao(valorTotalOperacao);
        entity.setNumeroAgenciaDeRetirada(numeroAgenciaDeRetirada);
        return entity;
    }
}