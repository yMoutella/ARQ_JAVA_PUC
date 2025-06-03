package br.com.aulas.projeto.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.aulas.projeto.dtos.AlunoDto;

@Repository
public class AlunoRepository {

    private final List<AlunoDto> alunos = new ArrayList<>();

    public Boolean removeAluno(String id) {
        int pos = 0;
        for (AlunoDto tmpAluno : alunos) {
            if (tmpAluno.getId().equals(id)) {
                alunos.remove(pos);
                return true;
            }

            pos++;
        }

        return false;
    }

    public Optional<AlunoDto> updateAluno(AlunoDto alunoDto, String id) {

        int pos = 0;
        for (AlunoDto tmpAluno : alunos) {

            if (tmpAluno.getId().equals(id)) {
                alunos.add(pos, alunoDto);
                return Optional.of(alunoDto);
            }

            pos++;
        }

        return Optional.empty();

    }

    public List<AlunoDto> findAll() {
        return alunos;
    }

    public void save(AlunoDto aluno) {
        alunos.add(aluno);
    }
}