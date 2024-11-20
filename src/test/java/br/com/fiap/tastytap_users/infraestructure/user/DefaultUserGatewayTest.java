package br.com.fiap.tastytap_users.infraestructure.user;

import br.com.fiap.tastytap_users.domain.user.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

class DefaultUserGatewayTest {

    private UserRepository userRepository;
    private DefaultUserGateway userGateway;

    @BeforeEach
    void setUp() {
        this.userRepository = Mockito.mock(UserRepository.class);

        this.userGateway = new DefaultUserGateway(this.userRepository);
    }

    @Test
    void shouldReturnEmptyOptionalWhenUserNotFound() {
        CPF cpf = new CPF("70316584037");
        Optional<User> possibleUser = this.userGateway.findByCPF(cpf);

        Assertions.assertThat(possibleUser).isEmpty();

        Mockito.when(userRepository.findByCpf(cpf.getCPFWithoutPonctuation())).thenReturn(Optional.of(new UserEntity(new User(10L, "Angel di maria", "angel@dimaria.com", "99084691008", LocalDateTime.now(), Role.ADMIN))));
        possibleUser = this.userGateway.findByCPF(cpf);

        Assertions.assertThat(possibleUser).isNotEmpty();
    }

    @Test
    void shouldReturnUserWhenFindByEmail() {
        String email = "email@email.com";
        Optional<User> possibleUser = this.userGateway.findByEmail(email);

        Assertions.assertThat(possibleUser).isEmpty();

        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(new UserEntity(new User(10L, "Angel di maria", "angel@dimaria.com", "99084691008", LocalDateTime.now(), Role.ADMIN))));
        possibleUser = this.userGateway.findByEmail(email);

        Assertions.assertThat(possibleUser).isNotEmpty();
    }

    @Test
    void shouldReturnSavedUser() {
        User angelDiMaria = new User(10L, "Angel di maria", "angel@dimaria.com", "99084691008", LocalDateTime.now(), Role.ADMIN);

        Mockito.when(userRepository.save(Mockito.any())).thenReturn(new UserEntity(angelDiMaria));

        User save = this.userGateway.save(angelDiMaria);
        Assertions.assertThat(save).isNotNull();
    }
}