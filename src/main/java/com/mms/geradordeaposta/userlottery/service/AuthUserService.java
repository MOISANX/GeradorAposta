package com.mms.geradordeaposta.userlottery.service;

import java.time.Duration;
import java.time.Instant;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mms.geradordeaposta.userlottery.dto.AuthUserDTO;
import com.mms.geradordeaposta.userlottery.repository.UseRepository;

@Service
public class AuthUserService {

  @Value("${security.token.secret}")
  private String secretKey;

  @Autowired
  private UseRepository useRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public String execute(AuthUserDTO authUserDTO) throws AuthenticationException {

    var user = this.useRepository.findByUsername(authUserDTO.getUsername()).orElseThrow(() -> {
      throw new UsernameNotFoundException("User not found");
    });

    var passwordMatches = this.passwordEncoder.matches(authUserDTO.getPassword(), user.getPassword());

    if (!passwordMatches) {
      throw new AuthenticationException();
    }

    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    var token = JWT.create().withIssuer("jaLote")
        .withExpiresAt(Instant.now().plus(Duration.ofHours(1)))
        .withSubject(user.getId().toString()).sign(algorithm);

    return token;
  }
}
