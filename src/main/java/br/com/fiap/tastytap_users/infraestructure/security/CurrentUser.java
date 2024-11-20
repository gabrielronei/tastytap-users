package br.com.fiap.tastytap_users.infraestructure.security;

import br.com.fiap.tastytap_users.domain.user.User;

import java.util.Optional;


public interface CurrentUser {

    Optional<User> getPossibleUser();
}
