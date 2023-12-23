package com.mms.geradordeaposta.userlottery.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.geradordeaposta.userlottery.entity.User;



public interface UseRepository  extends JpaRepository<User,UUID>{
  
  Optional<User> findByUsernameOrEmail(String username, String email);

  Optional<User>  findByUsername(String username);



}
