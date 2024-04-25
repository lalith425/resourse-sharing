package com.project.resourcesharing.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.resourcesharing.exception.UserAlreadyExistException;
import com.project.resourcesharing.model.User;
import com.project.resourcesharing.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Integer signUpUser(User user) throws UserAlreadyExistException {
        Integer loginIdCheck = userRepository.findByUserId(user.getUserId());
        Integer emailIdCheck = userRepository.findByUserEmail(user.getEmail());

        System.out.println("loginIdCheck "+loginIdCheck);

        if (loginIdCheck != 0) {
            throw new UserAlreadyExistException("LoginId Already exist. change to new Login Id");
        }
        if (emailIdCheck != 0) {
            throw new UserAlreadyExistException("Email Already exist. Login with the existing email id");
        }

        return userRepository.addUser(user);

    }


    
    public  List<User>  getAllUsers()  {

        List<User> customers = userRepository.getAllUsers();

        return customers;

    }

    public User getUserById(String userId) {
        User user = userRepository.findUserById(userId);
        return user;
    }


    public Integer updateUser(User user) {
       return userRepository.updateUser(user);
    }


}
