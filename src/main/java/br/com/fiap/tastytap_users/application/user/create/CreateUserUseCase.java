package br.com.fiap.tastytap_users.application.user.create;

import br.com.fiap.tastytap_users.application.UseCase;
import br.com.fiap.tastytap_users.application.user.SimpleUserView;

import java.util.Optional;

public abstract class CreateUserUseCase extends UseCase<NewUserCommand, Optional<SimpleUserView>> {
}
