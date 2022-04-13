/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.implementation;

/**
 *
 * @author achyuthvarma
 */
public class Board {
    
    
    public static void printBoard(char[][] characters){
        
        System.out.println(characters[0][0]+"|"+characters[0][1]+"|"+characters[0][2]);
        System.out.println(characters[1][0]+"|"+characters[1][1]+"|"+characters[1][2]);
        System.out.println(characters[2][0]+"|"+characters[2][1]+"|"+characters[2][2]);
        
        System.out.println();
        
    }
    
    /**
     * Only when all the spaces are occupied
     * @param characters
     * @return 
     */
    
    public static boolean getResult(char[][] characters, char player){
        
        // 3 Horizontal rows
        if(characters[0][0] == player && characters[0][0] == characters[0][1] && characters[0][1] == characters[0][2]){
            return true;
        }
        else if(characters[1][0] == player  && characters[1][0] == characters[1][1] && characters[1][1] == characters[1][2]){
            return true;
        }
        else if(characters[2][0] == player && characters[2][0] == characters[2][1] && characters[2][1] == characters[2][2]){
            return true;
        }
        
        // 3 vertical rows
        else if(characters[0][0] == player && characters[0][0] == characters[1][0] && characters[1][0] == characters[2][0]){
            return true;
        }
        else if(characters[0][1] == player && characters[0][1] == characters[1][1] && characters[1][1] == characters[2][1]){
            return true;
        }
        else if(characters[0][2] == player && characters[0][2] == characters[1][2] && characters[1][2] == characters[2][2]){
            return true;
        }
        
        // Diagnol
        
        else if(characters[0][0] == player && characters[0][0] == characters[1][1] && characters[1][1] == characters[2][2]){
            return true;
        }
        else if(characters[0][2] == player && characters[0][2] == characters[1][1] && characters[1][1] == characters[2][0]){
            return true;
        }
        
        return false;
        
    }
    
    
    
    public static void main(String[] args){
        
        char[][] internalCharacters = {{'O', 'X', 'X'}, 
                                        {'O', 'X', 'O'},
                                        {'X', 'O', 'X'}};
        
        
        printBoard(internalCharacters);
        
        System.out.println(getResult(internalCharacters, 'X'));
        
        
        
        
    }
    
    
    
    
}
