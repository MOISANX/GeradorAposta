package com.mms.geradordeaposta.userlottery.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private int[] numbers;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne()
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;

  @Column(name = "user_id")
  private UUID userId;

}
