package br.com.aulas.projeto.exceptions;

public class AlunoDuplicateException extends RuntimeException {
    public AlunoDuplicateException(String name) {
        super("Já existe um usuário cadastrado com o nome " + name + ". Tente novamente com outro nome.");
    }
}