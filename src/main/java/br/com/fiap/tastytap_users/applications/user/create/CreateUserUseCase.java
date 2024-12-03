package br.com.fiap.tastytap_users.applications.user.create;

import br.com.fiap.tastytap_users.applications.UseCase;
import br.com.fiap.tastytap_users.applications.user.SimpleUserView;

import java.util.Optional;

public abstract class CreateUserUseCase extends UseCase<NewUserCommand, Optional<SimpleUserView>> {
}
