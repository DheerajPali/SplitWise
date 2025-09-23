package dev.dheeraj.splitwise.dto;

import lombok.Data;

@Data
public class AddMemberToGroupRequestDTO {
    private Long userId;
    private Long groupId;
    private Long newMemberPhoneNumber;
}
