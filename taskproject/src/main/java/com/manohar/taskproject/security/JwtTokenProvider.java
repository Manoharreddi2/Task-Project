package com.manohar.taskproject.security;

import com.manohar.taskproject.exception.APIException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final SecretKey KEY =
            Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(Authentication authentication) {

        String email = authentication.getName();
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(KEY)
                .compact();
    }

    public String getEmailFromToken(String token) {

        Claims claims = Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(KEY)      // ✅ SAME KEY
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            throw new APIException("Token Issue: " + e.getMessage());
        }
    }




}
