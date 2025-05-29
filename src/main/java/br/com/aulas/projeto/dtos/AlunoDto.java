package br.com.aulas.projeto.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunoDto {

    public interface AlunoView {
        public static interface RegistrarAluno {
        }
    }

    @JsonView({ AlunoView.RegistrarAluno.class })
    @NotBlank(message = "id do aluno é obrigatório")
    private String id;

    @JsonView({ AlunoView.RegistrarAluno.class })
    @NotBlank(message = "O nome do aluno é obrigatório")
    private String nome;

}
