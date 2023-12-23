package com.mms.geradordeaposta.masterkey.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.geradordeaposta.masterkey.entity.LotteryNumbersResponse;
import com.mms.geradordeaposta.masterkey.repository.LotteryNumRepository;

@Service
public class LotteryNumService {
  @Autowired
  private LotteryNumRepository lotteryNumRepository;

  public LotteryNumbersResponse generateAndSaveNumbers(int quantity) {
    List<Integer> selectedNumbers = generateRandomNumbers(quantity);
    LotteryNumbersResponse lotteryNumbersResponse = new LotteryNumbersResponse();
    lotteryNumbersResponse.setId(UUID.randomUUID());
    lotteryNumbersResponse.setNumbers(selectedNumbers);
    lotteryNumbersResponse.setCreatedAt(LocalDateTime.now());

    return lotteryNumRepository.save(lotteryNumbersResponse);
  }

  private List<Integer> generateRandomNumbers(int quantity) {
    List<Integer> numbers = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < quantity; i++) {
      int randomNumber = random.nextInt(99) + 1;
      numbers.add(randomNumber);
    }

    return numbers;
  }

  public List<LotteryNumbersResponse> getAllLotteryNumbers() {
    List<LotteryNumbersResponse> allNumbers = lotteryNumRepository.findAll();

    return allNumbers;
  }
}
