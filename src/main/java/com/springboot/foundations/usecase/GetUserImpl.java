package com.springboot.foundations.usecase;

import com.springboot.foundations.entity.User;
import com.springboot.foundations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetUserImpl implements GetUser{

    @Autowired
    private UserService userService;

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
