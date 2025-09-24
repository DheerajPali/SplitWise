package dev.dheeraj.splitwise.dtos;

import dev.dheeraj.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class RegisterUserResponseDTO {
    private Long userId;
    private User user;
    private ResponseStatus responseStatus;
    private String message;
}
