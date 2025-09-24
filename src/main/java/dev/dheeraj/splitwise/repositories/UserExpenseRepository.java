package dev.dheeraj.splitwise.repositories;

import dev.dheeraj.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense,Long> {
}
