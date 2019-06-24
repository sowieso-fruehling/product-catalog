package de.br.aff.catalogservice.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil implements Serializable {

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.tokenValidity}")
  private long tokenValidity;

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + tokenValidity))
        .signWith(SignatureAlgorithm.HS512, secret).compact();
  }

  Optional<String> getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  boolean isTokenExpired(String token) {
    final Optional<Date> expiration = getExpirationDateFromToken(token);
    return expiration.filter(date -> date.before(new Date())).isPresent();
  }

  private Optional<Date> getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  private <T> Optional<T> getClaimFromToken(String token, Function<Claims, T> claimsResolver) {

    try {
      return Optional.of(claimsResolver
          .apply(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()));
    } catch (final MalformedJwtException | UnsupportedJwtException | SignatureException | ExpiredJwtException | IllegalArgumentException e) {
      return Optional.empty();
    }
  }
}