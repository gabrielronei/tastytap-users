package br.com.fiap.tastytap_users.infraestructure.user;

import br.com.fiap.tastytap_users.domain.user.Role;
import br.com.fiap.tastytap_users.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class UserEntityTest {

    @Test
    void shouldCreateUser() {
        User user = new User(1L, "Emily Armstrong", "emily@lp.com", "00842176004", LocalDateTime.now(), Role.ADMIN);

        UserEntity userEntity = new UserEntity(user);

        Assertions.assertThat(userEntity.getCpf()).isEqualTo(user.getCpf());
        Assertions.assertThat(userEntity.getRole()).isEqualTo(user.getRole());
        Assertions.assertThat(userEntity.toDomain()).isEqualTo(user);
        Assertions.assertThat(userEntity.toDomain().hashCode()).isEqualTo(user.hashCode());
    }
}