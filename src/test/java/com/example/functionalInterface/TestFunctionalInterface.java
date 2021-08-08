package com.example.functionalInterface;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestFunctionalInterface {
    @Test
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,3,4,5,6,7,8,2);
        intList.stream().filter(x->x>3).limit(2).forEach(System.out::println);
    }
}