package br.com.fiap.tastytap_users.applications.user.retrieve;

import br.com.fiap.tastytap_users.applications.UseCase;
import br.com.fiap.tastytap_users.applications.user.SimpleUserView;

import java.util.Optional;

public abstract class FindUserUseCase extends UseCase<String, Optional<SimpleUserView>> {
}
