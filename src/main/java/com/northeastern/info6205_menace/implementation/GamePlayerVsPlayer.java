package com.northeastern.info6205_menace.implementation;

import java.util.Scanner;

import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.implementation.Board.printBoard;

public class GamePlayerVsPlayer {

    public static void main(String[] args) {

        GamePlayerVsPlayer game = new GamePlayerVsPlayer();

        game.gamePlay();

    }

    public void gamePlay() {
        GamePlayerVsPlayer game = new GamePlayerVsPlayer();

        int i = 0;

        char[][] testCharacters = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };


        while (i < 9) {

            char characterTurn = returnCharacter(i);

            System.out.println("Chance: " + characterTurn);
            testCharacters = tempGiveUserInput(testCharacters, i);

            if (getResult(testCharacters, characterTurn)) {
                System.out.println("Congratulations!! " + characterTurn + " won!!");
                break;
            }
            i++;
        }

        if (i == 9) {
            System.out.println("Game is a draw!!!");
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

}
