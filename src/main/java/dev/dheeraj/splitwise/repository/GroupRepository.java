package dev.dheeraj.splitwise.repository;

import dev.dheeraj.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Long, Group> {
}
