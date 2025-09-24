package dev.dheeraj.splitwise.dtos;

import dev.dheeraj.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResponseDTO {
    private User user;
    private ResponseStatus responseStatus;
    private String message;
}
