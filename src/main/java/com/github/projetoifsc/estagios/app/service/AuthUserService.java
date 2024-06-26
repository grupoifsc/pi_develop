package com.github.projetoifsc.estagios.app.service;

import com.github.projetoifsc.estagios.app.security.auth.CustomUserDetails;
import com.github.projetoifsc.estagios.app.security.auth.IAuthenticationDAO;
import com.github.projetoifsc.estagios.app.security.auth.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthUserService {

    private final PasswordEncoder passwordEncoder;
    private final IAuthenticationDAO authenticationDB;

    private final String ADMIN_EMAIL = "admin@teste.com";
    private final String USER_EMAIL = "user@teste.com";

    public AuthUserService(PasswordEncoder passwordEncoder, IAuthenticationDAO authenticationDB) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationDB = authenticationDB;
    }


    public Optional<CustomUserDetails> findByUsername(String username) {
        if(username.equalsIgnoreCase(ADMIN_EMAIL) || username.equalsIgnoreCase(USER_EMAIL))
            return findMockedByEmail(username);
        return authenticationDB.findByUsername(username);
    }


    public Optional<CustomUserDetails> findMockedByEmail(String email) {
        if(email.equalsIgnoreCase(ADMIN_EMAIL)) {
            var password = passwordEncoder.encode("senha");
            var user = new UserPrincipal("1", true,ADMIN_EMAIL, password, List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
            return Optional.of(user);
        }
        var password = passwordEncoder.encode("senha");
        var user = new UserPrincipal("99", false, USER_EMAIL, password, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        return Optional.of(user);
    }


}
