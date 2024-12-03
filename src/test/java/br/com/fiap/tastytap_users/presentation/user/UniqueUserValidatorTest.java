package br.com.fiap.tastytap_users.presentation.user;

import br.com.fiap.tastytap_users.applications.user.UserGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueUserValidatorTest {

    private UserGateway userGateway;
    private UniqueUserValidator uniqueUserValidator;

    @BeforeEach
    void setUp() {
        this.userGateway = Mockito.mock(UserGateway.class);

        this.uniqueUserValidator = new UniqueUserValidator(userGateway);
    }

    @Test
    void validate__shouldReturnNoErrorsWhenUserNotExistsOnDatabase() {
        NewUserForm newUserForm = new NewUserForm("Gabs", "gabs@email.com", "96559584003");

        BindingResult result = new BeanPropertyBindingResult(newUserForm, "newUserForm");
        this.uniqueUserValidator.validate(newUserForm, result);

        assertThat(result.getErrorCount()).isEqualTo(0);
    }

    @Test
    void validate__shouldReturnIfAnErrorIsAlreadySet() {
        NewUserForm newUserForm = new NewUserForm("Gabs", "gabs@email.com", "96559584003");

        BindingResult result = new BeanPropertyBindingResult(newUserForm, "newUserForm");
        result.rejectValue("email", "email", "This email already exists");
        this.uniqueUserValidator.validate(newUserForm, result);

        Mockito.verify(this.userGateway, Mockito.never()).findByEmail(newUserForm.getEmail());
        assertThat(result.getErrorCount()).isEqualTo(1);
    }

    @Test
    void validate__shouldReturnAnErrorWhenUserExistsByEmail() {
        NewUserForm newUserForm = new NewUserForm("Thais", "thais@email.com", "41309943010");

        Mockito.when(this.userGateway.findByEmail(newUserForm.getEmail())).thenReturn(Optional.of(newUserForm.toUser()));
        BindingResult result = new BeanPropertyBindingResult(newUserForm, "newUserForm");
        this.uniqueUserValidator.validate(newUserForm, result);

        assertThat(result.getErrorCount()).isEqualTo(1);
        assertThat(result.getAllErrors().get(0).getDefaultMessage()).isEqualTo("já existe um usuario com este email!");
    }


    @Test
    void validate__shouldReturnAnErrorWhenUserExistsCpf() {
        NewUserForm newUserForm = new NewUserForm("Thais", "thais@email.com", "41309943010");

        Mockito.when(this.userGateway.findByEmail(newUserForm.getEmail())).thenReturn(Optional.empty());
        Mockito.when(this.userGateway.findByCPF(Mockito.any())).thenReturn(Optional.of(newUserForm.toUser()));
        BindingResult result = new BeanPropertyBindingResult(newUserForm, "newUserForm");
        this.uniqueUserValidator.validate(newUserForm, result);

        assertThat(result.getErrorCount()).isEqualTo(1);
        assertThat(result.getAllErrors().get(0).getDefaultMessage()).isEqualTo("já existe um usuario com este cpf!");
    }
}