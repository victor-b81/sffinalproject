package org.sf.finalproject.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.sf.finalproject.entity.TableHistoryOperation;
import org.sf.finalproject.repository.HistoryOperationRepository;
import org.sf.finalproject.service.userActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserActionController {
    private final userActionService userActionService;
    @Autowired
    HistoryOperationRepository historyOperationRepository;
    @GetMapping("/getBalance")
    @ApiOperation(value = "Получить баланс")
    public Map<BigDecimal, String> getBalance(@RequestParam(value = "getUserIdParam") Long gUserId){
        return userActionService.getUserBalanceService(gUserId);
    }

    @GetMapping("/getOperationList")
    @ApiOperation(value = "Получить историю операций")
    public ResponseEntity<List<TableHistoryOperation>> getOperationList(@RequestParam(value = "userId") String userId,
                                                                        @RequestParam(value = "dateBegin", defaultValue = "0001-01-01") Date dataStart,
                                                                        @RequestParam(value = "dateEnd", defaultValue = "#{T(java.time.LocalDate).now()}") Date dataEnd){
    return new ResponseEntity<>(historyOperationRepository.getAllBetweenDates(userId, dataStart, dataEnd), HttpStatus.FOUND);
    }



    @PostMapping("/putMoneу")
    @ApiOperation(value = "Положить деньги на счет")
    public Map<Integer, String> putMoney(@RequestParam(value = "getUserIdParam") Long gUserId, @RequestParam(value = "putMoneyParam") BigDecimal pMoney){
        return userActionService.putUserAccountMoneyService(gUserId, pMoney);
    }

    @PostMapping("/takeMoney")
    @ApiOperation(value = "Снять деньги со счета")
    public Map<Integer, String> takeMoney(@RequestParam(value = "tUserId") Long tUserId, @RequestParam(value = "tMoney") BigDecimal tMoney){
        return userActionService.takeMoneyService(tUserId, tMoney);
    }

    @PostMapping("/transferMoney")
    @ApiOperation(value = "Перевести деньги на счет")
    public Map<Integer, String> transferMoney(@RequestParam(value = "sendUserId") Long sendUserId, @RequestParam(value = "recipUserId") Long recipUserId, @RequestParam(value = "tMoney") BigDecimal tMoney){
        return userActionService.transferMoneyService(sendUserId, recipUserId, tMoney);
    }
}
