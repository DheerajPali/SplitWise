package dev.dheeraj.splitwise.models;

import dev.dheeraj.splitwise.models.constant.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

//@Data
@Getter
@Setter
@Entity(name = "users")
public class User extends  BaseModel{
    private String name;
    private long phone;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;
    @ManyToMany(mappedBy = "members")
    @ToString.Exclude
    private List<Group> groups;
}
