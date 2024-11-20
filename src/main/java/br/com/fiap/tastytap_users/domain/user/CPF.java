package br.com.fiap.tastytap_users.domain.user;

import java.util.Objects;

public class CPF {

    private final String cpf;

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public String getCPF() {
        return cpf;
    }

    public String getCPFWithoutPonctuation() {
        return cpf.replaceAll("\\D", "");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf1 = (CPF) o;
        return Objects.equals(cpf, cpf1.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
