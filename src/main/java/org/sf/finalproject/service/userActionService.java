package org.sf.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.sf.finalproject.repository.userActionsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class userActionService {
    private final userActionsRepository userActionsRepository;
    public Map<BigDecimal, String> getUserBalanceService(Long userId){
        return userActionsRepository.getUserBalance(userId);
    }

    public Map<Integer, String> putUserAccountMoneyService(Long userId, BigDecimal pUserMoney){
        return userActionsRepository.putUserMoney(userId, pUserMoney, "1", "Client put the money");
    }

    public Map<Integer, String> takeMoneyService(Long userId, BigDecimal tMoney){
        return userActionsRepository.takeMoney(userId, tMoney, "2", "Client take the money");
    }

    public Map<Integer, String> transferMoneyService(Long sendUserId, Long recipUserId, BigDecimal tMoney){
        return userActionsRepository.transferMoney(sendUserId, recipUserId, tMoney);
    }

}
