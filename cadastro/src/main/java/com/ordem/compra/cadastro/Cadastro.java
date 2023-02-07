package com.ordem.compra.cadastro;

import java.time.LocalDate;

import lombok.Data;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import java.time.LocalDate;

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
