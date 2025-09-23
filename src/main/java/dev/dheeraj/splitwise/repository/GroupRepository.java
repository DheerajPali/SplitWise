package dev.dheeraj.splitwise.repository;

import dev.dheeraj.splitwise.model.Group;
import dev.dheeraj.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    List<Group> findAllByMembersContaining(List<User> members);
//    List<Group> findAllByMembersContaining
}
