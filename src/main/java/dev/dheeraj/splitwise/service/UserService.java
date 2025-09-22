package dev.dheeraj.splitwise.service;

import dev.dheeraj.splitwise.exception.UserAlreadyExistsException;
import dev.dheeraj.splitwise.model.User;
import dev.dheeraj.splitwise.model.constant.UserStatus;
import dev.dheeraj.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String userName, Long phoneNumber, String password) throws  UserAlreadyExistsException{

        User user = userRepository.getUserByPhone(phoneNumber);

        if(user != null && !user.getUserStatus().equals(UserStatus.INVITED)){
            throw new UserAlreadyExistsException("User already exist with phone number : " + phoneNumber);
        }

        if(user == null){
            user = new User();
        }
        user.setPassword(password);
        user.setPhone(phoneNumber);
        user.setName(userName);
        user.setUserStatus(UserStatus.ACTIVE);

        return  userRepository.save(user);
    }
}
