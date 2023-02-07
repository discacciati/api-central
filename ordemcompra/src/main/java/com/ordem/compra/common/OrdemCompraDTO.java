package com.ordem.compra.common;

import lombok.Data;

@Data
public class OrdemCompraDTO {

    private String cpf;
    private String tipo_moeda;
    private Long valor_ordem_compra;
    private String numero_agencia;
    private String idCliente;

    public static OrdemCompraDTO of(OrdemCompra ordemCompra){
        OrdemCompraDTO dto = new OrdemCompraDTO();
        dto.setCpf(ordemCompra.getCpf());
        dto.setValor_ordem_compra(ordemCompra.getValor_ordem_compra());
        dto.setTipo_moeda(ordemCompra.getTipo_moeda());
        dto.setNumero_agencia(ordemCompra.getNumero_agencia());
        return dto;
    }

    public OrdemCompra toEntity(){
        OrdemCompra entity = new OrdemCompra();
        entity.setCpf(cpf);
        entity.setValor_ordem_compra(valor_ordem_compra);
        entity.setTipo_moeda(tipo_moeda);
        entity.setNumero_agencia(numero_agencia);
        return entity;
    }

}