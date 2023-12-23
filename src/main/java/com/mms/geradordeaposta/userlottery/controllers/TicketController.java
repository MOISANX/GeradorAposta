package com.mms.geradordeaposta.userlottery.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.geradordeaposta.userlottery.dto.CreateTicketDTO;
import com.mms.geradordeaposta.userlottery.entity.Ticket;
import com.mms.geradordeaposta.userlottery.service.TicketService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/luck/tickets")
public class TicketController {

  @Autowired
  private TicketService ticketService;

  @PostMapping("/create/15numbers")
  @SecurityRequirement(name = "jwt_auth")
  public Ticket createTicket15Numbers(@Valid @RequestBody CreateTicketDTO createTicketDTO,
      HttpServletRequest request) {

    var userId = request.getAttribute("user_id");
    

    var ticket = Ticket.builder()
        .numbers(createTicketDTO.getNumbers())
        .userId(UUID.fromString(userId.toString())).build();

    Ticket newTicket = ticketService.createTicket(ticket.getNumbers(), 15, ticket.getUserId());
    return newTicket;

  }

  @PostMapping("/create/07numbers")
  @SecurityRequirement(name = "jwt_auth")
  public Ticket createTicket07Numbers(@RequestBody CreateTicketDTO createTicketDTO, HttpServletRequest request) {

    var userId = request.getAttribute("user_id");
    

    var ticket = Ticket.builder()
        .numbers(createTicketDTO.getNumbers())
        .userId(UUID.fromString(userId.toString())).build();

    Ticket newTicket = ticketService.createTicket(ticket.getNumbers(), 7, ticket.getUserId());
    return newTicket;

  }

}
