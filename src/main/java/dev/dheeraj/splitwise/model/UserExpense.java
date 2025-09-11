package dev.dheeraj.splitwise.model;

import dev.dheeraj.splitwise.model.constant.UserExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class UserExpense extends BaseModel{
    private double amount;
    private UserExpenseType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
}
