package com.example.tema8_v2.controller;

import com.example.tema8_v2.model.User;
import com.example.tema8_v2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static List<User> users;

    private final UserService userService;

    @PostMapping("/init")
    public List<User> init(){
        Stream<User> userStream;
        userStream = Stream.generate(User::createUser).limit(3);
        users = userStream.collect(Collectors.toList());
        return users;
    }

    @PostMapping("/filterAge")
    public List<User> filterAge(){
        return userService.filterAge(users);
    }

    @PostMapping("/doubleAge")
    public List<User> doubleAge(){
        return userService.doubleAge(users);
    }

    @GetMapping("/lastUser")
    public User lastUser(){
        return userService.lastUser(users);
    }

    @GetMapping("/getYoungest")
    public User youngest(){
        return userService.getYoungest(users);
    }

    @GetMapping("/getOldest")
    public User oldest(){
        return userService.getOldest(users);
    }

    @PostMapping("/removeDuplicates")
    public List<User> withoutDupes(){return userService.removeDuplicates(users); }

    @PostMapping("/filtered")
    public List<User> filtered(){return userService.filter(users);}

}
