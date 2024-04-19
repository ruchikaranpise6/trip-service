/*
package com.girly.schtick.api.gateway.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
@Component
public class JWTValidatorUtil {

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode("703373367638792F423F4528482B4D6251655468576D5A7134743777217A2443");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        return false;
    }
}
*/
