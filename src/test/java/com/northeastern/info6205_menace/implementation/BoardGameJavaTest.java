/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.implementation;

import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.implementation.Board.printBoard;
import org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author achyuthvarma
 */


public class BoardGameJavaTest {
   
    
    @Test
    public void testXDiagonal(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'O', 'X', 'X'}, 
                                        {'O', 'X', 'O'},
                                        {'X', 'O', 'X'}};
        
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
        
    }
    
    @Test
    public void testXOtherDiagonal(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'X', 'X', 'O'}, 
                                        {'O', 'X', 'O'},
                                        {'X', 'O', 'X'}};
        
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
        
    }
    
    @Test
    public void testXFirstHorizontal(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'X', 'X', 'X'}, 
                                        {'O', 'X', 'O'},
                                        {'O', 'O', 'X'}};
        
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
    }
    
    @Test
    public void testXSecondHorizontal(){
        
        Logger logger = LoggerFactory.getLogger(BoardGameJavaTest.class);
        
        logger.info("This is logging info"); 
       
        Board board = new Board();
        
        char[][] internalCharacters = {{'O', 'X', 'X'}, 
                                        {'X', 'X', 'X'},
                                        {'O', 'O', 'X'}};
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
    }
    
    @Test
    public void testXThirdHorizontal(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'O', 'X', 'X'}, 
                                        {'O', 'O', 'X'},
                                        {'X', 'X', 'X'}};
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
    }
    
    
    @Test
    public void testXFirstVertical(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'X', 'O', 'X'}, 
                                        {'X', 'O', 'X'},
                                        {'X', 'X', 'O'}};
        
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
    }
    
    @Test
    public void testXSecondVertical(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'O', 'X', 'O'}, 
                                        {'O', 'X', 'X'},
                                        {'X', 'X', 'O'}};
        
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
    }
    
    
    @Test
    public void testXThirdVertical(){
        
        Board board = new Board();
        
        char[][] internalCharacters = {{'O', 'X', 'X'}, 
                                        {'O', 'O', 'X'},
                                        {'X', 'O', 'X'}};
        
        
        printBoard(internalCharacters);
        
        boolean checkWinForX = getResult(internalCharacters, 'X');
        
        assertTrue(checkWinForX);
        
        
    }
    
}
