package dev.dheeraj.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDTO {
    private Long phoneNumber;
    private String oldPassword;
    private String newPassword;
}
