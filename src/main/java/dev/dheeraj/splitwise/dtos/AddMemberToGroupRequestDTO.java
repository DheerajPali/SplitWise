package dev.dheeraj.splitwise.dtos;

import lombok.Data;

@Data
public class AddMemberToGroupRequestDTO {
    private Long userId;
    private Long groupId;
    private Long newMemberPhoneNumber;
}
