package dev.dheeraj.splitwise.services;

import dev.dheeraj.splitwise.exceptions.InvalidCredentials;
import dev.dheeraj.splitwise.exceptions.UserAlreadyExistsException;
import dev.dheeraj.splitwise.models.User;
import dev.dheeraj.splitwise.models.constant.UserStatus;
import dev.dheeraj.splitwise.repositories.UserRepository;
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

    public User updateUserProfile(Long phoneNumber, String oldPassword, String newPassword) throws  InvalidCredentials{
        User user = userRepository.getUserByPhone(phoneNumber);
        if(user == null || !user.getPassword().equalsIgnoreCase(oldPassword)){
            System.out.println("Invalid Credentials, please try again");
            throw new InvalidCredentials("Invalid Credentials, please try again");
        }

        user.setPassword(newPassword);
        return  userRepository.save(user);
    }
}
