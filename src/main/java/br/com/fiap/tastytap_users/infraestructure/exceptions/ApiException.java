package br.com.fiap.tastytap_users.infraestructure.exceptions;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
