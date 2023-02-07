package com.ordem.compra.ordemcompra;
import lombok.Data;

@Data
public class CotacaoDTO {

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
    private String create_date;

    public CotacaoDTO(){}

    public CotacaoDTO(String code, String codein, String name, Double high, Double low, Double varBid, Double pctChange, Double bid, Double ask, Double timestamp, String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }
}
