package dev.dheeraj.splitwise.commands;

import dev.dheeraj.splitwise.controllers.UserController;
import dev.dheeraj.splitwise.dtos.UpdateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
@RequiredArgsConstructor
public class UpdateUserCommand implements Command{

    private final UserController userController;

    @Override
    public boolean matches(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        return inputWords.size() == 4 && inputWords.get(1).equalsIgnoreCase(CommandKeywords.UPDATE_PROFILE);
    }

    @Override
    public void execute(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        String phoneNumber = inputWords.get(0);
        String oldPassword = inputWords.get(2);
        String newPassword = inputWords.get(3);

        UpdateUserRequestDTO requestDTO = new UpdateUserRequestDTO();
        requestDTO.setPhoneNumber(Long.parseLong(phoneNumber));
        requestDTO.setOldPassword(oldPassword);
        requestDTO.setNewPassword(newPassword);

        userController.updateUser(requestDTO);

    }
}
