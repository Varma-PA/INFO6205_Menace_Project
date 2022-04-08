package com.northeastern.info6205_menace.implementation;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainJavaTest {

    @Test
    public void generalTest(){
        MainJava mainJava = new MainJava();

        int sum = mainJava.addTwoNumbers(1, 2);

        assertEquals(sum, 3);

    }



}