package br.com.aulas.projeto.services;

    import br.com.aulas.projeto.entities.AlunoEntity;
    import br.com.aulas.projeto.exceptions.AlunoNotFoundException;
    import br.com.aulas.projeto.repositories.AlunoRepository;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.ArgumentCaptor;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.junit.jupiter.MockitoExtension;

    import java.util.List;

    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.mockito.Mockito.*;

    @ExtendWith(MockitoExtension.class)
    class AlunoServiceTest {

        @Mock
        private AlunoRepository alunoRepository;

        @InjectMocks
        private AlunoService alunoService;

        @Test
        void testGetAlunosRetornaListaCorreta() {
            AlunoEntity alunoEntity = new AlunoEntity();
            alunoEntity.setId(1L);
            alunoEntity.setName("Micaele");

            when(alunoRepository.findAll()).thenReturn(List.of(alunoEntity));

            List<AlunoEntity> resultado = alunoService.findAll();

            assertEquals(1, resultado.size());
            assertEquals("Micaele", resultado.get(0).getName());
            assertEquals(1L, resultado.get(0).getId());
            verify(alunoRepository).findAll();
        }

        @Test
        void testAddAlunoChamaSaveDoRepositorio() {
            AlunoEntity aluno = new AlunoEntity();
            aluno.setName("Micaele");

            alunoService.saveAluno(aluno);

            ArgumentCaptor<AlunoEntity> captor = ArgumentCaptor.forClass(AlunoEntity.class);
            verify(alunoRepository).save(captor.capture());
            assertEquals("Micaele", captor.getValue().getName());
        }

        @Test
        void testDeleteAlunoExistenteDoRepositorio() {
            Long id = 1L;
            when(alunoRepository.existsById(id)).thenReturn(true);
            alunoService.deleteAluno(id);
            verify(alunoRepository).deleteById(id);
        }

        @Test
        void testDeleteAlunoNaoExisteDoRepositorio() {
            Long id = 1L;
            when(alunoRepository.existsById(id)).thenReturn(false);

            Exception e = assertThrows(AlunoNotFoundException.class, () -> alunoService.deleteAluno(id));
            assertEquals("O aluno com ID 1 não existe em nossa base de dados.", e.getMessage());

            verify(alunoRepository, never()).deleteById(anyLong());
        }
    }