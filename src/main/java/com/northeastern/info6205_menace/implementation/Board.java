/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.implementation;

import java.util.Hashtable;

/**
 * @author achyuthvarma
 */
public class Board {

    private Hashtable<Integer, MatchBox> hashtable = new Hashtable<Integer, MatchBox>();

    private int alpha = 0;
    private int beta = 0;
    private int gamma = 0;
    private int delta = 0;

    private char[][] emptyBoard = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public Board(int alpha, int beta, int gamma, int delta){

        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
        this.delta = delta;

        hashtable.put(0, new MatchBox(alpha));
        hashtable.put(1, new MatchBox(alpha));
        hashtable.put(2, new MatchBox(alpha));
        hashtable.put(3, new MatchBox(alpha));
        hashtable.put(4, new MatchBox(alpha));
    }

    public Board(){

    }


    public static void printBoard(char[][] characters) {

        System.out.println(characters[0][0] + "|" + characters[0][1] + "|" + characters[0][2]);
        System.out.println(characters[1][0] + "|" + characters[1][1] + "|" + characters[1][2]);
        System.out.println(characters[2][0] + "|" + characters[2][1] + "|" + characters[2][2]);

        System.out.println();

    }

    /**
     * Only when all the spaces are occupied
     *
     * @param characters
     * @return
     */

    public static boolean getResult(char[][] characters, char player) {

        // 3 Horizontal rows
        if (characters[0][0] == player && characters[0][0] == characters[0][1] && characters[0][1] == characters[0][2]) {
            return true;
        } else if (characters[1][0] == player && characters[1][0] == characters[1][1] && characters[1][1] == characters[1][2]) {
            return true;
        } else if (characters[2][0] == player && characters[2][0] == characters[2][1] && characters[2][1] == characters[2][2]) {
            return true;
        }

        // 3 vertical rows
        else if (characters[0][0] == player && characters[0][0] == characters[1][0] && characters[1][0] == characters[2][0]) {
            return true;
        } else if (characters[0][1] == player && characters[0][1] == characters[1][1] && characters[1][1] == characters[2][1]) {
            return true;
        } else if (characters[0][2] == player && characters[0][2] == characters[1][2] && characters[1][2] == characters[2][2]) {
            return true;
        }

        // Diagnol

        else if (characters[0][0] == player && characters[0][0] == characters[1][1] && characters[1][1] == characters[2][2]) {
            return true;
        } else if (characters[0][2] == player && characters[0][2] == characters[1][1] && characters[1][1] == characters[2][0]) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        char[][] internalCharacters = {{'O', 'X', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}};

        char[][] internalCharacters2 = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};



    }

    public int[] convertIntegerToCoordinate(int number) {

        int[] coordinates = new int[]{0, 0};

        switch (number) {
            case 0:
                coordinates[0] = 0;
                coordinates[1] = 0;
                return coordinates;
            case 1:
                coordinates[0] = 0;
                coordinates[1] = 1;
                return coordinates;
            case 2:
                coordinates[0] = 0;
                coordinates[1] = 2;
                return coordinates;
            case 3:
                coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
            case 4:
                coordinates[0] = 1;
                coordinates[1] = 1;
                return coordinates;
            case 5:
                coordinates[0] = 1;
                coordinates[1] = 2;
                return coordinates;
            case 6:
                coordinates[0] = 2;
                coordinates[1] = 0;
                return coordinates;
            case 7:
                coordinates[0] = 2;
                coordinates[1] = 1;
                return coordinates;
            case 8:
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
        }
        return coordinates;

    }

    public Hashtable<Integer, MatchBox> getHashtable() {
        return hashtable;
    }

    public void setHashtable(Hashtable<Integer, MatchBox> hashtable) {
        this.hashtable = hashtable;
    }

    public char[][] getEmptyBoard() {
        return emptyBoard;
    }

    public void setEmptyBoard(char[][] emptyBoard) {
        this.emptyBoard = emptyBoard;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public int getGamma() {
        return gamma;
    }

    public void setGamma(int gamma) {
        this.gamma = gamma;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
}
