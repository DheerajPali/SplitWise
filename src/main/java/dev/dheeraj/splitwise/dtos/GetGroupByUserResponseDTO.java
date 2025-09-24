package dev.dheeraj.splitwise.dtos;

import dev.dheeraj.splitwise.models.Group;
import lombok.Data;

import java.util.List;
@Data
public class GetGroupByUserResponseDTO {
    private List<Group> groups;
    private ResponseStatus responseStatus;
    private String message;
}
