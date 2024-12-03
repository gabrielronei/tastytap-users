package br.com.fiap.tastytap_users.applications.user.retrieve;

import br.com.fiap.tastytap_users.applications.user.SimpleUserView;
import br.com.fiap.tastytap_users.applications.user.UserGateway;
import br.com.fiap.tastytap_users.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class DefaultFindUserUseCaseTest {

    private DefaultFindUserUseCase defaultFindUserUseCase;
    private UserGateway userGateway;

    @BeforeEach
    void setUp() {
        this.userGateway = Mockito.mock(UserGateway.class);

        this.defaultFindUserUseCase = new DefaultFindUserUseCase(userGateway);
    }

    @Test
    void execute__shouldReturnOptionalEmptyWhenUserIsNotFound() {
        Mockito.when(userGateway.findByCPF(Mockito.any())).thenReturn(Optional.empty());

        Optional<SimpleUserView> simpleUserView = this.defaultFindUserUseCase.execute(Mockito.any());
        Assertions.assertThat(simpleUserView).isEmpty();
    }

    @Test
    void execute__shouldReturnAnUserWhenIsFound() {
        User tom = new User("tom", "tom@email.com", "32404188003");
        Mockito.when(userGateway.findByCPF(Mockito.any())).thenReturn(Optional.of(tom));

        Optional<SimpleUserView> possibleUserView = this.defaultFindUserUseCase.execute(Mockito.any());

        Assertions.assertThat(possibleUserView).isNotEmpty();
        SimpleUserView userView = possibleUserView.get();
        Assertions.assertThat(userView.getEmail()).isEqualTo(tom.getEmail());
        Assertions.assertThat(userView.getCpf()).isEqualTo(tom.getCpf());
    }
}