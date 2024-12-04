package br.com.fiap.tastytap_users.bdd;

import br.com.fiap.tastytap_users.domain.user.User;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

public class CreateUserCucumberTest {

    private String name;
    private String email;
    private String cpf;

    private User user;

    @Given("A newUserRequest with name = {string}, email = {string} and cpf = {string}")
    public void aNewUserRequestWithNameEmailAndCpf(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    @When("create the object")
    public void createTheObject() {
        this.user = new User(name, email, cpf);
    }

    @Then("should create the user correctly")
    public void shouldCreateTheUserCorrectly() {
        Assertions.assertNotNull(this.user);
    }

    @Then("should throw an exception")
    public void shouldThrowAnException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(name, email, cpf));
    }
}

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features")
class CreateUserRunnerTest {
}
