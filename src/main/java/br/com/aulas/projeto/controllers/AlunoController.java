package br.com.aulas.projeto.controllers;

import br.com.aulas.projeto.dtos.AlunoDto;
import br.com.aulas.projeto.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping()
    public ResponseEntity<Object> getAluno() {
        List<AlunoDto> alunos = alunoService.getAlunos();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunos);
    }

    @PostMapping(value = "criar")
    public ResponseEntity<Object> postAluno(
            @Valid @RequestBody AlunoDto alunoDto) {

        alunoService.addAluno(alunoDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alunoDto);
    }
}