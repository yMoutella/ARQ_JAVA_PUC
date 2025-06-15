package br.com.aulas.projeto.repositories;

import br.com.aulas.projeto.entities.AlunoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository repo;

    @Test
    void testSaveAndFindAll() {
        AlunoEntity aluno = new AlunoEntity();
        aluno.setName("Micaele");

        repo.save(aluno);

        List<AlunoEntity> alunos = repo.findAll();

        assertEquals(1, alunos.size());
        assertEquals("Micaele", alunos.get(0).getName());
    }
}