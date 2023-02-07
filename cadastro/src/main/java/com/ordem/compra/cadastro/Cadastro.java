package com.ordem.compra.cadastro;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cadastro {

    @Id
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String estadoCivil;
    private String sexo;


}
