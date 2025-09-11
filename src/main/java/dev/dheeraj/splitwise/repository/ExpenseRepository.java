package dev.dheeraj.splitwise.repository;

import dev.dheeraj.splitwise.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Long, Expense> {
}
