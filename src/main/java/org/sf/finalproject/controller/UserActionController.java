package org.sf.finalproject.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.sf.finalproject.service.userActionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class UserActionController {
    private final userActionService userActionService;
    @GetMapping("/getBalance")
    @ApiOperation(value = "Получить баланс")
    public Map<BigDecimal, String> getBalance(@RequestParam(value = "getUserIdParam") Long gUserId){
        return userActionService.getUserBalanceService(gUserId);
    }

    @PostMapping("/putMoneу")
    @ApiOperation(value = "Положить деньги на счет")
    public Map<Integer, String> putMoney(@RequestParam(value = "getUserIdParam") Long gUserId, @RequestParam(value = "putMoneyParam") BigDecimal pMoney){
        return userActionService.putUserAccountMoney(gUserId, pMoney);
    }

    @PostMapping("/takeMoney")
    @ApiOperation(value = "Снять деньги со счета")
    public Map<Integer, String> takeMoney(@RequestParam(value = "tUserId") Long tUserId, @RequestParam(value = "tMoney") BigDecimal tMoney){
        return userActionService.takeMoney(tUserId, tMoney);
    }

    @PostMapping("/transferMoney")
    @ApiOperation(value = "Перевести деньги на счет")
    public Map<Integer, String> transferMoney(@RequestParam(value = "sendUserId") Long sendUserId, @RequestParam(value = "recipUserId") Long recipUserId, @RequestParam(value = "tMoney") BigDecimal tMoney){
        return userActionService.transferMoney(sendUserId, recipUserId, tMoney);
    }
}
