package br.com.aulas.projeto.exceptions;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(String id) {
        super("O aluno com ID " + id + " não existe em nossa base de dados.");
    }
}