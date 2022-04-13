package com.example.tema8_v2.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private static int count;

    public static User createUser(){
        User newUser = new User();

        newUser.id = count;
        count++;

        Random rand = new Random();
        newUser.age = rand.nextInt(100);

        UUID uuid = UUID.randomUUID();
        newUser.name = uuid.toString();

        return newUser;
    }
}
