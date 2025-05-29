package br.com.aulas.projeto.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aulas.projeto.dtos.AlunoDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "aluno")
public class AlunoController {

    private static ArrayList<AlunoDto> alunos = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<Object> getAluno() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunos);
    }

    @PostMapping(value = "criar")
    public ResponseEntity<Object> postAluno(
            @Valid @RequestBody AlunoDto alunoDto) {

        this.alunos.add(alunoDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunoDto);
    }

}
