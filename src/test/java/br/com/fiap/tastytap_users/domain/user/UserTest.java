package br.com.fiap.tastytap_users.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.time.LocalDateTime;

class UserTest {

    @ParameterizedTest
    @NullAndEmptySource
    void constructor__shouldThrowAnExceptionWhenTheFieldsAreBlank(String nullAndEmpty) {
        Assertions.assertThatThrownBy(() -> new User(nullAndEmpty, "legal@email.com", "49533421002"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Name cannot be blank");
        Assertions.assertThatThrownBy(() -> new User(1L, nullAndEmpty, "gab@email.com", "11111111111", LocalDateTime.now(), Role.ADMIN))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Name cannot be blank");

        Assertions.assertThatThrownBy(() -> new User("Gabriel", nullAndEmpty, "54977854098"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Email cannot be blank");
        Assertions.assertThatThrownBy(() -> new User(1L, "Gabriel", nullAndEmpty, "11111111111", LocalDateTime.now(), Role.ADMIN))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Email cannot be blank");

        Assertions.assertThatThrownBy(() -> new User("Thais", "thais@is.com", nullAndEmpty))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("CPF cannot be blank");
        Assertions.assertThatThrownBy(() -> new User(1L, "Thais", "thais@is.com", nullAndEmpty, LocalDateTime.now(), Role.ADMIN))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("CPF cannot be blank");
    }

    @Test
    void constructor__shouldThrowAnExceptionWhenTheFieldsAreNull() {
        Assertions.assertThatThrownBy(() -> new User(null, "Gab", "gab@email.com", "11111111111", LocalDateTime.now(), Role.ADMIN))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Id cannot be null");

        Assertions.assertThatThrownBy(() -> new User(1L, "Thais", "thais@email.com", "11111111111", null, Role.ADMIN))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("CreatedAt cannot be null");

        Assertions.assertThatThrownBy(() -> new User(1L, "MP", "mp@email.com", "11111111111", LocalDateTime.now(), null))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("Role cannot be null");


        User MP = new User(1L, "MP", "mp@email.com", "11111111111", LocalDateTime.now(), Role.REGULAR);
        Assertions.assertThat(MP).isNotNull();
    }

    @Test
    void getCpf__shouldAlwaysReturnACPFWithoutPonctuation() {
        User thais = new User("Thais", "thais@email.com", "606.336.480-35");
        Assertions.assertThat(thais.getCpf()).isEqualTo("60633648035");

        User gab = new User("Gab", "gab@email.com", "17377288000");
        Assertions.assertThat(gab.getCpf()).isEqualTo("17377288000");
    }

    @Test
    void shouldReturnFalseIfUserIsNotEqualTheOtherUser() {
        User user = new User("João", "joao@email.com", "12345678901");
        Assertions.assertThat(user.equals(user)).isTrue();

        Assertions.assertThat(user.equals(null)).isFalse();

        Assertions.assertThat(user.equals("João")).isFalse();

        User anotherUser = new User("João", "joao@email.com", "12345678901");
        Assertions.assertThat(user.equals(anotherUser)).isTrue();

        User maria = new User("Maria", "joao@email.com", "12345678901");
        Assertions.assertThat(user.equals(maria)).isFalse();
    }
}