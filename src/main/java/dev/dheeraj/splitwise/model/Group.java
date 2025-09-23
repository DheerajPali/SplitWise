package dev.dheeraj.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Data
@Entity(name = "groups")
public class Group extends BaseModel{
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
    @ManyToMany
    @ToString.Exclude
    private List<User> members;
}
