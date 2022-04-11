package com.springboot.foundations.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImpl implements  ComponentDependency{
    @Override
    public void saluda() {
        System.out.println("Hello world component 2");
    }
}
