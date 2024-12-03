package br.com.fiap.tastytap_users.infraestructure.user;

import br.com.fiap.tastytap_users.applications.user.create.CreateUserUseCase;
import br.com.fiap.tastytap_users.applications.user.create.DefaultCreateUserUseCase;
import br.com.fiap.tastytap_users.applications.user.retrieve.DefaultFindUserUseCase;
import br.com.fiap.tastytap_users.applications.user.retrieve.FindUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfiguration {

    private final DefaultUserGateway defaultUserGateway;


    public UserUseCaseConfiguration(DefaultUserGateway defaultUserGateway) {
        this.defaultUserGateway = defaultUserGateway;
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new DefaultCreateUserUseCase(this.defaultUserGateway);
    }

    @Bean
    public FindUserUseCase findUserUseCase() {
        return new DefaultFindUserUseCase(this.defaultUserGateway);
    }

}
