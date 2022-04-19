/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.implementation;

import com.northeastern.info6205_menace.adt.BagInterface;
import com.northeastern.info6205_menace.adt.Bag_Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author achyuthvarma
 * This class is used to store the number of each colored beads
 */
public class MatchBox {

    Logger logger = LoggerFactory.getLogger(MatchBox.class.getName());

    BagInterface<Integer> bag = new Bag_Array<Integer>();

    private int blueBeads = 0;

    private int redBeads = 0;

    private int orangeBeads = 0;

    private int greenBeads = 0;

    private int pinkBeads = 0;

    private int purpleBeads = 0;

    private int yellowBeads = 0;

    private int greyBeads = 0;

    private int blackBeads = 0;

    public MatchBox(int eachColourNumberOfBeads) {

//        this.blueBeads = eachColourNumberOfBeads;
//        this.redBeads = eachColourNumberOfBeads;
//        this.orangeBeads = eachColourNumberOfBeads;
//        this.greenBeads = eachColourNumberOfBeads;
//        this.pinkBeads = eachColourNumberOfBeads;
//        this.purpleBeads = eachColourNumberOfBeads;
//        this.yellowBeads = eachColourNumberOfBeads;
//        this.greyBeads = eachColourNumberOfBeads;
//        this.blackBeads = eachColourNumberOfBeads;

        for(int i = 0; i < eachColourNumberOfBeads; i ++){
            int j = 0;
            while(j < 9){
                bag.add(j);
                j++;
            }
        }

    }

    public int getRandomBeadFromBag(){

        if(bag.isEmpty()) throw new RuntimeException("Bag is Empty!!");

        Random random = new Random();

        logger.info(bag.size()+"");

        int pickRandom = random.nextInt(bag.size());

        return bag.grabByIndex(pickRandom);
    }

    public int getRandomBeadFromBag(int beadNumber){

        if(bag.isEmpty()) throw new RuntimeException("Bag is Empty!!");

//        Random random = new Random();
//
//        int pickRandom = random.nextInt(bag.size());

        return bag.grab(beadNumber);
    }

    public void removeBeadsByDelta(int beadNumber, int delta){
        try{
            for(int i = 0; i < delta; i++){
                getRandomBeadFromBag(beadNumber);
            }
        }
        catch (RuntimeException e){
            System.out.println("Pass it off");
        }
    }

    public int pickRandomBead() {

        Random random = new Random();

        int theRandomNumber = random.nextInt(8);

        if (getBlueBeads() == 0 && getRedBeads() == 0 && getOrangeBeads() == 0 &&
                getGreenBeads() == 0 && getPinkBeads() == 0 && getPurpleBeads() == 0 &&
                getYellowBeads() == 0 && getGreyBeads() == 0 && getBlackBeads() == 0) {
            throw new RuntimeException("Match Box is Empty!!!");
        }


        switch (theRandomNumber) {
            case 0:
                if (getBlueBeads() < 1) {
                    return pickRandomBead();
                }
                setBlueBeads(getBlueBeads() - 1);
                return theRandomNumber;
            case 1:
                if (getRedBeads() < 1) {
                    return pickRandomBead();
                }
                setRedBeads(getRedBeads() - 1);
                return theRandomNumber;

            case 2:
                if (getOrangeBeads() < 1) {
                    return pickRandomBead();
                }
                setOrangeBeads(getOrangeBeads() - 1);
                return theRandomNumber;

            case 3:
                if (getGreenBeads() < 1) {
                    return pickRandomBead();
                }
                setGreenBeads(getGreenBeads() - 1);
                return theRandomNumber;

            case 4:
                if (getPinkBeads() < 1) {
                    return pickRandomBead();
                }
                setPinkBeads(getPinkBeads() - 1);
                return theRandomNumber;

            case 5:
                if (getPurpleBeads() < 1) {
                    return pickRandomBead();
                }
                setPurpleBeads(getPurpleBeads() - 1);
                return theRandomNumber;

            case 6:
                if (getYellowBeads() < 1) {
                    return pickRandomBead();
                }
                setYellowBeads(getYellowBeads() - 1);
                return theRandomNumber;

            case 7:
                if (getGreyBeads() < 1) {
                    return pickRandomBead();
                }
                setGreyBeads(getGreyBeads() - 1);
                return theRandomNumber;


            case 8:
                if (getBlackBeads() < 1) {
                    return pickRandomBead();
                }
                setBlackBeads(getBlackBeads() - 1);
                return theRandomNumber;


            default:
                throw new RuntimeException("Give Valid input");
//                return -1;
        }
    }

    public void addParticularBeads(int beadNumber, int multiple){
        for(int i = 0; i < multiple; i++){
            bag.add(beadNumber);
        }
    }

    public int getTotalMatchBoxSize(){
        return bag.size();
    }


    public int getPurpleBeads() {
        return purpleBeads;
    }

    public void setPurpleBeads(int purpleBeads) {
        this.purpleBeads = purpleBeads;
    }

    public int getBlueBeads() {
        return blueBeads;
    }

    public void setBlueBeads(int blueBeads) {
        this.blueBeads = blueBeads;
    }

    public int getRedBeads() {
        return redBeads;
    }

    public void setRedBeads(int redBeads) {
        this.redBeads = redBeads;
    }

    public int getOrangeBeads() {
        return orangeBeads;
    }

    public void setOrangeBeads(int orangeBeads) {
        this.orangeBeads = orangeBeads;
    }

    public int getGreenBeads() {
        return greenBeads;
    }

    public void setGreenBeads(int greenBeads) {
        this.greenBeads = greenBeads;
    }

    public int getPinkBeads() {
        return pinkBeads;
    }

    public void setPinkBeads(int pinkBeads) {
        this.pinkBeads = pinkBeads;
    }

    public int getYellowBeads() {
        return yellowBeads;
    }

    public void setYellowBeads(int yellowBeads) {
        this.yellowBeads = yellowBeads;
    }

    public int getGreyBeads() {
        return greyBeads;
    }

    public void setGreyBeads(int greyBeads) {
        this.greyBeads = greyBeads;
    }

    public int getBlackBeads() {
        return blackBeads;
    }

    public void setBlackBeads(int blackBeads) {
        this.blackBeads = blackBeads;
    }


}
