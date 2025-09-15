package dev.dheeraj.splitwise.repository;

import dev.dheeraj.splitwise.model.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
}
