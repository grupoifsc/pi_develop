package com.github.projetoifsc.estagios.app.security.auth;

import com.github.projetoifsc.estagios.app.service.AuthUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private final AuthUserService authUserService;

    public CustomUserDetailService(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = authUserService.findByUsername(username).orElseThrow();
        return new UserPrincipal(
                user.getId(),
                user.getIe(),
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }


}
