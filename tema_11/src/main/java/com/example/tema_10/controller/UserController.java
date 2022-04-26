package com.example.tema_10.controller;

import com.example.tema_10.model.User;
import com.example.tema_10.repository.UserRepository;
import com.example.tema_10.service.CartService;
import com.example.tema_10.service.UserService;
import com.example.tema_10.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("users/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/addNewUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User deleted";
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "User updated";
    }
}
