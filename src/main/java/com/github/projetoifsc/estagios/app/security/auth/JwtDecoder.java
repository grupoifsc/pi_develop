package com.github.projetoifsc.estagios.app.security.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtDecoder {

    private final JwtProperties jwtProperties;

    public JwtDecoder(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public DecodedJWT decodeAccessToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getAccessTokenSecretKey()))
                .withClaimPresence("sub")
                .withClaimPresence("a")
                .build()
                .verify(token);
    }

    public DecodedJWT decodeRefreshToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getRefreshTokenSecretKey()))
                .withClaimPresence("sub")
                .withClaimPresence("a")
                .build()
                .verify(token);
    }

}
