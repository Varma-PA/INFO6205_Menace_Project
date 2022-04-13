/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.implementation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author achyuthvarma
 */
public class TestMatchBox {
    
    @Test
    public void testRandomPick1(){
        
        MatchBox matchBox = new MatchBox(1);
        
        int number = matchBox.pickRandomBead();
        
        System.out.println(number);
        
        if(number == 0){
            assertEquals(0, matchBox.getBlueBeads());
        }
        else if(number == 1){
            assertEquals(0, matchBox.getRedBeads());
        }
        else if(number == 2){
            assertEquals(0, matchBox.getOrangeBeads());
        }
        
    }
    
    
}
