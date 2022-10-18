package com.hagar.conference.controller;

import com.hagar.conference.model.User;
import com.hagar.conference.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
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

        userService.save(user);
        return user;
    }
}
