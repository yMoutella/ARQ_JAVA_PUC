package br.com.aulas.projeto.services;

import br.com.aulas.projeto.dtos.AlunoDto;
import br.com.aulas.projeto.repositories.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @Test
    void testGetAlunosRetornaListaCorreta() {
        AlunoDto aluno = new AlunoDto();
        when(alunoRepository.findAll()).thenReturn(List.of(aluno));

        List<AlunoDto> resultado = alunoService.getAlunos();

        assertEquals(1, resultado.size());
        assertEquals(aluno, resultado.get(0));
        verify(alunoRepository).findAll();
    }

    @Test
    void testAddAlunoChamaSaveDoRepositorio() {
        AlunoDto aluno = new AlunoDto();

        alunoService.addAluno(aluno);

        verify(alunoRepository).save(aluno);
    }
}
