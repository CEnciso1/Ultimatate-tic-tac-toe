/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ultimatettt;

/**
 *
 * @author CHRIS
 */
public class UltimateGame {
    
    private APlayer[] players = new APlayer[2];
    public UltimateBoard uBoard;
    
    private String[] marks = {"X", "0"};
    private int currentIndex = 0;
    int moveNum = 0;
    int priorBoard = 0;
    
    
    UltimateGame(){
        setPlayers();
        setBoard();
    }
    
    private void setPlayers()
    {
        for(int i = 0; i < players.length; i++)
        {
          RoboPlayer p = new RoboPlayer("player" + i+1, marks[i]);
          players[i] = p;
        }
    }
    
    public void setPlayers(APlayer player1, APlayer player2)
    {
        players[0] = player1;
        players[1] = player2;
        marks[0] = player1.getMark();
        marks[1] = player2.getMark();
    }
    
    public void setBoard(){
        this.uBoard = new UltimateBoard();
    }
    
    public void start()
    {
        System.out.println("Game start... ");
        do
        {
            uBoard.print();
            switchPlayer();
            System.out.print("Current Player: " + marks[currentIndex] + "\n");
            
            if(moveNum == 0 || uBoard.boards[priorBoard].isFull()){
                while(!makePlay(players[this.currentIndex].getMark(),
                        players[this.currentIndex].selectBoardNum(uBoard.boards.length),
                        players[this.currentIndex].selectBoxNum(uBoard.boards.length)));
                
            }
            else{
                System.out.println("Your oponent made you play board: " + priorBoard + "\n");
                while(!makePlay(players[this.currentIndex].getMark(),
                        priorBoard,
                        players[this.currentIndex].selectBoxNum(uBoard.boards.length)));
            }
            
            moveNum++;
            
        }while(!gameOver());
        uBoard.print();
    }
    
    //Updates the playes based on the symbol of the current player
    private void switchPlayer()
    {
        if((players[this.currentIndex].getMark()).equals(marks[0]))
        {
            currentIndex = 1;
        }
        else currentIndex = 0;
        
    }
    
    public boolean makePlay(String mark, int boardNum, int boxNum){
        
        if(!uBoard.boards[boardNum].boxes[boxNum].isFull()){
            priorBoard = boxNum;
            uBoard.boards[boardNum].boxes[boxNum].placeHolder = mark;
            uBoard.boards[boardNum].checkForWinner();
            return true;
        }
        else
        {
           System.out.println("Invalid move, try again");
            return false;
        }
        
    }
    
    public boolean horizontalWin(){
        
        String symbol = " ";
        boolean result = true;
        for(int i = 0; i < uBoard.rowSize; i++)
        {
            result = true;
            if(uBoard.getMark(i,0).equals("-")) {
                result = false;
                continue;  
            }
                
            
            symbol = uBoard.getMark(i,0);
            
            for(int j = 1; j< uBoard.colSize; j++)
            {
                if(!(uBoard.getMark(i,j).equals(symbol))) 
                {
                    result = false;
                }
            }
            
            if(result){
                System.out.println("Horizontal Win By " + symbol);
                return true;
            }
        }
        
        if(symbol.equals(" ")) result = false;
        return result;
    }
    
    public boolean verticalWin(){
        
        String symbol = " ";
        boolean result = true;
        for(int i = 0; i < uBoard.colSize; i++)
        {
            result = true;
            if(uBoard.getMark(0,i).equals("-"))
            {
                result = false;
                continue;
            }
            
            symbol = uBoard.getMark(0,i);
            
            for(int j = 1; j< uBoard.rowSize; j++)
            {
                
                if(!(uBoard.getMark(j,i).equals(symbol))) 
                {
                    result = false;
                } 
            }
            
            if(result)
            {
                System.out.println("Vertical Win By " + symbol);
                return true;
            }
        }
        
        if(symbol.equals(" ")) result = false;
        return result;
    }
    public boolean leftDiagonalWin(){
        
        String symbol = " ";
        boolean result = true;
        int i;
        int j;
        for(i = 0; i < uBoard.rowSize; i++)
        {
            
            if(!(uBoard.getMark(0,0).equals(Box.DASH))) symbol = uBoard.getMark(0,0);
            
            for(j = 1; j< uBoard.colSize; j++)
            {
                
                if((i==j) && !(uBoard.getMark(i,j).equals(symbol))) 
                {
                    result = false;
                    break;
                } 
            }
        }
        
        if(symbol.equals(" ")) result = false;
        
        if(result) {
            System.out.println("Diagonal Win By " + symbol);
            return true;
        }
        
        return result;
    }
    public boolean rightDiagonalWin(){
        
        String symbol = " ";
        boolean result = true;
        int i;
        int j;
        for(i = 0; i < 3; i++)
        {
            
            if(!(uBoard.getMark(0,uBoard.rowSize-1).equals(Box.DASH))) symbol = uBoard.getMark(0,uBoard.rowSize-1);
            
            for(j = 1; j< uBoard.rowSize - 1; j++)
            {
                
                if((i==j) && !(uBoard.getMark(i,j).equals(symbol))) 
                {
                    result = false;
                    break;
                } 
            }
        }
        
        if(symbol.equals(" ")) result = false;
        
        if(!(uBoard.getMark(uBoard.rowSize-1,0).equals(symbol))) result = false;
        
        if(result) { 
            System.out.println("Diagonal Win By " + symbol);
            return true;
        }
        
        return result;
    }
    
    boolean gameOver(){
        if(horizontalWin()) return true;
        else if(verticalWin()) return true;
        else if(leftDiagonalWin()) return true;
        else if(rightDiagonalWin()) return true;
        else if(uBoard.isFull()) 
        {
            System.out.println("Board is full. It's a tie");
            return true;
        }
        else return false;
    }
    
      
}
