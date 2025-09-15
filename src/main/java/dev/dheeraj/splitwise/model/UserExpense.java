package dev.dheeraj.splitwise.model;

import dev.dheeraj.splitwise.model.constant.UserExpenseType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserExpense extends BaseModel{
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
//    @JoinColumn(name = "expense_id")
    private Expense expense;
}
