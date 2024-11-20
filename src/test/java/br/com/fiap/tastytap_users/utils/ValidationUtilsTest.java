package br.com.fiap.tastytap_users.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationUtilsTest {


    @ParameterizedTest
    @CsvSource({"123456789", "11111111101", "22222222202", "231"})
    void isValidCpf__shouldReturnFalseWhenCPFIsInvalid(String cpf) {
        Assertions.assertThat(ValidationUtils.isValidCpf(cpf)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"519.708.290-95", "13834333050"})
    void isValidCpf__shouldReturnTrueWhenCPFIsValid(String cpf) {
        Assertions.assertThat(ValidationUtils.isValidCpf(cpf)).isTrue();
    }
}