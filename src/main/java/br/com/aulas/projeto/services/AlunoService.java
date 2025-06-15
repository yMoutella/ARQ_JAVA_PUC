package br.com.aulas.projeto.services;

import br.com.aulas.projeto.entities.AlunoEntity;
import br.com.aulas.projeto.exceptions.AlunoDuplicateException;
import br.com.aulas.projeto.exceptions.AlunoNotFoundException;
import br.com.aulas.projeto.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    public AlunoRepository repository;

    public List<AlunoEntity> findAll() {
        return repository.findAll();
    }

    public List<AlunoEntity> findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    public AlunoEntity saveAluno(AlunoEntity aluno) {
        aluno.setId(null);

        List<AlunoEntity> existentes = repository.findByNameIgnoreCase(aluno.getName());
        if (!existentes.isEmpty()) {
            throw new AlunoDuplicateException(aluno.getName());
        }
        return repository.save(aluno);
    }

    public void deleteAluno(Long id) {
        if (!repository.existsById(id)) {
            throw new AlunoNotFoundException(id.toString());
        }
        repository.deleteById(id);
    }
}