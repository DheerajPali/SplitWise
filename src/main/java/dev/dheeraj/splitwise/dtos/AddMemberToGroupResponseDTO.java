package dev.dheeraj.splitwise.dtos;

import dev.dheeraj.splitwise.models.Group;
import lombok.Data;

@Data
public class AddMemberToGroupResponseDTO {
    private Group group;
    private ResponseStatus responseStatus;
    private String message;
}
