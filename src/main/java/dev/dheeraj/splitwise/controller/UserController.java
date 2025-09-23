package dev.dheeraj.splitwise.controller;

import dev.dheeraj.splitwise.dto.*;
import dev.dheeraj.splitwise.exception.InvalidCredentials;
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

    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO requestDto){
        RegisterUserResponseDTO responseDto = new RegisterUserResponseDTO();
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

    public UpdateUserResponseDTO updateUser(UpdateUserRequestDTO requestDTO){
        UpdateUserResponseDTO responseDTO = new UpdateUserResponseDTO();
        try{
            User user = userService.updateUserProfile(requestDTO.getPhoneNumber(), requestDTO.getOldPassword(), requestDTO.getNewPassword());
            responseDTO.setUser(user);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("User updated successfully");
            return responseDTO;
        }
        catch (InvalidCredentials e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
