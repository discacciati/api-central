package com.ordemcompra.apicentral;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
public class OrdemCompra {
    @Id
    private String cpf;
    private String tipo_moeda;
    private Long valor_ordem_compra;
    private String numero_agencia;
    private String idCliente;



}
