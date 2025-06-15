package br.com.aulas.projeto.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> errorHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(name, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<Object> handleAlunoNotFoundException(AlunoNotFoundException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", ex.getMessage());
        errorBody.put("status", HttpStatus.NOT_FOUND.value());
        errorBody.put("message", ex.getMessage());
        errorBody.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlunoDuplicateException.class)
    public ResponseEntity<Object> handleAlunoDuplicadoException(AlunoDuplicateException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", ex.getMessage());
        errorBody.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorBody.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(errorBody, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}