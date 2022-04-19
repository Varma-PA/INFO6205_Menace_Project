package com.northeastern.info6205_menace.implementation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.implementation.Board.printBoard;

public class GamePlayerVsComputer {

    HashMap<Integer, Integer> storeResults;

    public static void main(String[] args) {

        GamePlayerVsComputer gamePlayerVsComputer = new GamePlayerVsComputer();



        Board board = new Board(5, 2, 1, 1);

//        char[][] theBoard = board.getEmptyBoard();

        Hashtable<Integer, MatchBox> theHashTable = board.getHashtable();


        Scanner s = new Scanner(System.in);


        while(true) {

            System.out.println("The game begins!!");

            char[][] theBoard = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            printBoard(theBoard);

            gamePlayerVsComputer.storeResults = new HashMap<>();

            int i = 0;

            while (i < 9) {

                char characterTurn = gamePlayerVsComputer.returnCharacter(i);

                if (i % 2 == 0) {
                    // Computer's Turn
                    System.out.println("Computer's Turn: O");

                    theBoard = gamePlayerVsComputer.getBeadAndFixItToBoard(theBoard, i, theHashTable, board);

                } else {
                    //Human's Turn
                    System.out.println("Your Turn: X");

                    theBoard = gamePlayerVsComputer.humanTurn(theBoard, i);
                }

                if (getResult(theBoard, characterTurn)) {

                    printBoard(theBoard);

                    if (characterTurn == 'O') {
//                    If Computer won the match
                        System.out.println("Computer won!!");
                        for (Map.Entry<Integer, Integer> entrySet : gamePlayerVsComputer.storeResults.entrySet()) {
//                        Adding 2 beads if the game is won by the computer
                            theHashTable.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getBeta());
                        }

                    } else if (characterTurn == 'X') {
                        // Removing one bead cause computer lost the game
                        System.out.println("Congrats, you won!!");

                        for (Map.Entry<Integer, Integer> entrySet : gamePlayerVsComputer.storeResults.entrySet()) {
//                        Adding 2 beads if the game is won by the computer
                            theHashTable.get(entrySet.getKey()).removeBeadsByDelta(entrySet.getValue(), board.getDelta());
                        }
                    }
                    break;
                }

                i++;
            }

            if (i == 9) {
                System.out.println("Draw!!!");
                for (Map.Entry<Integer, Integer> entrySet : gamePlayerVsComputer.storeResults.entrySet()) {
//                        Adding 1 beads if the game is draw by the computer
                    theHashTable.get(entrySet.getKey()).addParticularBeads(entrySet.getValue(), board.getGamma());
                }

            }

            System.out.println("Do you want to play again!!?, give 0 or 1");

            int givenNumber = s.nextInt();

            if(givenNumber == 0){
                System.out.println("Thank you!!");
                break;
            }


        }


    }

    public char returnCharacter(int i) {
        if (i % 2 == 0) return 'O';
        else return 'X';
    }

    public char[][] getBeadAndFixItToBoard(char[][] board, int chance, Hashtable<Integer, MatchBox> theHashTable, Board theBoard) {
        int randomBeadFromBagNumber = theHashTable.get(chance / 2).getRandomBeadFromBag();
        int[] getCoordinates = theBoard.convertIntegerToCoordinate(randomBeadFromBagNumber);

        if (board[getCoordinates[0]][getCoordinates[1]] == ' ') {
            board[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
            storeResults.put(chance / 2, randomBeadFromBagNumber);
            return board;
        } else {
            return getBeadAndFixItToBoard(board, chance, theHashTable, theBoard);
        }

    }

    public char[][] humanTurn(char[][] board, int chance){
        Scanner scanner = new Scanner(System.in);

        printBoard(board);

        System.out.print("Give first coordinate: ");

        int firstCoordinate = scanner.nextInt();

        System.out.println();

        System.out.print("Give second coordinate: ");

        int secondCoordinate = scanner.nextInt();

        if (board[firstCoordinate][secondCoordinate] == ' ') {
            board[firstCoordinate][secondCoordinate] = returnCharacter(chance);
            return board;
        } else {
            System.out.println("Please try again!!");
            return humanTurn(board, chance);
        }
    }

}
