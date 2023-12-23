package com.mms.geradordeaposta.userlottery.entity;

import java.time.LocalDateTime;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [useName] não deve conter espaço")
  private String username;

  @Length(min = 10, max = 100)
  private String password;

  @Email(message = "O campo (email) deve conter um e-mail valido")
  private String email;

  private String name;

  @Pattern(regexp = "^[0-9]*$", message = "O CPF deve conter apenas números")
  @Length(min = 11, max = 11)
  private String cpf;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
