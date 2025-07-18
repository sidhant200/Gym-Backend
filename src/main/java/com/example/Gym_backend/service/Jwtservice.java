package com.example.Gym_backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component

public class Jwtservice {
    private final String secretKey = "mySecretKeymySecretKey12345678912";
    /*Jwts.builder() → starts creating a token.

      .setSubject(username) → puts the username inside the token.

       .setIssuedAt(new Date()) → sets the created time.

.setExpiration(...) → sets expiry time = now + 1 hour.

.signWith(...) → signs it using the secret key and HS256 algorithm.

.compact() → builds and returns the token (as a String).

 */

    public String generateToken(String username) {

        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000))
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()) ,  SignatureAlgorithm.HS256)
                .compact();

    }

    /*Uses the same secret key to verify the token.

Parses the token and reads the body (called claims).

.getSubject() → returns the username from the token.

     */

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token){
        return extractUsername(token).equals(token);
    }
}
