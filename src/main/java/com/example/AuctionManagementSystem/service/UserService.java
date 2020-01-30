package com.example.AuctionManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	public void addUser(User user) {
		List<User> users = this.getAllUsers();
		if(users.isEmpty())
			userRepository.save(user);
		for(User u : users) {
			if(u.getUsername().equals(user.getUsername()))
				System.out.println("User already Registered !!!");
			else if(user.getUsername().isEmpty())
				System.out.println("Please enter Username");
			else
			userRepository.save(user);
		}
	}

	public void updateUser(String username, User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long username) {
		userRepository.deleteById(username);
	}

}
