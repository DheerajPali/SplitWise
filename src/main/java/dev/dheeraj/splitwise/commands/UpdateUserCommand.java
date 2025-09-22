package dev.dheeraj.splitwise.commands;

import java.util.Arrays;
import java.util.List;

public class UpdateUserCommand implements Command{
    @Override
    public boolean matches(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        return inputWords.size() == 3 && inputWords.get(1).equalsIgnoreCase(CommandKeywords.UPDATE_PROFILE);
    }

    @Override
    public void execute(String string) {
        List<String> inputWords = Arrays.stream(string.split(" ")).toList();
        String userName = inputWords.getFirst();
        String newPassword = inputWords.getLast();

        //here I'll call UpdateUser method from my controller & will send request dto as input.
    }
}
