package com.springboot.foundations.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDepImpl implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDepImpl.class);

    MyOperation myOperation;

    public MyBeanWithDepImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int num = 1;
        LOGGER.info("This is an  info message in MyBeanWithDepImpl");
        System.out.println("Hola desde la implementacion de un bean con dependencia " + myOperation.sum(num));
        LOGGER.debug("The number is: " + num);
    }
}
