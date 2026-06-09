package com.marombit.exception;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
        super("Aluno não encontrado. ID: " + id);
    }
}
