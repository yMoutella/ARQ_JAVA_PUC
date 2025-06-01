package br.com.aulas.projeto.services;

import java.util.List;

import br.com.aulas.projeto.dtos.AlunoDto;
import br.com.aulas.projeto.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDto> getAlunos() {
        return alunoRepository.findAll();
    }

    public void addAluno(AlunoDto aluno) {
        alunoRepository.save(aluno);
    }
}