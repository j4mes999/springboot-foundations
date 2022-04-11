package com.springboot.foundations.usecase;

import com.springboot.foundations.entity.User;

import java.util.List;

public interface GetUser {

    List<User> getAll();
}
