package com.springboot.foundations.configuration;

import com.springboot.foundations.service.UserService;
import com.springboot.foundations.usecase.GetUser;
import com.springboot.foundations.usecase.GetUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {


    @Bean
    GetUser getUser(){
        return new GetUserImpl();
    }

}
