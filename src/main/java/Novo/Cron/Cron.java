package Novo.Cron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Cron {

    public static void main(String[] args) {
        SpringApplication.run(Cron.class);
    }
}