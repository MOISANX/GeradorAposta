package com.mms.geradordeaposta.userlottery.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.geradordeaposta.userlottery.entity.Ticket;
import com.mms.geradordeaposta.userlottery.repository.TicketRepository;

@Service
public class TicketService {

  @Autowired
  private TicketRepository ticketRepository;

  public Ticket createTicket(int[] numbers, int numberOfNumbers, UUID userId) {

    if (numbers.length > numberOfNumbers) {

      throw new IllegalArgumentException("Os numeros selecionados excederam a quantidade de " + numberOfNumbers);
    } else if (numbers.length < numberOfNumbers) {

      throw new IllegalArgumentException("Os numeros selecionados é menor que a quantidade de " + numberOfNumbers);
    }

    Ticket ticket = new Ticket();
    ticket.setUserId(userId);
    ticket.setNumbers(numbers);
    return ticketRepository.save(ticket);

  }

}
