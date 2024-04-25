package com.project.resourcesharing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.resourcesharing.Service.UserService;
import com.project.resourcesharing.exception.UserAlreadyExistException;
import com.project.resourcesharing.model.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rs")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    

    @PostMapping("/signup")
    public String signUpUser(@RequestBody User user) throws UserAlreadyExistException {
        try {
            log.info("add a user and");
            Integer updatedCount = userService.signUpUser(user);
            if(updatedCount ==1)
            return "User Added";
        } catch (UserAlreadyExistException e) {
            return e.getMessage();
        }
        return "error in adding user";
    }


    @GetMapping("/users/all")
    public List<User> getAllUsers() {
   
            log.info("getting all our users");
          
       return  userService.getAllUsers();

    } 

    
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        log.info("get user");
        return userService.getUserById(userId);
    }

    @PatchMapping("/userupdate")
    public String updateUser(@RequestBody User user) {
   
        log.info("getting all our users");
      
   Integer updated =  userService.updateUser(user);
        if(updated == 1){
            return "User Updated Successfully";
        }

        return "User not updated Successfully";

} 



    
}
