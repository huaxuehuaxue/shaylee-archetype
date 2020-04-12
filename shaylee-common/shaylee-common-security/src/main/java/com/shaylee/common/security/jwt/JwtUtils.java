package com.shaylee.common.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Jwt工具类
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-03-01
 */
@Slf4j
@Component
public class JwtUtils {
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 生成jwt token
     */
    public String generateToken(Long userId) {
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setSubject(String.valueOf(userId))
            .setIssuedAt(new Date())
            .setExpiration(DateTime.now().plusSeconds(jwtProperties.getExpire()).toDate())
            .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
            .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
        }catch (Exception e){
            log.debug("validate is token error, token = " + token, e);
            return null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}