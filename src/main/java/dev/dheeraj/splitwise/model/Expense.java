package dev.dheeraj.splitwise.model;

import dev.dheeraj.splitwise.model.constant.ExpenseType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Expense extends BaseModel{
    private double amount;
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name ="group_id")
    private Group group;
}
