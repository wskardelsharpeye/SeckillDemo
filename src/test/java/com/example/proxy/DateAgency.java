package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DateAgency<T> implements InvocationHandler {
     T target;

    public DateAgency(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("finding girl");
        method.invoke(target, args);
        return null;
    }
}
