package dev.dheeraj.splitwise.commands;

import dev.dheeraj.splitwise.controllers.GroupController;
import dev.dheeraj.splitwise.dtos.CreateGroupRequestDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//1 AddGroup Family
@Component
@NoArgsConstructor
public class CreateGroupCommand implements Command{

    private  GroupController groupController;

    @Autowired
    public CreateGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean matches(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        return inputWords.size() == 3 && inputWords.get(1).equalsIgnoreCase(CommandKeywords.CREATE_GROUP);
    }

    @Override
    public void execute(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        String groupName = inputWords.getLast();
        String userId = inputWords.getFirst();

        CreateGroupRequestDTO requestDTO = new CreateGroupRequestDTO();
        requestDTO.setName(groupName);
        requestDTO.setUserId(Long.parseLong(userId));

        groupController.createGroup(requestDTO);
    }
}
