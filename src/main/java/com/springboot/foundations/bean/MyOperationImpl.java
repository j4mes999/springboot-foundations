package com.springboot.foundations.bean;

public class MyOperationImpl implements MyOperation{
    @Override
    public int sum(int num) {
        return ++num;
    }
}
