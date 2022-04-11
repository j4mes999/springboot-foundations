package com.springboot.foundations.usecase;

import com.springboot.foundations.entity.User;
import com.springboot.foundations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    @Autowired
    private UserService userService;


    public User save(User user) {
        return userService.save(user);
    }
}
