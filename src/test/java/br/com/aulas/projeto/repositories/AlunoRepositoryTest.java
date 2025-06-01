package br.com.aulas.projeto.repositories;

import br.com.aulas.projeto.dtos.AlunoDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoRepositoryTest {

    @Test
    void testSaveAndFindAll() {
        AlunoRepository repo = new AlunoRepository();

        AlunoDto aluno = new AlunoDto();
        aluno.setId("1");
        aluno.setNome("Micaele Carvalho");

        repo.save(aluno);

        List<AlunoDto> alunos = repo.findAll();

        assertEquals(1, alunos.size());
        assertEquals("1", alunos.get(0).getId());
        assertEquals("Micaele Carvalho", alunos.get(0).getNome());
    }
}
