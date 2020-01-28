package com.example.AuctionManagementSystem.service;

/**
 * Created by AasheeshGarg
 */

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.User;


import java.util.logging.Logger;

@Service
public class LoginService {

    Logger logger = Logger.getLogger(LoginService.class.getName());

    @Autowired
    private UserService userService;


   
    public boolean loginUser(String userName, String password) {
        User user = userService.getUser(userName);
        if(user.getPassword().equals(password)){
        logger.info("User log in");
        return true;
        }else{
        return false;
        }
    }

  
}
