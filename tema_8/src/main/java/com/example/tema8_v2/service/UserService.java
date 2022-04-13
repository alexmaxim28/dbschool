package com.example.tema8_v2.service;



import com.example.tema8_v2.model.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    public List<User> filterAge(List<User> users) {
        Stream<User> stream =  users.stream();
        return stream.filter((x) -> x.getAge() < 18).collect(Collectors.toList());
    }

    public List<User>  doubleAge(List<User> users) {
        Stream<User> stream =  users.stream();
        return stream.map((value) -> {
            value.setAge(value.getAge() * 2);
            return value;
        }).collect(Collectors.toList());

    }

    public User lastUser(List<User> users){

        Stream<User> stream =  users.stream();
        return stream.reduce((first, second) -> second).get();

    }

    public List<User> compareAscByAge(List<User> users)
    {
        Stream<User> stream =  users.stream();
        return stream.sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        }).collect(Collectors.toList());

    }

    public List<User> compareDescByAge(List<User> users)
    {
        Stream<User> stream =  users.stream();
        return stream.sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge() - o1.getAge();
            }
        }).collect(Collectors.toList());
    }

    public User getYoungest(List<User> users){
        return compareAscByAge(users).stream().findFirst().get();
    }

    public User getOldest(List<User> users){
        return compareDescByAge(users).stream().findFirst().get();
    }

    public List<User> removeDuplicates(List<User> users){
        return users.stream().distinct().collect(Collectors.toList());
    }

    public List<User> filter(List<User> users){

        return compareAscByAge(users.stream().filter((x) -> x.getAge() > 30).map((x) -> {
            x.setName(x.getName().toUpperCase());
            return x;
        }).collect(Collectors.toList()));
    }

}
