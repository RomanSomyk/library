package com.rsomyk.library.security.util;

import com.rsomyk.library.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtils.class);
    private static final String CLAIM_KEY_USERNAME = "username";
    private static final String CLAIM_KEY_CREATED = "createdAt";

    @Value("${api.token.secret}")
    private String secret;

    @Value("${api.token.expired}")
    private Long expiredTime;

    public String getUsernameFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            if (claims != null) {
                return  (String) claims.get(CLAIM_KEY_USERNAME);
            }
        } catch (NullPointerException | ClassCastException e) {
            LOGGER.debug("ClassCastException");
        }
        return null;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        final String username = getUsernameFromToken(token);
        final Date createdAt = getExpirationDate(token);

        if (createdAt != null) {
            boolean expired = (System.currentTimeMillis() - createdAt.getTime()) < expiredTime;
            return (username.equals(user.getUsername()) && expired);
        }

        return false;
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

        final Claims claims = getClaimsFromToken(token);

        if (claims != null) {
            return (Date) claims.get(CLAIM_KEY_CREATED);
        }
        return null;
    }
}
