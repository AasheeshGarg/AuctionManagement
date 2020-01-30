package com.example.AuctionManagementSystem.service;

import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	private Logger logger = Logger.getLogger(UserService.class.getName());

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	public User getUserById(Long userId) {
		return userRepository.findByUserId(userId);
	}

	public void addUser(User user) {

		if(user.getUsername().isEmpty()) {
			logger.info("Please enter Username");
			throw new IllegalArgumentException("Invalid UserName.");

		}
		List<User> users = this.getAllUsers();

		if(users.isEmpty())
			userRepository.save(user);
		for(User u : users) {
			if(u.getUsername().equals(user.getUsername())) {

				logger.info("User already Registered !!!");
				throw new IllegalArgumentException("User already registered.");
			}

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
