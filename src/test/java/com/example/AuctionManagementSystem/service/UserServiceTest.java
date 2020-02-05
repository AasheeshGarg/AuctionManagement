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
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository repository;
	
	@Test
	public void testGetAllUsers() {
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
	public void testGetUserByUsername() {
		when(repository.findByUsername("ashish")).thenReturn(new User("ashish", "ashish"));
		
		User user = service.getUser("ashish");

		Assert.assertEquals("ashish", user.getUsername());
		Assert.assertEquals("ashish", user.getPassword());
	}

	@Test
	public void testGetUserById() {
		when(repository.findByUserId(1l)).thenReturn(new User("ashish", "ashish"));

		User user = service.getUserById(1l);
		
		Assert.assertEquals("ashish", user.getPassword());
	}
	
	@Test
	public void testAddUser() {
		User user = new User("ashish", "ashish");
		when(repository.save(any(User.class))).thenReturn(user);
		when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);

		service.addUser(user);
		
		verify(repository, times(1)).save(user);
	}

	@Test
	public void TestAddDuplicateUser() {
		User user = new User("Ashish", "ashish");
		when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);
		when(repository.save(any(User.class))).thenReturn(user);

		service.addUser(user);
		try {
			List<User> userList = new ArrayList<>();
			userList.add(user);
			when(repository.findAll()).thenReturn(userList );
			service.addUser(user);
		}catch (IllegalArgumentException e){
			Assert.assertEquals(e.getMessage(), "User already registered.");
		}

		verify(repository, times(1)).save(user);
	}
	
	/*@Test
	public void testAddUserWithInvalidName() {
		User user = new User("", "ashish");
		when(repository.save(any(User.class))).thenReturn(user);

		try {
			service.addUser(user);
		}catch (IllegalArgumentException e){
		Assert.assertEquals(e.getMessage(), "Invalid UserName.");
	}

		verify(repository, times(0)).save(user);
	}*/
	
}
