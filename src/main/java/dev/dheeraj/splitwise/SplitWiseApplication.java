package dev.dheeraj.splitwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SplitWiseApplication {

    public static void main(String[] args) {
        // Force JVM timezone before Spring Boot starts
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(SplitWiseApplication.class, args);
    }

}
