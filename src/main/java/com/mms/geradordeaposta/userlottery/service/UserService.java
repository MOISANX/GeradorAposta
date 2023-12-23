package com.mms.geradordeaposta.userlottery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mms.geradordeaposta.userlottery.entity.User;
import com.mms.geradordeaposta.userlottery.exception.UserNameOrEmailAreadyIncludedException;
import com.mms.geradordeaposta.userlottery.repository.UseRepository;

@Service
public class UserService {

  @Autowired
  private UseRepository useRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User createUser(User user) {

    this.useRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail()).ifPresent((u) -> {

      throw new UserNameOrEmailAreadyIncludedException();
    });

    var password = passwordEncoder.encode(user.getPassword());
    user.setPassword(password);

    return this.useRepository.save(user);
  }
}
