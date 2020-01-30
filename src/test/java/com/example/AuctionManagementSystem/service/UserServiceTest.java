package com.example.AuctionManagementSystem.service;


import com.example.AuctionManagementSystem.model.User;
import com.example.AuctionManagementSystem.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository repository;
	
	@Test
	public void getAllUsers() {
		List<User> list = new ArrayList<>();
		User user1 = new User("ashish", "ashish");
		User user2 = new User("garg", "garg");
		list.add(user1);
		list.add(user2);
		
		when(repository.findAll()).thenReturn(list);
		
		List<User> userList = service.getAllUsers();
		
		Assert.assertEquals(2, userList.size());
		verify(repository, times(1)).findAll();
	}
	
	@Test
	public void getUserByUsername() {
		when(repository.findByUsername("ashish")).thenReturn(new User( "ashish", "ashish"));
		
		User user = service.getUser("ashish");

		Assert.assertEquals(1, user.getUserId());
		Assert.assertEquals("ashish", user.getPassword());
	}
	
	@Test
	public void addUser() {		
		User user = new User("ashish", "ashish");
		
		service.addUser(user);
		
		verify(repository, times(1)).save(user);
	}
	
}
