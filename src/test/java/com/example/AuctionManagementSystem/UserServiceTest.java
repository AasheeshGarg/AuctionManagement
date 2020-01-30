package com.example.AuctionManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.UserRepository;
import com.example.AuctionManagementSystem.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository repository;
	
	@Test
	public void getAllUsers() {
		List<User> list = new ArrayList<User>();
		User user1 = new User(1, "ashish", "ashish");
		User user2 = new User(2, "garg", "garg");
		list.add(user1);
		list.add(user2);
		
		when(repository.findAll()).thenReturn(list);
		
		List<User> userList = service.getAllUsers();
		
		assertEquals(2, userList.size());
		verify(repository, times(1)).findAll();
	}
	
	@Test
	public void getUserByUsername() {
		when(repository.findByUsername("ashish")).thenReturn(new User(1, "ashish", "ashish"));
		
		User user = service.getUser("ashish");
		
		assertEquals(1, user.getUserId());
		assertEquals("ashish", user.getPassword());
	}
	
	@Test
	public void addUser() {		
		User user = new User(1, "ashish", "ashish");
		
		service.addUser(user);
		
		verify(repository, times(1)).save(user);
	}
	
}
