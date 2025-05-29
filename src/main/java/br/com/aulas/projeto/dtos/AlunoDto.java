package br.com.aulas.projeto.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunoDto {

    public AlunoDto() {
        this.id = "";
        this.nome = "";
    }

    @NotBlank(message = "id do aluno é obrigatório")
    private String id;

    @NotBlank(message = "O nome do aluno é obrigatório")
    private String nome;

}
