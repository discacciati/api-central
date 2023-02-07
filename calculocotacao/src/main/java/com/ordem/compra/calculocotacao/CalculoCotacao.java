package com.ordem.compra.calculocotacao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CalculoCotacao {

    @Id
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


}
