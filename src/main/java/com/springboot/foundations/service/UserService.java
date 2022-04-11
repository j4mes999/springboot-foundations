package com.springboot.foundations.service;

import com.springboot.foundations.entity.User;
import com.springboot.foundations.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final Log LOG = LogFactory.getLog(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream().peek(user -> LOG.info("Insert: " + user))
                .forEach(user -> userRepository.save(user));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
       return userRepository.findById(id).map(
                user -> {
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setName(newUser.getName());

                    return userRepository.save(user);
                }

        ).orElse(null);
    }
}
