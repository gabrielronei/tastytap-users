package br.com.fiap.tastytap_users.presentation.errors;

import br.com.fiap.tastytap_users.infraestructure.exceptions.ApiException;

public record ApiError(String error) {

    public ApiError(ApiException apiException) {
        this(apiException.getMessage());
    }
}
