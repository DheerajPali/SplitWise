package dev.dheeraj.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    private List<Command> commands;
    private RegisterUserCommand registerUserCommand;
    private UpdateUserCommand updateUserCommand;

    public CommandRegistry(RegisterUserCommand registerUserCommand, UpdateUserCommand updateUserCommand){
        this.commands = new ArrayList<>();
        commands.add(registerUserCommand);
        commands.add(updateUserCommand);
    }

    public void execute(String input){
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
