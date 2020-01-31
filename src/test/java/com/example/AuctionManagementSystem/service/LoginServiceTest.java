package com.example.AuctionManagementSystem.service;


import com.example.AuctionManagementSystem.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @InjectMocks
    LoginService service;

    @Mock
    UserService userService;

    @Test
    public void testLoginSuccess() {

        User user = new User("testUser", "testUser");
        user.setUserId(1);
        when(userService.getUser(anyString())).thenReturn(user);

        boolean result = service.loginUser(user.getUsername(),user.getPassword());

        Assert.assertEquals(result, true);
        verify(userService, times(1)).getUser(anyString());
    }

    @Test
    public void testLoginFail() {

        User user = new User("testUser", "testUser");
        user.setUserId(1);
        when(userService.getUser(anyString())).thenReturn(null);

        boolean result = service.loginUser(user.getUsername(),user.getPassword());

        Assert.assertEquals(result, false);
        verify(userService, times(1)).getUser(anyString());
    }
}
