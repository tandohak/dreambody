package com.dreambody.security;

import com.dreambody.config.AppProperties;
import com.dreambody.security.oauth2.user.UserPrincipal;
import com.dreambody.util.AES256Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@Service
public class TokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    private AppProperties appProperties;

    public TokenProvider(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        HashMap<String, Object> claims = new HashMap<>();

        try {
            AES256Util aes256Util = new AES256Util(appProperties.getAuth().getPayloadSecret());
            log.warn("userPrincipal {}", aes256Util.encrypt(userPrincipal.getId().toString()));
            claims.put("user_id", aes256Util.encrypt(userPrincipal.getId().toString()));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return Jwts.builder()
                .setClaims(claims)
                .setSubject("access_token")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }


    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();
        try {
            AES256Util aes256Util = new AES256Util(appProperties.getAuth().getPayloadSecret());
            return Long.parseLong(aes256Util.decrypt(claims.get("user_id").toString()));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
