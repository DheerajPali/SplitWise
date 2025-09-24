package dev.dheeraj.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@NoArgsConstructor
public class CommandRegistry {
    private List<Command> commands;
    private RegisterUserCommand registerUserCommand;
    private UpdateUserCommand updateUserCommand;
    private CreateGroupCommand createGroupCommand;
    private GetGroupsCommand getGroupsCommand;
    private AddMemberToGroupCommand addMemberToGroupCommand;

    public CommandRegistry(UpdateUserCommand updateUserCommand, RegisterUserCommand registerUserCommand, CreateGroupCommand createGroupCommand, GetGroupsCommand getGroupsCommand, AddMemberToGroupCommand addMemberToGroupCommand) {
        this.commands = new ArrayList<>();
        commands.add(updateUserCommand);
        commands.add(registerUserCommand);
        commands.add(createGroupCommand);
        commands.add(getGroupsCommand);
        commands.add(addMemberToGroupCommand);
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
