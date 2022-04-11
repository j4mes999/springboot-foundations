package com.springboot.foundations.usecase;

import com.springboot.foundations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    @Autowired
    private UserService userService;

    public void remove(Long id) {
        userService.delete(id);
    }
}
