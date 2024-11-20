package br.com.fiap.tastytap_users.application.user.create;

import br.com.fiap.tastytap_users.domain.user.CPF;
import br.com.fiap.tastytap_users.domain.user.User;

public interface NewUserCommand {

    String getName();
    String getEmail();
    CPF getDomainCPF();
    User toUser();
}
