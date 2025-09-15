package dev.dheeraj.splitwise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.TimeZone;

//if we want something to do with commandline, we've to implement CommandLIneRunner.
@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {
    private Scanner scanner;

    public SplitWiseApplication(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Please enter commands to execute");
            String input = scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        // Force JVM timezone before Spring Boot starts
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(SplitWiseApplication.class, args);
    }

}
