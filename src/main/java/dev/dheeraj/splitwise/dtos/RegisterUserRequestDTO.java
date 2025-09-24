package dev.dheeraj.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String userName;
    private Long phoneNumber;
    private String password;
}
