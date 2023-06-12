package org.sf.finalproject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@EnableJpaAuditing
public class AtmApi {
    public static void main(String[] args) {
        SpringApplication.run(AtmApi.class, args);
    }
}
