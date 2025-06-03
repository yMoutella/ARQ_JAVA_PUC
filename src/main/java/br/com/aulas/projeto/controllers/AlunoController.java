package br.com.aulas.projeto.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aulas.projeto.dtos.AlunoDto;
import br.com.aulas.projeto.services.AlunoService;
import jakarta.validation.Valid;

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

    @PostMapping()
    public ResponseEntity<Object> createAluno(
            @Valid @RequestBody AlunoDto alunoDto) {

        alunoService.addAluno(alunoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDto);
    }

    @PatchMapping("/{alunoId}")
    public ResponseEntity<Object> updateAluno(@Valid @RequestBody AlunoDto alunoDto, @PathVariable String alunoId) {

        Optional<AlunoDto> updatedAluno = alunoService.updateAluno(alunoDto, alunoId);

        if (updatedAluno.isEmpty()) {
            Map<String, String> response = new HashMap<>();

            response.put("message", "Aluno não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Aluno atualizado com sucesso!");
        response.put("aluno", alunoDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<Object> removeAluno(@PathVariable String alunoId) {
        var removed = alunoService.removeAluno(alunoId);

        if (removed) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Aluno removido com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Aluno não encontrado!");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}