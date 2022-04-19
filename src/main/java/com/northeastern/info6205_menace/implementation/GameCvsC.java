package com.northeastern.info6205_menace.implementation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.implementation.Board.printBoard;

public class GameCvsC {

    public Board board;

    Hashtable<Integer, MatchBox> machine1 = new Hashtable<>();
    Hashtable<Integer, MatchBox> machine2 = new Hashtable<>();

    HashMap<Integer, Integer> storeBeads1 = new HashMap<>();
    HashMap<Integer, Integer> storeBeads2 = new HashMap<>();

    HashMap<Integer, Integer> totalScore = new HashMap<>();


    public GameCvsC() {
        board = new Board(1000, 3, 2, 2);

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

        totalScore.put(1, 0);
        totalScore.put(2, 0);

    }



    public void playGame(int numberOfTimesToPlayTheGame) {
        int gamesPlayed = 1;

        int drawCount = 0;

        while (gamesPlayed <= numberOfTimesToPlayTheGame) {

            char[][] theBoard = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            int i = 0;

            while (i < 9) {

                char characterTurn = returnCharacter(i);

                if(i % 2 == 0){
                    theBoard = getBeadAndFixItToBoard(theBoard, i, machine1, storeBeads1, board);
                }
                else{
                    theBoard = getBeadAndFixItToBoard(theBoard, i, machine2, storeBeads2, board);
                }

                if (getResult(theBoard, characterTurn)){

                    if(characterTurn == 'O'){
                        System.out.println("Machine 1 won!!");

                        // Rewarding machine 1
                        for(Map.Entry<Integer, Integer> entrySet: storeBeads1.entrySet()){
                            machine1.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getBeta());
                        }

                        // Punishing machine 2
                        for(Map.Entry<Integer, Integer> entrySet: storeBeads2.entrySet()){
                            machine2.get(entrySet.getKey()).removeBeadsByDelta(entrySet.getValue(), board.getDelta());
                        }


                        totalScore.put(1, totalScore.get(1)+1);
                    }
                    else if(characterTurn == 'X'){
                        System.out.println("Machine 2 Won!!");

                        // Rewarding machine 2
                        for(Map.Entry<Integer, Integer> entrySet: storeBeads2.entrySet()){
                            machine2.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getBeta());
                        }

                        // Punishing machine 1
                        for(Map.Entry<Integer, Integer> entrySet: storeBeads1.entrySet()){
                            machine1.get(entrySet.getKey()).removeBeadsByDelta(entrySet.getValue(), board.getDelta());
                        }

                        totalScore.put(2, totalScore.get(2)+1);
                    }

                    printBoard(theBoard);
                    break;
                }
                i++;
            }

            if (i == 9) {
                System.out.println("Draw!!");
                drawCount++;

                // Rewarding Machine 1
                for (Map.Entry<Integer, Integer> entrySet : storeBeads1.entrySet()) {
                    machine1.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getGamma());
                }

                // Rewarding Machine 2
                for (Map.Entry<Integer, Integer> entrySet : storeBeads2.entrySet()) {
                    machine2.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getGamma());
                }


                printBoard(theBoard);
            }


            gamesPlayed++;
        }
        System.out.println("Total Score");
        for(Map.Entry<Integer, Integer> entrySet: totalScore.entrySet()){
            System.out.println("Machine "+entrySet.getKey()+" : "+entrySet.getValue());
        }
        System.out.println("Total Draws: "+drawCount);

    }

    public char returnCharacter(int i) {
        if (i % 2 == 0) return 'O';
        else return 'X';
    }

    public char[][] getBeadAndFixItToBoard(char[][] board, int chance, Hashtable<Integer, MatchBox> machine, HashMap<Integer, Integer> storeResults, Board initializedBoard){

        int randomBeadFromBag = machine.get(chance / 2).getRandomBeadFromBag();
        int[] getCoordinates = initializedBoard.convertIntegerToCoordinate(randomBeadFromBag);

        if(board[getCoordinates[0]][getCoordinates[1]] == ' '){
            board[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
            storeResults.put(chance / 2, randomBeadFromBag);
            return board;
        }
        else{
            return getBeadAndFixItToBoard(board, chance, machine, storeResults, initializedBoard);
        }
    }

    public static void main(String[] args) {

        GameCvsC gameCvsC = new GameCvsC();

        gameCvsC.playGame(1024);
    }

    public void computervsComputer(int numberOfTimes){
        playGame(numberOfTimes);
    }

    public Hashtable<Integer, MatchBox> getMachine1() {
        return machine1;
    }

    public void setMachine1(Hashtable<Integer, MatchBox> machine1) {
        this.machine1 = machine1;
    }

    public Hashtable<Integer, MatchBox> getMachine2() {
        return machine2;
    }

    public void setMachine2(Hashtable<Integer, MatchBox> machine2) {
        this.machine2 = machine2;
    }
}
