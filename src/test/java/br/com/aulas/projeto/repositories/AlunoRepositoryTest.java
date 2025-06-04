package br.com.aulas.projeto.repositories;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.aulas.projeto.dtos.AlunoDto;

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

    @Test
    void updateAluno() {
        AlunoDto aluno = new AlunoDto();

        aluno.setId("1");
        aluno.setNome("Yure Moutella");

        AlunoRepository repo = new AlunoRepository();
        repo.save(aluno);

        var updatedAluno = repo.updateAluno(aluno, "2");
        assertEquals(updatedAluno, updatedAluno);

        var emptyAluno = repo.updateAluno(aluno, "2");
        assertEquals(Optional.empty(), emptyAluno);

    }

    @Test
    void removeAluno() {
        AlunoDto aluno = new AlunoDto();

        aluno.setId("1");
        aluno.setNome("Yure Moutella");

        AlunoRepository repo = new AlunoRepository();

        repo.save(aluno);

        assertEquals(true, repo.removeAluno(aluno.getId()));
        assertEquals(false, repo.removeAluno(aluno.getId()));
    }
}
