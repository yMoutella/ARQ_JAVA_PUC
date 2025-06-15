package br.com.aulas.projeto.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class AlunoNotFoundExceptionTest {
 @Test
 void testAlunoNotFoundException() {
     String id = UUID.randomUUID().toString();
     AlunoNotFoundException exception = new AlunoNotFoundException(id);

     assertEquals("O aluno com ID " + id + " não existe em nossa base de dados.", exception.getMessage());
 }

    @Test
    void testHandleAlunoNotFoundException() {
        String id = UUID.randomUUID().toString();
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        AlunoNotFoundException exception = new AlunoNotFoundException(id);

        ResponseEntity<Object> response = handler.handleAlunoNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertTrue(response.getBody() instanceof java.util.Map);
        java.util.Map<String, String> body = (java.util.Map<String, String>) response.getBody();
        assertEquals("O aluno com ID " + id + " não existe em nossa base de dados.", body.get("error"));
    }
}