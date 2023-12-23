package com.mms.geradordeaposta.userlottery.controllers;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.geradordeaposta.userlottery.dto.AuthUserDTO;
import com.mms.geradordeaposta.userlottery.service.AuthUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class AuthUserControllers {

  @Autowired
  private AuthUserService authUserService;

  @PostMapping("/auth")
  public String create(@Valid @RequestBody AuthUserDTO authUserDTO) throws AuthenticationException {
    return this.authUserService.execute(authUserDTO);
  }
}
