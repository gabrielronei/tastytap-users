package br.com.fiap.tastytap_users.applications.user.create;

import br.com.fiap.tastytap_users.applications.user.UserGateway;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CreateUserUseCaseTest {

    @Test
    public void should_create_user_correctly() {
        CreateUserUseCase createUserUseCase = new DefaultCreateUserUseCase(Mockito.mock(UserGateway.class));

        Assertions.assertThat(createUserUseCase).isNotNull();
    }
}