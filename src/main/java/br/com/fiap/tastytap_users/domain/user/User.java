package br.com.fiap.tastytap_users.domain.user;

import br.com.fiap.tastytap_users.utils.ValidationUtils;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String email;
    private CPF cpf;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Role role = Role.REGULAR;

    public User(String name, String email, String cpf) {
        ValidationUtils.notBlank(name, "Name cannot be blank");
        ValidationUtils.notBlank(email, "Email cannot be blank");
        ValidationUtils.notBlank(cpf, "CPF cannot be blank");

        this.name = name;
        this.email = email;
        this.cpf = new CPF(cpf);
    }

    public User(Long id, String name, String email, String cpf, LocalDateTime createdAt, Role role) {
        this(name, email, cpf);
        ValidationUtils.notNull(id, "Id cannot be null");
        ValidationUtils.notNull(createdAt, "CreatedAt cannot be null");
        ValidationUtils.notNull(role, "Role cannot be null");

        this.id = id;
        this.createdAt = createdAt;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf.getCPFWithoutPonctuation();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(cpf, user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, cpf, createdAt, role);
    }
}
