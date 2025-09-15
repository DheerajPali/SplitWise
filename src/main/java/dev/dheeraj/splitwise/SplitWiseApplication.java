package dev.dheeraj.splitwise;

import dev.dheeraj.splitwise.commands.CommandKeywords;
import dev.dheeraj.splitwise.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.TimeZone;

//if we want something to do with commandline, we've to implement CommandLIneRunner.
@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {
    private Scanner scanner;
    private CommandRegistry commandRegistry;

    @Autowired
    public SplitWiseApplication(CommandRegistry commandRegistry){
        this.scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Please enter commands to execute");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
        }
    }

    public static void main(String[] args) {
        // Force JVM timezone before Spring Boot starts
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(SplitWiseApplication.class, args);
    }

}
