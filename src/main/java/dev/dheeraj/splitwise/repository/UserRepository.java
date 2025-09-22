package dev.dheeraj.splitwise.repository;

import dev.dheeraj.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   public boolean existsUserByName(String name);
   public boolean  existsUserByPhone(Long phone);
   public User getUserByPhone(Long phone);
}
