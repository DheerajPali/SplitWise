package dev.dheeraj.splitwise.dtos;

import dev.dheeraj.splitwise.models.User;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroupRequestDTO {
    private String name;
    private String description;
    private Long userId;
    private List<User> members;
}
