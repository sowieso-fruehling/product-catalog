package de.br.aff.security;

import lombok.Getter;

@Getter
public class JwtResponse {

  private String jwttoken;

  public JwtResponse(String jwttoken) {
    this.jwttoken = "Bearer " + jwttoken;
  }
}
