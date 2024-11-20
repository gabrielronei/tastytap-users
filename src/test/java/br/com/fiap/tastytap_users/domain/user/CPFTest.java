package br.com.fiap.tastytap_users.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CPFTest {


    @ParameterizedTest
    @CsvSource({"220.575.250-23, 22057525023", "22057525023, 22057525023"})
    void getCpf__shouldReturnCPFCorrectly(String expectedOriginal, String expectedWithouPonctuation) {
        CPF cpf = new CPF(expectedOriginal);

        Assertions.assertThat(cpf.getCPF()).isEqualTo(expectedOriginal);
        Assertions.assertThat(cpf.getCPFWithoutPonctuation()).isEqualTo(expectedWithouPonctuation);
    }

}