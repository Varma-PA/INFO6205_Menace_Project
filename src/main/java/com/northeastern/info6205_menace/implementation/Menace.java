package com.northeastern.info6205_menace.implementation;

import java.util.HashMap;
import java.util.Random;

public class Menace {

    private int alpha;
    private int beta;
    private int gamma;
    private int delta;
    private HashMap<Integer, Integer> matchBoxNumberOfBeads = new HashMap<Integer, Integer>();

    public Menace(int alpha, int beta, int gamma, int delta){
        
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
        this.delta = delta;
        
    }
    
    
    public static void makeMove(char[][] ticTacToeCharacters){
        
        Random random = new Random();
        
        int xCordinate = random.nextInt(2);
        
        
        
    }
    
    public static void gameWon(){
        
        
        
    }
    
    public static void gameLost(){
        
    }




}
