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

    public Map<Integer, String> putUserAccountMoney(Long userId, BigDecimal pUserMoney){
        return userActionsRepository.putUserMoney(userId, pUserMoney);
    }

    public Map<Integer, String> takeMoney(Long userId, BigDecimal tMoney){
        return userActionsRepository.takeMoney(userId, tMoney);
    }

    public Map<Integer, String> transferMoney(Long sendUserId, Long recipUserId, BigDecimal tMoney){
        return userActionsRepository.transferMoney(sendUserId, recipUserId, tMoney);
    }

}
