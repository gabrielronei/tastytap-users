package br.com.fiap.tastytap_users.infraestructure.security;

import br.com.fiap.tastytap_users.application.user.UserGateway;
import br.com.fiap.tastytap_users.domain.user.CPF;
import br.com.fiap.tastytap_users.infraestructure.user.UserEntity;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserGateway userGateway;

    public UserDetailsServiceImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userGateway.findByCPF(new CPF(username)).map(UserEntity::new)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UserDetailsImpl(user);
    }

}