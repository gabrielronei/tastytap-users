package br.com.fiap.tastytap_users.application;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN in);
}
