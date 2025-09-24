package dev.dheeraj.splitwise.repositories;

import dev.dheeraj.splitwise.models.Group;
import dev.dheeraj.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    List<Group> findAllByMembersContaining(List<User> members);
//    List<Group> findAllByMembersContaining
}
