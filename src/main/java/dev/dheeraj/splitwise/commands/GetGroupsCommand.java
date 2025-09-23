package dev.dheeraj.splitwise.commands;

import dev.dheeraj.splitwise.controller.GroupController;
import dev.dheeraj.splitwise.dto.GetGroupByUserRequestDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//u1 Groups
@Component
//@RequiredArgsConstructor
@NoArgsConstructor
public class GetGroupsCommand implements Command{

    private  GroupController groupController;

    @Autowired
    public GetGroupsCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean matches(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        return inputWords.size() == 2 && inputWords.getLast().equalsIgnoreCase(CommandKeywords.GET_GROUPS);
    }

    @Override
    public void execute(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        String userId = inputWords.getFirst();

        GetGroupByUserRequestDTO requestDTO = new GetGroupByUserRequestDTO();
        requestDTO.setUserId(Long.parseLong(userId));

        groupController.getGroupsByUserId(requestDTO);

    }
}
