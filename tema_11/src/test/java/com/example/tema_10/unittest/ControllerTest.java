package com.example.tema_10.unittest;

import com.example.tema_10.controller.UserController;
import com.example.tema_10.model.User;
import com.example.tema_10.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ControllerTest {
    @Mock
    private UserService userService;
    List<User> users;

    @BeforeEach
    void init(){
        UserController userController = new UserController(userService);
        MockitoAnnotations.openMocks(this);
        users = new ArrayList<>();
        users.add(new User(1L, "Mircea", null, null, null));
        users.add(new User(1L, "Andreea", null, null, null));
        users.add(new User(1L, "Andrei", null, null, null));
    }

    @Test
    void given_whenGetAllRequest_thenReturnAllUsers(){
        UserController userController = new UserController(userService);
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        assert users.equals(userController.getAll());
    }

    @Test
    void givenUserId_whenGetUserById_thenFail(){
        UserController userController = new UserController(userService);
        Mockito.when(userService.getUserById(111L)).thenReturn(null);
        assert userController.getUser(111L) == null;
    }

    @Test
    void givenUserId_whenGetUserById_thenSucceed(){
        UserController userController = new UserController(userService);
        Mockito.when(userService.getUserById(1L)).thenReturn(users.get(1));
        assert userController.getUser(1L) == users.get(1);
    }
}
