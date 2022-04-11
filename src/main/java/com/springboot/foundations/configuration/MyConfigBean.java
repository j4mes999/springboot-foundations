package com.springboot.foundations.configuration;

import com.springboot.foundations.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigBean {

    @Bean
    public MyBean beanOperation(){
        return new MyBeamTwoImpl();
    }

    @Bean
    public MyOperation beanMyOperation(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency beanMyOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDepImpl(myOperation);
    }
}
