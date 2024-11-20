package br.com.fiap.tastytap_users.application.user.retrieve;

import br.com.fiap.tastytap_users.application.UseCase;
import br.com.fiap.tastytap_users.application.user.SimpleUserView;

import java.util.Optional;

public abstract class FindUserUseCase extends UseCase<String, Optional<SimpleUserView>> {
}
