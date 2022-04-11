package com.springboot.foundations.controller;

import com.springboot.foundations.entity.User;
import com.springboot.foundations.repository.UserRepository;
import com.springboot.foundations.usecase.CreateUser;
import com.springboot.foundations.usecase.DeleteUser;
import com.springboot.foundations.usecase.GetUser;
import com.springboot.foundations.usecase.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create, get, delete, update

    @Autowired
    private GetUser getUser;
    @Autowired
    private CreateUser createUser;
    @Autowired
    private DeleteUser deleteUser;
    @Autowired
    private UpdateUser updateUser;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    List<User> get(){
      return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newuser(@RequestBody User user) {

        return new ResponseEntity<>(createUser.save(user), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(user, id), HttpStatus.OK);
    }

    @GetMapping("/pageable")
    List<User> getUserPageable(@RequestParam int page, @RequestParam int size){
      return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }

}
