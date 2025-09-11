package dev.dheeraj.splitwise.model;

import dev.dheeraj.splitwise.model.constant.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "users")
public class User extends  BaseModel{
    private String name;
    private long phone;
    private String password;
    private UserStatus status;
    @ManyToMany
    private List<Group> groups;
}
