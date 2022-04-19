package com.northeastern.info6205_menace.implementation;

import java.util.Hashtable;
import java.util.Scanner;

import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.implementation.Board.printBoard;


public class GamePlayervsTrainedComputer {


    Hashtable<Integer, MatchBox> trainedComputer;

    GameCvsC gameCvsC;

    public GamePlayervsTrainedComputer() {
        gameCvsC = new GameCvsC();
    }

    public static void main(String[] args) {

        System.out.println("Pure Computer Magic!!");

        Board board = new Board();

        GamePlayervsTrainedComputer gamePlayervsTrainedComputer = new GamePlayervsTrainedComputer();

        gamePlayervsTrainedComputer.setTrainedComputer(gamePlayervsTrainedComputer.initializeTrainedComputer());

        int i = 0;

        char[][] theBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printBoard(theBoard);

        while (i < 9) {

            char characterTurn = gamePlayervsTrainedComputer.returnCharacter(i);

            if (i % 2 == 0) {
                System.out.println("System's turn");

                theBoard = gamePlayervsTrainedComputer.getBeadAndFixItToBoard
                        (theBoard, i, gamePlayervsTrainedComputer.trainedComputer, board);

                printBoard(theBoard);

            } else {
                System.out.println("Your Turn!!");

                theBoard = gamePlayervsTrainedComputer.tempGiveUserInput(theBoard, i);

                printBoard(theBoard);

            }

            if(getResult(theBoard, characterTurn)){

                if(characterTurn == 'O'){
                    System.out.println("Trained Computer won!! ");
                }

                else if(characterTurn == 'X'){
                    System.out.println("You Won!!");
                }
                break;
            }

            i++;
        }

        if(i == 9){
            System.out.println("Draw");
        }

    }

    public char[][] getBeadAndFixItToBoard(char[][] board, int chance, Hashtable<Integer, MatchBox> machine, Board initializedBoard){
        int randomBeadFromBag = machine.get(chance / 2).getRandomBeadFromBag();

        int[] getCoordinates = initializedBoard.convertIntegerToCoordinate(randomBeadFromBag);

        if (board[getCoordinates[0]][getCoordinates[1]] == ' ') {
            board[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
//            storeResults.put(chance / 2, randomBeadFromBagNumber);
            return board;
        } else {
            return getBeadAndFixItToBoard(board, chance, machine, initializedBoard);
        }

    }


    public char returnCharacter(int i) {
        if (i % 2 == 0) return 'O';
        else return 'X';
    }

    public char[][] tempGiveUserInput(char[][] characterUserInput, int chance) {
        Scanner scanner = new Scanner(System.in);

        printBoard(characterUserInput);

        System.out.println("Give first coordinate: ");

        int firstCoordinate = scanner.nextInt();

        System.out.println("Give second coordinate: ");

        int secondCoordinate = scanner.nextInt();

        if (characterUserInput[firstCoordinate][secondCoordinate] == ' ') {
            characterUserInput[firstCoordinate][secondCoordinate] = returnCharacter(chance);
            return characterUserInput;
        } else {
            System.out.println("Please try again!!");
            return tempGiveUserInput(characterUserInput, chance);
        }


    }

    public Hashtable<Integer, MatchBox> initializeTrainedComputer() {


        gameCvsC.playGame(3000);

        return gameCvsC.getMachine1();
    }

    public Hashtable<Integer, MatchBox> getTrainedComputer() {
        return trainedComputer;
    }

    public void setTrainedComputer(Hashtable<Integer, MatchBox> trainedComputer) {
        this.trainedComputer = trainedComputer;
    }
}
