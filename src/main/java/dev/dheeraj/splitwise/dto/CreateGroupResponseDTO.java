package dev.dheeraj.splitwise.dto;

import dev.dheeraj.splitwise.model.Group;
import lombok.Data;

@Data
public class CreateGroupResponseDTO {
    private Group group;
    private ResponseStatus responseStatus;
    private String message;
}
