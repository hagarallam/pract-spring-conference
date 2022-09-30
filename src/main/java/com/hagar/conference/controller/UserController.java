package com.hagar.conference.controller;

import com.hagar.conference.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstName",defaultValue = "HAGAR") String firstName,
                        @RequestParam(value = "lastName",defaultValue = "ALLAM") String lastName,
                        @RequestParam(value = "age",defaultValue = "20") int age){
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("WE ARE IN POST , USER NAME "+user.getFirstName());
        return user;
    }
}
