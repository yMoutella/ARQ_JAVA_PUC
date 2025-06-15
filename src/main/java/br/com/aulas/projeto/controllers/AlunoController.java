package br.com.aulas.projeto.controllers;

import br.com.aulas.projeto.entities.AlunoEntity;
import br.com.aulas.projeto.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> getAlunos(@RequestParam(required = false) String name) {
        if (name != null) {
            List<AlunoEntity> alunos = alunoService.findByName(name);
            if (alunos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(alunos);
        }
        return ResponseEntity.ok(alunoService.findAll());
    }

    @PostMapping("criar")
    public ResponseEntity<?> postAluno(
            @Valid @RequestBody AlunoEntity alunoEntity) {
        alunoService.saveAluno(alunoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}