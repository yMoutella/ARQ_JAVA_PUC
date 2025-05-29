package br.com.aulas.projeto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.aulas.projeto.dtos.AlunoDto;

@RestController
@RequestMapping(value = "public")
public class AlunoController {

    @GetMapping(value = "aluno")
    public ResponseEntity<Object> getAluno() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("body");
    }

    @PostMapping(value = "aluno")
    public ResponseEntity<Object> postAluno(
            @Validated(AlunoDto.AlunoView.RegistrarAluno.class) @RequestBody @JsonView(AlunoDto.AlunoView.RegistrarAluno.class) AlunoDto alunoDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunoDto);
    }

}
