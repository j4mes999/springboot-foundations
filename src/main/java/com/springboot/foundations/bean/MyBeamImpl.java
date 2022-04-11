package com.springboot.foundations.bean;

public class MyBeamImpl implements   MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion");
    }
}
