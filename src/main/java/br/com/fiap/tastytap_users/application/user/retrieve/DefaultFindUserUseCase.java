package br.com.fiap.tastytap_users.application.user.retrieve;

import br.com.fiap.tastytap_users.application.user.SimpleUserView;
import br.com.fiap.tastytap_users.application.user.UserGateway;
import br.com.fiap.tastytap_users.domain.user.CPF;

import java.util.Optional;

public final class DefaultFindUserUseCase extends FindUserUseCase {

    private final UserGateway userGateway;

    public DefaultFindUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Optional<SimpleUserView> execute(String cpf) {
        return userGateway.findByCPF(new CPF(cpf)).map(SimpleUserView::new);
    }
}
