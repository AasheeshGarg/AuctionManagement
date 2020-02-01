package com.example.AuctionManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.service.UserService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @RequestMapping(value = "/users/registration", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}")
    public void updateUser(@RequestBody User user, @PathVariable String username){
         userService.updateUser(username, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{username}")
    public void deleteUser(@PathVariable Long username){
         userService.deleteUser(username);
    }

}
