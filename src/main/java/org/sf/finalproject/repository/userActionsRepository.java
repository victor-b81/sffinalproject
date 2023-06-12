package org.sf.finalproject.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Repository
@RequiredArgsConstructor
public class userActionsRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    static String statsRowMapperParam = null;
    public Map<BigDecimal, String> getUserBalance (Long userId){
        Map<String, String> parameters = new HashMap<>();
        Map<BigDecimal, String> returnUserBalance = new HashMap<>();
        parameters.put("userId", String.valueOf(userId));
        try {
            statsRowMapperParam = "USER_BALANCE";
            returnUserBalance.put((namedParameterJdbcTemplate.queryForObject("SELECT USER_BALANCE FROM Table_Money" +
                    " WHERE user_id = :userId", parameters, new StatsRowMapper())), "ALL OK");
            return returnUserBalance;
        }catch (Exception e){
            returnUserBalance.put(BigDecimal.valueOf(-1), "Ошибка идентификатора пользователя c ID "+ userId +": "+e);
            return returnUserBalance;
        }
    }
    private static class StatsRowMapper implements RowMapper<BigDecimal>{
        @Override
        public BigDecimal mapRow(ResultSet resultset, int i) throws SQLException {
            return BigDecimal.valueOf(resultset.getInt(statsRowMapperParam));
        }
    }

    public Map<Integer, String> putUserMoney(Long userId, BigDecimal pUserMoney, String operationID, String commentTransaction){
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
            Map<String, String> putParameters = new HashMap<>();
            putParameters.put("userId", String.valueOf(userId));
            putParameters.put("userBalance", String.valueOf(pUserBalance.add(pUserMoney)));
            putParameters.put("operationID", operationID);
            putParameters.put("amountTransaction", String.valueOf(pUserMoney));
            putParameters.put("commentTransaction", commentTransaction);
            try {
                namedParameterJdbcTemplate.update("BEGIN;" +
                        " UPDATE Table_Money SET USER_BALANCE = :userBalance WHERE user_id = :userId;" +
                        " INSERT INTO TABLE_HISTORY_OPERATION (OPERATION_ID, USER_ID, TIMESTAMP, DATE, AMOUNT_TRANSACTION," +
                        " COMMENT_TRANSACTION)" +
                        " VALUES (:operationID, :userId, CURRENT_TIMESTAMP, CURRENT_Date, :amountTransaction, :commentTransaction);" +
                        " COMMIT;", putParameters);
                pResult.put(1, "ALL OK");
            }catch (Exception e){
                pResult.put(0, String.valueOf(e));
            }
        }
        return pResult;
    }

    public Map<Integer, String> takeMoney(Long userId, BigDecimal tMoney, String operationID, String commentTransaction){
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
                Map<String, String> putParameters = new HashMap<>();
                putParameters.put("userId", String.valueOf(userId));
                putParameters.put("userBalance", String.valueOf(withdrawMoney));
                putParameters.put("operationID", operationID);
                putParameters.put("amountTransaction", String.valueOf(tMoney));
                putParameters.put("commentTransaction", commentTransaction);
                try {
                    namedParameterJdbcTemplate.update("BEGIN;" +
                            " UPDATE Table_Money SET USER_BALANCE = :userBalance WHERE user_id = :userId;" +
                            " INSERT INTO TABLE_HISTORY_OPERATION (OPERATION_ID, USER_ID, TIMESTAMP, DATE, AMOUNT_TRANSACTION," +
                            " COMMENT_TRANSACTION)" +
                            " VALUES (:operationID, :userId, CURRENT_TIMESTAMP, CURRENT_Date, :amountTransaction, :commentTransaction);" +
                            " COMMIT;", putParameters);
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
            Map<Integer, String> takeOperation = takeMoney(senderUserId, transMoney, "3", "Transfer money" +
                    " to the client ID:" + recipentUserId);
            if (takeOperation.containsValue("ALL OK")){
                Map<Integer, String> putOperation = putUserMoney(recipentUserId, transMoney, "4", "Transfer money" +
                        " from the client ID:" + senderUserId);
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
