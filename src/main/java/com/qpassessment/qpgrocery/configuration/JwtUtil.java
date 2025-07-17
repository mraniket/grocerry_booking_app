package com.qpassessment.qpgrocery.configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private static String secretkey="ahskj+oiuhetTHajaYghseyYhepwT--=+wjhebBhnah(akhsj";
	
	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(secretkey.getBytes());
	}
	
	public String generateToke(String username) {
		Map<String, Object> claims = new HashMap();
		String jwtToken = createToken(claims, username);
		return jwtToken;
		
	}

	private String createToken(Map<String, Object> claims, String username) {
		return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3))
                .signWith(getSecretKey()).compact();
	}

}
