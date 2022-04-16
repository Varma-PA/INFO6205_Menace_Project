/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.implementation;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * @author achyuthvarma
 */
public class TestMatchBox {

    Logger logger = LoggerFactory.getLogger(TestMatchBox.class);

    @Test
    public void testRandomPickOne() {

        MatchBox matchBox = new MatchBox(1);

        int number = matchBox.pickRandomBead();

        System.out.println(number);

        if (number == 0) {
            assertEquals(0, matchBox.getBlueBeads());
        } else if (number == 1) {
            assertEquals(0, matchBox.getRedBeads());
        } else if (number == 2) {
            assertEquals(0, matchBox.getOrangeBeads());
        } else if (number == 3) {
            assertEquals(0, matchBox.getGreenBeads());
        } else if (number == 4) {
            assertEquals(0, matchBox.getPinkBeads());
        } else if (number == 5) {
            assertEquals(0, matchBox.getPurpleBeads());
        } else if (number == 6) {
            assertEquals(0, matchBox.getYellowBeads());
        } else if (number == 7) {
            assertEquals(0, matchBox.getGreyBeads());
        } else if (number == 8) {
            assertEquals(0, matchBox.getBlackBeads());
        }

    }


    @Test
    public void testPickingUpInLoop() {
        MatchBox matchBox = new MatchBox(1);

        int i = 0;

        while (i < 8) {
            int number = matchBox.pickRandomBead();
            if (number == 0) {
                assertEquals(0, matchBox.getBlueBeads());
            } else if (number == 1) {
                assertEquals(0, matchBox.getRedBeads());
            } else if (number == 2) {
                assertEquals(0, matchBox.getOrangeBeads());
            } else if (number == 3) {
                assertEquals(0, matchBox.getGreenBeads());
            } else if (number == 4) {
                assertEquals(0, matchBox.getPinkBeads());
            } else if (number == 5) {
                assertEquals(0, matchBox.getPurpleBeads());
            } else if (number == 6) {
                assertEquals(0, matchBox.getYellowBeads());
            } else if (number == 7) {
                assertEquals(0, matchBox.getGreyBeads());
            } else if (number == 8) {
                assertEquals(0, matchBox.getBlackBeads());
            }
            i++;
        }
    }


//    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = RuntimeException.class)
//    @Test
    public void testExpectError(){

        MatchBox matchBox = new MatchBox(0);

//        Throwable exception = assertThrows(RuntimeException.class, () -> matchBox.pickRandomBead());

//        assertEquals("Match Box is Empty!!!", exception.getMessage());

//        thrown.expect(RuntimeException.class);
//
//        thrown.expectMessage("Match Box is Empty!!!");

        matchBox.pickRandomBead();

    }

//    @Test(expected = RuntimeException.class)
    @Test
    public void testingFrequencyOfPicksFromBag(){

        int alpha = 2;

        MatchBox matchBox = new MatchBox(alpha);

        int occurrencesOfOneValue = 0;

        int totalLoop = alpha * 8;

        int i = 0;

        while(i < totalLoop){

            int pickedUpValue = matchBox.getRandomBeadFromBag();

            if(pickedUpValue == 0){
                occurrencesOfOneValue++;
            }
            i++;
        }
        logger.info("Total Occurrences: "+occurrencesOfOneValue);
        assertEquals(occurrencesOfOneValue, 2);
    }

    @Test
    public void testBagSize(){

        MatchBox matchBox = new MatchBox(1);

        assertEquals(8, matchBox.getTotalMatchBoxSize());

    }

    @Test
    public void pickOneFromBag(){

        int alpha = 1;

        MatchBox matchBox = new MatchBox(alpha);

        logger.info("Inserted "+8*alpha+" total beads");

        assertEquals(8*alpha, matchBox.getTotalMatchBoxSize());

        logger.info("Removing one bead and the remaining will be "+((alpha * 8) - 1));

        matchBox.getRandomBeadFromBag();

        assertEquals(8*alpha - 1, matchBox.getTotalMatchBoxSize());

    }


    @Test(expected = RuntimeException.class)
    public void testRandomPickFromBagException(){
        MatchBox matchBox = new MatchBox(0);

        logger.info("Giving zero beads, so error should be thrown");

        matchBox.getRandomBeadFromBag();

    }


}
