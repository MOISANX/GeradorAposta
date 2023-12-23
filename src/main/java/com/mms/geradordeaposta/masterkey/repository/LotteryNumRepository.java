package com.mms.geradordeaposta.masterkey.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.geradordeaposta.masterkey.entity.LotteryNumbersResponse;

public interface LotteryNumRepository extends JpaRepository<LotteryNumbersResponse, UUID> {

 

}
