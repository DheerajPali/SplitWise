package dev.dheeraj.splitwise.controller;

import dev.dheeraj.splitwise.dto.RegisterUserRequestDto;
import dev.dheeraj.splitwise.dto.RegisterUserResponseDto;
import dev.dheeraj.splitwise.dto.ResponseStatus;
import dev.dheeraj.splitwise.exception.UserAlreadyExistsException;
import dev.dheeraj.splitwise.model.User;
import dev.dheeraj.splitwise.service.UserService;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto){
        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        try{
            User user = userService.registerUser(requestDto.getUserName(),requestDto.getPhoneNumber(),requestDto.getPassword());
            responseDto.setUser(user);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("User created successfully");
            return responseDto;
        } catch (UserAlreadyExistsException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(e.getMessage());
        }
        catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }
}
