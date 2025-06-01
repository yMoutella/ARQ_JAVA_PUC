package br.com.aulas.projeto.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.aulas.projeto.dtos.AlunoDto;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoRepository {
    private final List<AlunoDto> alunos = new ArrayList<>();

    public List<AlunoDto> findAll() {
        return alunos;
    }

    public void save(AlunoDto aluno) {
        alunos.add(aluno);
    }
}