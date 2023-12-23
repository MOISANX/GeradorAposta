package com.mms.geradordeaposta.userlottery.exception;

public class UserNameOrEmailAreadyIncludedException extends RuntimeException {

  public UserNameOrEmailAreadyIncludedException() {
    super("Usuario ou email ja existem");
  }

}
