package com.mms.geradordeaposta.userlottery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDTO {
  
  private String username;
  private  String password;
}
