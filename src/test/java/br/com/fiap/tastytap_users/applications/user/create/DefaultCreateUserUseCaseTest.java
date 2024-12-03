package br.com.fiap.tastytap_users.applications.user.create;

import br.com.fiap.tastytap_users.applications.user.SimpleUserView;
import br.com.fiap.tastytap_users.applications.user.UserGateway;
import br.com.fiap.tastytap_users.presentation.user.NewUserForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class DefaultCreateUserUseCaseTest {
    private UserGateway userGateway;
    private DefaultCreateUserUseCase defaultCreateUserUseCase;

    @BeforeEach
    void setUp() {
        this.userGateway = Mockito.mock(UserGateway.class);

        this.defaultCreateUserUseCase = new DefaultCreateUserUseCase(userGateway);
    }

    @Test
    public void create__shouldReturnAnExceptionWhenUserExistsByEmail() {
        NewUserForm form = new NewUserForm("Gabriel", "gabriel@gmail.com", "52643331060");

        Mockito.when(this.userGateway.findByEmail(form.getEmail())).thenReturn(Optional.of(form.toUser()));

        Assertions.assertThatThrownBy(() -> this.defaultCreateUserUseCase.execute(form))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Já existe um usuario com este e-mail ou cpf!");
    }

    @Test
    public void create__shouldReturnAnExceptionWhenUserExistsByCPF() {
        NewUserForm form = new NewUserForm("Gabriel", "gabriel@gmail.com", "52643331060");

        Mockito.when(this.userGateway.findByEmail(form.getEmail())).thenReturn(Optional.empty());
        Mockito.when(this.userGateway.findByCPF(form.getDomainCPF())).thenReturn(Optional.of(form.toUser()));

        Assertions.assertThatThrownBy(() -> this.defaultCreateUserUseCase.execute(form))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Já existe um usuario com este e-mail ou cpf!");
    }

    @Test
    public void create__shouldReturnAnEmptyUser() {
        NewUserForm form = new NewUserForm("Gabriel", "gabriel@gmail.com", "52643331060");

        Mockito.when(this.userGateway.findByEmail(form.getEmail())).thenReturn(Optional.empty());

        Optional<SimpleUserView> possibleUser = this.defaultCreateUserUseCase.execute(form);
        Assertions.assertThat(possibleUser).isEmpty();
    }

    @Test
    public void create__shouldReturnAnEmptyUserByCpf() {
        NewUserForm form = new NewUserForm("Gabriel", "gabriel@gmail.com", "52643331060");

        Mockito.when(this.userGateway.findByCPF(form.getDomainCPF())).thenReturn(Optional.empty());

        Optional<SimpleUserView> possibleUser = this.defaultCreateUserUseCase.execute(form);
        Assertions.assertThat(possibleUser).isEmpty();
    }

    @Test
    public void create__shouldReturnAnUser() {
        NewUserForm form = new NewUserForm("Gabriel", "gabriel@gmail.com", "52643331060");

        Mockito.when(this.userGateway.findByEmail(form.getEmail())).thenReturn(Optional.empty());
        Mockito.when(this.userGateway.findByCPF(form.getDomainCPF())).thenReturn(Optional.empty());

        Mockito.when(this.userGateway.save(Mockito.any())).thenReturn(form.toUser());
        Optional<SimpleUserView> possibleUser = this.defaultCreateUserUseCase.execute(form);


        Assertions.assertThat(possibleUser.isPresent()).isTrue();
        SimpleUserView simpleUserView = possibleUser.get();
        Assertions.assertThat(simpleUserView.getName()).isEqualTo(form.getName());
        Assertions.assertThat(simpleUserView.getCpf()).isEqualTo(form.getCPF());
        Assertions.assertThat(simpleUserView.getEmail()).isEqualTo(form.getEmail());
    }
}