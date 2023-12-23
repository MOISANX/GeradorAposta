package com.mms.geradordeaposta.masterkey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mms.geradordeaposta.masterkey.entity.LotteryNumbersResponse;
import com.mms.geradordeaposta.masterkey.service.LotteryNumService;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
  @Autowired
  private LotteryNumService lotteryNumService;

  @PostMapping("/")
  public ResponseEntity<LotteryNumbersResponse> generateNumbersAndSave(
      @RequestParam(name = "quantity", defaultValue = "15") int quantity) {

    if (quantity < 1 || quantity > 99) {

      return ResponseEntity.badRequest().build();
    }

    LotteryNumbersResponse response = lotteryNumService.generateAndSaveNumbers(quantity);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/")
  public ResponseEntity<List<LotteryNumbersResponse>> getAllLotteryNumbers() {
    List<LotteryNumbersResponse> allNumbers = lotteryNumService.getAllLotteryNumbers();
    if (allNumbers.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return new ResponseEntity<>(allNumbers, HttpStatus.OK);
  }

}
