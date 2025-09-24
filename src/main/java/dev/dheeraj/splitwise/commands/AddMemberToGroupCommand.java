package dev.dheeraj.splitwise.commands;

import dev.dheeraj.splitwise.controllers.GroupController;
import dev.dheeraj.splitwise.dtos.AddMemberToGroupRequestDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//u1 AddMember g1 u2
@Component
//@RequiredArgsConstructor
@NoArgsConstructor
//@AllArgsConstructor
public class AddMemberToGroupCommand implements Command{

    private GroupController groupController;

    @Autowired
    public AddMemberToGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean matches(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        return inputWords.size() == 4 && inputWords.get(1).equalsIgnoreCase(CommandKeywords.ADD_MEMBER_TO_GROUP);
    }

    @Override
    public void execute(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        String userId = inputWords.getFirst();
        String groupId = inputWords.get(2);
        String newMemberPhone = inputWords.getLast();

        AddMemberToGroupRequestDTO requestDTO = new AddMemberToGroupRequestDTO();
        requestDTO.setGroupId(Long.parseLong(groupId));
        requestDTO.setNewMemberPhoneNumber(Long.parseLong(newMemberPhone));
        requestDTO.setUserId(Long.parseLong(userId));

        groupController.addMemberToGroup(requestDTO);
    }
}
