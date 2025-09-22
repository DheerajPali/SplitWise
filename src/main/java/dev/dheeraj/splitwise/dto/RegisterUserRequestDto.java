package dev.dheeraj.splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String userName;
    private Long phoneNumber;
    private String password;
}
