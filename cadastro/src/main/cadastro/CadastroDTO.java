package main.cadastro;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CadastroDTO {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String estadoCivil;
    private String sexo;



    public static CadastroDTO of(Cadastro cadastro) {
        CadastroDTO dto = new CadastroDTO(cadastro.getNome(), cadastro.getCpf(), cadastro.getNascimento(), cadastro.getEstadoCivil(), cadastro.getSexo() );
         dto.nome = cadastro.getNome();
         dto.cpf = cadastro.getCpf();
         dto.nascimento = cadastro.getNascimento();
         dto.estadoCivil = cadastro.getEstadoCivil();
         dto.sexo = cadastro.getSexo();
        return dto;
    }

    public Cadastro toEntity() {
        Cadastro entity = new Cadastro();
        entity.setCpf(nome);
        entity.setNome(cpf);
        entity.setNascimento(nascimento);
        entity.setEstadoCivil(estadoCivil);
        entity.setSexo(sexo);
        return entity;
    }
}
