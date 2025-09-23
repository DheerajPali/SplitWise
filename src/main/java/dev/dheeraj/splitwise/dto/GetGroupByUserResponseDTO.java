package dev.dheeraj.splitwise.dto;

import dev.dheeraj.splitwise.model.Group;
import lombok.Data;

import java.util.List;
@Data
public class GetGroupByUserResponseDTO {
    private List<Group> groups;
    private ResponseStatus responseStatus;
    private String message;
}
