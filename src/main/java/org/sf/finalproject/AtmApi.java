package org.sf.finalproject;
import org.sf.finalproject.tools.dbTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.SQLException;


@EnableScheduling
@SpringBootApplication
public class AtmApi {
    public static void main(String[] args) {
        SpringApplication.run(AtmApi.class, args);
    }
}
