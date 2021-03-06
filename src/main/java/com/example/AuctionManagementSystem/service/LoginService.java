package com.example.AuctionManagementSystem.service;

/**
 * Created by AasheeshGarg
 */

import com.example.AuctionManagementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class.getName());

    @Autowired
    private UserService userService;
    
    public boolean loginUser(String userName, String password) {
        User user = userService.getUser(userName);
        if(user == null) {
        	logger.info("User not Registered");
        	return false;
        }
        if(user.getPassword().equals(password)){
        	logger.info("User Successfully Logged In");
        	return true;
        }else{
        return false;
        }
    }

  
}
