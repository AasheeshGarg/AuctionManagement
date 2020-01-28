package com.example.AuctionManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.service.LoginService;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	 @RequestMapping(value = "/users/login", method = RequestMethod.POST)
	    public boolean loginUser(@RequestBody User user){
		 	return loginService.loginUser(user.getUsername(), user.getPassword());
	    }
}
