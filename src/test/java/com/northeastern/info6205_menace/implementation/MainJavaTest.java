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
    
    @Test
    public void generalTest2(){
        MainJava mainJava = new MainJava();
        
        int sum = mainJava.addTwoNumbers(3, 4);
        
        assertEquals(sum, 7);
    }



}