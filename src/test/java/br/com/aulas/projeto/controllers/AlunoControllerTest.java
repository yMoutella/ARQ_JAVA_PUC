package br.com.aulas.projeto.controllers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.aulas.projeto.dtos.AlunoDto;
import br.com.aulas.projeto.services.AlunoService;

@ExtendWith(MockitoExtension.class)
class AlunoControllerTest {

    @Mock
    private AlunoService alunoService;

    @InjectMocks
    private AlunoController alunoController;

    @Test
    void testGetAlunoRetornaStatusEBodyCorretos() {
        AlunoDto dto = new AlunoDto();
        when(alunoService.getAlunos()).thenReturn(List.of(dto));

        ResponseEntity<Object> response = alunoController.getAluno();

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(List.of(dto), response.getBody());
        verify(alunoService).getAlunos();
    }

    @Test
    void testPostAlunoRetornaStatusECadastraAluno() {
        AlunoDto dto = new AlunoDto();

        ResponseEntity<Object> response = alunoController.createAluno(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(dto, response.getBody());
        verify(alunoService).addAluno(dto);
    }

    @Test
    void testGetAlunoLancaExcecaoQuandoServiceFalha() {
        when(alunoService.getAlunos()).thenThrow(new RuntimeException("Erro"));

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> alunoController.getAluno());
        assertEquals("Erro", thrown.getMessage());
        verify(alunoService).getAlunos();
    }
}
