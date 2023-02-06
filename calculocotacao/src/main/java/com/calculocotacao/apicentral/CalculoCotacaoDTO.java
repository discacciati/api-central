package com.calculocotacao.apicentral;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CalculoCotacaoDTO {

    private String code;
    private String codein;
    private String name;
    private Double high;
    private Double low;
    private Double varBid;
    private Double pctChange;
    private Double bid;
    private Double ask;
    private Double timestamp;
    private LocalDateTime create_date;

    public static CalculoCotacaoDTO of(CalculoCotacao calculoCotacao){
        CalculoCotacaoDTO dto = new CalculoCotacaoDTO();
        dto.setCode(calculoCotacao.getCode());
        dto.setCodein(calculoCotacao.getCodein());
        dto.setName(calculoCotacao.getName());
        dto.setHigh(calculoCotacao.getHigh());
        dto.setLow(calculoCotacao.getLow());
        dto.setVarBid(calculoCotacao.getVarBid());
        dto.setPctChange(calculoCotacao.getPctChange());
        dto.setBid(calculoCotacao.getBid());
        dto.setAsk(calculoCotacao.getAsk());
        dto.setTimestamp(calculoCotacao.getTimestamp());
        dto.setCreate_date(calculoCotacao.getCreate_date());
        return dto;

    }

    public CalculoCotacao toEntity(){
        CalculoCotacao entity = new CalculoCotacao();
        entity.setCode(code);
        entity.setCodein(codein);
        entity.setName(name);
        entity.setHigh(high);
        entity.setLow(low);
        entity.setVarBid(varBid);
        entity.setPctChange(pctChange);
        entity.setBid(bid);
        entity.setAsk(ask);
        entity.setTimestamp(timestamp);
        entity.setCreate_date(create_date);
        return entity;

    }



}
