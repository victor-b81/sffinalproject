package org.sf.finalproject;
import org.sf.finalproject.tools.dbTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


@EnableScheduling
@SpringBootApplication
public class AtmApi {
    public static void main(String[] args) {

        try {
            dbTools.test_db_connection("atmapi_db", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        SpringApplication.run(AtmApi.class, args);
    }
}
