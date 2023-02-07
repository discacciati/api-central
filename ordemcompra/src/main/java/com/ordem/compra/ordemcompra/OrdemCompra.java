package com.ordem.compra.ordemcompra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class OrdemCompra {

    @Id
    private Long Id;
    private Long idCliente;
    private String cpfCliente;
    private LocalDate dataSolicitacao;
    private String tipoMoedaEstrangeira;
    private Double valorMoedaEstrangeira;
    private Double valorCotacao;
    private Double valorTotalOperacao;
    private String numeroAgenciaDeRetirada;


}
