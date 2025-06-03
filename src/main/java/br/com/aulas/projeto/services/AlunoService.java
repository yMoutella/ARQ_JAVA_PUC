package br.com.aulas.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aulas.projeto.dtos.AlunoDto;
import br.com.aulas.projeto.repositories.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Optional<AlunoDto> updateAluno(AlunoDto alunoDto, String id) {
        return alunoRepository.updateAluno(alunoDto, id);
    }

    public List<AlunoDto> getAlunos() {
        return alunoRepository.findAll();
    }

    public void addAluno(AlunoDto aluno) {
        alunoRepository.save(aluno);
    }

    public Boolean removeAluno(String id) {
        return alunoRepository.removeAluno(id);
    }
}