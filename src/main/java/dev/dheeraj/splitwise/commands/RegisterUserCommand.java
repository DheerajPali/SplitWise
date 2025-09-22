package dev.dheeraj.splitwise.commands;

import dev.dheeraj.splitwise.controller.UserController;
import dev.dheeraj.splitwise.dto.RegisterUserRequestDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@NoArgsConstructor
public class RegisterUserCommand implements Command{
    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController){
        this.userController = userController;
    }
    @Override
    public boolean matches(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        return inputWords.size() == 4 && inputWords.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER);
    }

    @Override
    public void execute(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();

        String password = inputWords.get(1);
        String phoneNumber = inputWords.get(2);
        String userName = inputWords.get(3);


        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setUserName(userName);
        requestDto.setPhoneNumber(Long.parseLong(phoneNumber));
        requestDto.setPassword(password);

        userController.registerUser(requestDto);
    }
}
