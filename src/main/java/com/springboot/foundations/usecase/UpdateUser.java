package com.springboot.foundations.usecase;

import com.springboot.foundations.entity.User;
import com.springboot.foundations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    @Autowired
    private UserService userService;

    public User update(com.springboot.foundations.entity.User user, Long id) {
        return userService.update(user, id);
    }
}
