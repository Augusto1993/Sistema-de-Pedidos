package br.com.sistemadepedidos.services;

public class AuthorizationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthorizationException(String msg) {
        super(msg);
    }

    public AuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}