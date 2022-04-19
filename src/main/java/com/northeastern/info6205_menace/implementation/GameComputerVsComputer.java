package com.northeastern.info6205_menace.implementation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.northeastern.info6205_menace.implementation.Board.getResult;

public class GameComputerVsComputer {

    Hashtable<Integer, MatchBox> machine1 = new Hashtable<Integer, MatchBox>();

    Hashtable<Integer, MatchBox> machine2 = new Hashtable<Integer, MatchBox>();

    HashMap<Integer, Integer> storeBeadsOfMachine1 = new HashMap<>();

    HashMap<Integer, Integer> storeBeadsOfMachine2 = new HashMap<>();

    HashMap<Integer, Integer> score = new HashMap<>();


    public void playGame(int numberOfTimesGiven) {

        int numberOfTimesPlayed = 0;

        score.put(1, 0);
        score.put(2, 0);

        Board board = new Board(10, 2, 1, 1);

        // Setting up the matchboxes for machine 1
        machine1.put(0, new MatchBox(board.getAlpha()));
        machine1.put(1, new MatchBox(board.getAlpha()));
        machine1.put(2, new MatchBox(board.getAlpha()));
        machine1.put(3, new MatchBox(board.getAlpha()));
        machine1.put(4, new MatchBox(board.getAlpha()));

        // Setting up the matchboxes for machine 2
        machine2.put(0, new MatchBox(board.getAlpha()));
        machine2.put(1, new MatchBox(board.getAlpha()));
        machine2.put(2, new MatchBox(board.getAlpha()));
        machine2.put(3, new MatchBox(board.getAlpha()));
        machine2.put(4, new MatchBox(board.getAlpha()));

        while (numberOfTimesPlayed < numberOfTimesGiven) {

            char[][] theBoard = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            int i = 0;

            System.out.println(numberOfTimesPlayed+"=========");

            while (i < 9) {

                char characterTurn = returnCharacter(i);

                // For machine 1
                if (i % 2 == 0) {
                    theBoard = getBeadAndFixItToBoard(theBoard, i, machine1, storeBeadsOfMachine1, board);
                }

                // For machine 2
                else {
                    theBoard = getBeadAndFixItToBoard(theBoard, i, machine2, storeBeadsOfMachine2, board);
                }

                if (getResult(theBoard, characterTurn)) {

                    // If machine 1 wins
                    if (characterTurn == 'O') {

                        System.out.println("Machine 1 won!!");
                        // Rewarding Machine 1
                        for (Map.Entry<Integer, Integer> entrySet : storeBeadsOfMachine1.entrySet()) {
                            machine1.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getBeta());
                        }
                        // Punishing Machine 2
                        for (Map.Entry<Integer, Integer> entrySet : storeBeadsOfMachine2.entrySet()) {
                            machine2.get(entrySet.getKey()).removeBeadsByDelta(entrySet.getValue(), board.getDelta());
                        }

                        score.put(1, score.get(1)+1);

                    }

                    // if machine 2 wins
                    else if (characterTurn == 'X') {

                        System.out.println("Machine 2 won!!");

                        // Rewarding Machine 2
                        for (Map.Entry<Integer, Integer> entrySet : storeBeadsOfMachine2.entrySet()) {
                            machine2.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getBeta());
                        }
                        // Punishing Machine 1
                        for (Map.Entry<Integer, Integer> entrySet : storeBeadsOfMachine1.entrySet()) {
                            machine1.get(entrySet.getKey()).removeBeadsByDelta(entrySet.getValue(), board.getDelta());
                        }

                        score.put(2, score.get(2)+1);

                    }
                    break;
                }
                i++;
            }

            if (i == 9) {
                System.out.println("Draw!!");

                // Rewarding Machine 1
                for (Map.Entry<Integer, Integer> entrySet : storeBeadsOfMachine1.entrySet()) {
                    machine1.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getGamma());
                }

                // Rewarding Machine 2
                for (Map.Entry<Integer, Integer> entrySet : storeBeadsOfMachine2.entrySet()) {
                    machine2.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getGamma());
                }
            }
            numberOfTimesPlayed++;
        }

        System.out.println("Total Score!!");

        for(Map.Entry<Integer, Integer> mapEntry: score.entrySet()){
            System.out.println(mapEntry.getKey()+" : "+mapEntry.getValue());
        }

    }


    public char returnCharacter(int i) {
        if (i % 2 == 0) return 'O';
        else return 'X';
    }

    public char[][] getBeadAndFixItToBoard(char[][] board, int chance, Hashtable<Integer, MatchBox> theHashTable, HashMap<Integer, Integer> storeResults, Board theBoard) {


        try {
            int randomBeadFromBagNumber = theHashTable.get(chance / 2).getRandomBeadFromBag();
            int[] getCoordinates = theBoard.convertIntegerToCoordinate(randomBeadFromBagNumber);

            if (board[getCoordinates[0]][getCoordinates[1]] == ' ') {
                board[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
                storeResults.put(chance / 2, randomBeadFromBagNumber);
                return board;
            } else {
                return getBeadAndFixItToBoard(board, chance, theHashTable, storeResults, theBoard);
            }
        }
        catch (RuntimeException e){
            System.out.println("Bag is empty!! closing program");
            System.exit(1);

            return board;
        }
    }

    public static void main(String[] args){

        GameComputerVsComputer gameComputerVsComputer = new GameComputerVsComputer();
        gameComputerVsComputer.playGame(2);

    }


}
