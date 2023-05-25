package org.sf.finalproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Repository
@RequiredArgsConstructor
public class userActionsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Map<BigDecimal, String> getUserBalance (Long userId){
        Map<String, Long> parameters = new HashMap<>();
        Map<BigDecimal, String> returnUserBalance = new HashMap<>();
        parameters.put("userId", userId);
        try {
            returnUserBalance.put((namedParameterJdbcTemplate.queryForObject("SELECT USER_BALANCE FROM Table_Money WHERE user_id = :userId", parameters, new StatsRowMapper())), "All OK");
            return returnUserBalance;
        }catch (Exception e){
            returnUserBalance.put(BigDecimal.valueOf(-1), "Ошибка идентификатора пользователя c ID "+ userId +": "+e);
            return returnUserBalance;
        }
    }
    private static final class StatsRowMapper implements RowMapper<BigDecimal> {
        @Override
        public BigDecimal mapRow(ResultSet resultset, int i) throws SQLException {
            return BigDecimal.valueOf(resultset.getInt("USER_BALANCE"));
        }
    }

    public Map<Integer, String> putUserMoney(Long userId, BigDecimal pUserMoney){
        Map<Integer, String> pResult = new HashMap<>();
        Map<BigDecimal, String> pUserCheck = getUserBalance(userId);
        if (pUserCheck.containsKey(BigDecimal.valueOf(-1))){
            String erroreValue = null;
            for (String value : pUserCheck.values()) {
                erroreValue = value;
            }
            pResult.put(0, erroreValue);
        } else {
            BigDecimal pUserBalance = null;
            for (BigDecimal key : pUserCheck.keySet()) {
                pUserBalance = key;
            }
            Map<String, BigDecimal> putParameters = new HashMap<>();
            putParameters.put("userId", BigDecimal.valueOf(userId));
            putParameters.put("userBalance", pUserBalance.add(pUserMoney));
            try {
                namedParameterJdbcTemplate.update("UPDATE Table_Money SET USER_BALANCE = :userBalance WHERE user_id = :userId", putParameters);
                pResult.put(1, "ALL OK");
            }catch (Exception e){
                pResult.put(0, String.valueOf(e));
            }
        }
        return pResult;
    }

    public Map<Integer, String> takeMoney(Long userId, BigDecimal tMoney){
        BigDecimal withdrawMoney = null;
        Map<Integer, String> tResult = new HashMap<>();
        Map<BigDecimal, String> tUserCheck = getUserBalance(userId);
        if (tUserCheck.containsKey(BigDecimal.valueOf(-1))){
            String erroreValue = null;
            for (String value : tUserCheck.values()) {
                erroreValue = value;
            }
            tResult.put(0, erroreValue);
        } else {
            BigDecimal tUserBalance = null;
            for (BigDecimal key : tUserCheck.keySet()) {
                tUserBalance = key;
            }
            withdrawMoney = tUserBalance.subtract(tMoney);
            if (withdrawMoney.compareTo(BigDecimal.ZERO) <=0){
                tResult.put(0, "Недостаточно средств на счету.");
            }else {
                Map<String, BigDecimal> putParameters = new HashMap<>();
                putParameters.put("sendUserId", BigDecimal.valueOf(userId));
                putParameters.put("withdrawMoney", withdrawMoney);
                try {
                    namedParameterJdbcTemplate.update("UPDATE Table_Money SET USER_BALANCE = :withdrawMoney WHERE user_id = :sendUserId", putParameters);
                    tResult.put(1, "ALL OK");
                }catch (Exception e){
                    tResult.put(0, String.valueOf(e));
                }
            }
        }
        return tResult;
    }

    public Map<Integer, String> transferMoney(Long senderUserId, Long recipentUserId, BigDecimal transMoney){
        Map<Integer, String> tResult = new HashMap<>();
        Map<BigDecimal, String> tSenderCheck = getUserBalance(senderUserId);
        Map<BigDecimal, String> tRecipentCheck = getUserBalance(recipentUserId);
        if (tSenderCheck.containsKey(BigDecimal.valueOf(-1))){
            String erroreValue = null;
            for (String value : tSenderCheck.values()) {
                erroreValue = value;
            }
            tResult.put(0, erroreValue);
        } else if (tRecipentCheck.containsKey(BigDecimal.valueOf(-1))){
            String erroreValue = null;
            for (String value : tRecipentCheck.values()) {
                erroreValue = value;
            }
            tResult.put(0, erroreValue);
        } else {
            Map<Integer, String> takeOperation = takeMoney(senderUserId, transMoney);
            if (takeOperation.containsValue("ALL OK")){
                Map<Integer, String> putOperation = putUserMoney(recipentUserId, transMoney);
                if (putOperation.containsValue("ALL OK")){
                    tResult.put(1, "ALL OK");
                } else {
                    String erroreValue = null;
                    for (String value : putOperation.values()) {
                        erroreValue = value;
                    }
                    tResult.put(0, erroreValue);
                }
            } else {
                String erroreValue = null;
                for (String value : takeOperation.values()) {
                    erroreValue = value;
                }
                tResult.put(0, erroreValue);
            }
        }
        return tResult;
    }
}
