package com.rsomyk.library.security.util;

import com.rsomyk.library.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    @Value("${api.token.secret}")
    private String secret;

    @Value("${api.token.expired}")
    private Long expiredTime;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = (String) claims.get("username");
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDetails.getUsername());
        claims.put("createdAt", new Date());
        return generateToken(claims);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        final String username = getUsernameFromToken(token);
        final Date createdAt = getExpirationDate(token);
        boolean expired = false;
        Date now = new Date();
        if ((now.getTime() - createdAt.getTime()) < expiredTime) {
            expired = true;
        }
        return (username.equals(user.getUsername()) && expired);
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date getExpirationDate(String token) {
        Date createdAt;
        try {
            final Claims claims = getClaimsFromToken(token);
            createdAt = new Date((Long) claims.get("createdAt"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Don`t get createdAt");
        }
        return createdAt;
    }
}
