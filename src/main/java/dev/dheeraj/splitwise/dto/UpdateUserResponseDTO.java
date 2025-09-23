package dev.dheeraj.splitwise.dto;

import dev.dheeraj.splitwise.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResponseDTO {
    private User user;
    private ResponseStatus responseStatus;
    private String message;
}
