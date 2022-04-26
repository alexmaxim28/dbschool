package com.example.tema_10.util;

import com.example.tema_10.exception.JWTException;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class JWTUtil {
    private String secretKey;
    private Long jwtExpirationMs;

    public String extractUser(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)).signWith(SignatureAlgorithm.ES256,secretKey).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) throws JWTException {
        final String username = extractUser(token);
        if (!username.equals((userDetails.getUsername()))) {
            throw new JWTException(username, "token is not valid.");
        }
        if (isTokenExpired(token)) {
            throw new JWTException(username, "due to token expiration.");
        }
        if(!userDetails.isEnabled()){
            throw new JWTException(username, "the user is disabled.");
        }
        if(!userDetails.isAccountNonExpired()){
            throw new JWTException(username, "the user account is expired.");
        }
        if(!userDetails.isCredentialsNonExpired()){
            throw new JWTException(username, "the credentials are expired.");
        }
        if(!userDetails.isAccountNonLocked()){
            throw new JWTException(username, "the account is locked.");
        }
        return true;
    }
}