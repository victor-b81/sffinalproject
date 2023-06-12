package org.sf.finalproject.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sf.finalproject.entity.TableHistoryOperation;
import org.sf.finalproject.repository.HistoryOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserActionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS TABLE_MONEY;" +
                "DROP TABLE IF EXISTS TABLE_HISTORY_OPERATION;");
        jdbcTemplate.execute("CREATE TABLE if not exists table_money(" +
                "id serial NOT NULL, user_balance character varying(255)," +
                " user_id character varying(255) UNIQUE);" +
                "CREATE TABLE if not exists table_history_operation (" +
                "id serial NOT NULL," +
                "amount_transaction character varying(255)," +
                "comment_transaction character varying(255)," +
                "operation_id character varying(255)," +
                "date date," +
                "\"timestamp\" timestamp without time zone," +
                "user_id character varying(255));");
        jdbcTemplate.execute("INSERT INTO Table_Money (USER_BALANCE, USER_ID) VALUES (1200, 2);" +
                "INSERT INTO Table_Money (USER_BALANCE, USER_ID) VALUES (1100, 1);");
    }

    @Test
    void getBalance() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/getBalance?getUserIdParam=1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1100\":\"ALL OK\"}")));
            this.mockMvc.perform(MockMvcRequestBuilders.get("/getBalance?getUserIdParam=2"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1200\":\"ALL OK\"}")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void putMoney() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/putMoneу?getUserIdParam=1&putMoneyParam=50"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1\":\"ALL OK\"}")));
            this.mockMvc.perform(MockMvcRequestBuilders.post("/putMoneу?getUserIdParam=2&putMoneyParam=70"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1\":\"ALL OK\"}")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void takeMoney() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/takeMoney?tUserId=1&tMoney=40"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1\":\"ALL OK\"}")));
            this.mockMvc.perform(MockMvcRequestBuilders.post("/takeMoney?tUserId=2&tMoney=60"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1\":\"ALL OK\"}")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void transferMoney() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.post("/transferMoney?sendUserId=1&recipUserId=2&tMoney=10"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\"1\":\"ALL OK\"}")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}