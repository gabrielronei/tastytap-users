package br.com.fiap.tastytap_users.presentation.user;

import br.com.fiap.tastytap_users.application.user.SimpleUserView;
import br.com.fiap.tastytap_users.application.user.create.CreateUserUseCase;
import br.com.fiap.tastytap_users.application.user.retrieve.FindUserUseCase;
import br.com.fiap.tastytap_users.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

class UserControllerTest {

    private CreateUserUseCase createUserUseCase;
    private FindUserUseCase findUserUseCase;
    private UniqueUserValidator uniqueUserValidator;

    private UserController userController;

    @BeforeEach
    void setUp() {
        this.createUserUseCase = Mockito.mock(CreateUserUseCase.class);
        this.findUserUseCase = Mockito.mock(FindUserUseCase.class);
        this.uniqueUserValidator = Mockito.mock(UniqueUserValidator.class);

        this.userController = new UserController(createUserUseCase, findUserUseCase, uniqueUserValidator);
    }

    @Test
    void shouldReturnBadRequestWhenCpfIsNotValid() {
        ResponseEntity responseEntity = this.userController.findBy("58684954");

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(Map.of("message", "CPF invalido!"));
    }

    @Test
    void shouldReturnNotFoundWhenUserIsNotFound() {
        Mockito.when(findUserUseCase.execute(Mockito.any())).thenReturn(Optional.empty());

        ResponseEntity responseEntity = this.userController.findBy("15341606043");

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldReturnTheUserWhenUserIsFound() {
        SimpleUserView simpleUserView = new SimpleUserView(new User("Tom delonge", "tom@delonge.com", "16410643071"));
        Mockito.when(findUserUseCase.execute(Mockito.any())).thenReturn(Optional.of(simpleUserView));

        ResponseEntity responseEntity = this.userController.findBy("15341606043");

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(simpleUserView);
    }

    @Test
    void shouldReturnCreatedWhenUserIsCreated2() {
        NewUserForm joeHanm = new NewUserForm("Joe Hanm", "john@hanm", "47871249002");
        SimpleUserView simpleUserView = new SimpleUserView(joeHanm.toUser());

        Mockito.when(createUserUseCase.execute(Mockito.any())).thenReturn(Optional.of(simpleUserView));

        ResponseEntity responseEntity = this.userController.save(joeHanm);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(simpleUserView);
    }

    @Test
    void shouldReturnCreatedWhenUserIsCreated() {
        Mockito.when(createUserUseCase.execute(Mockito.any())).thenReturn(Optional.empty());

        ResponseEntity responseEntity = this.userController.save(new NewUserForm("Travis Barker", "travis@barker.com", "47871249002"));

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}