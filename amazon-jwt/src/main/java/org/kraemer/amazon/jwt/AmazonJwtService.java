package org.kraemer.amazon.jwt;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.*;

@Singleton
public class AmazonJwtService {

    public String generateJwt() {
        Set<String> roles = new HashSet<>(
                Arrays.asList("admin", "writer")
        );

        return Jwt.issuer("amazon-jwt")
                .subject("amazon-jwt")
                .groups(roles)
                .expiresAt(
                        System.currentTimeMillis() + 3600
                )
                .sign();

    }

}
