package com.br.alura.forumhub.infra.exception;

public class ValidacaoException extends RuntimeException{

    public ValidacaoException(String message) {
        super(message);
    }
}