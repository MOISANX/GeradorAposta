package com.mms.geradordeaposta.userlottery.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.geradordeaposta.userlottery.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

}
