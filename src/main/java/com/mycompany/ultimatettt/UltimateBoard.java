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
public class UltimateBoard {
    Board[] boards;
    int rowSize;
    int colSize;
    int currentBoard;
    
    UltimateBoard(){
        this.rowSize = 3;
        this.colSize = 3;
        init();
        
    }
    
    
    private void init()
    {
        boards = new Board[rowSize * colSize];
        for(int i = 0; i < boards.length; i++)
        {
            Board b = new Board(i/rowSize, i%colSize, i);
            boards[i] = b;
        }
    }
   
    
    public void print()
    {
        
        int x = 0;
        for(int i = 0; i < rowSize; i++)
        {
            
            for(int j = 0; j < rowSize; j++){
                
                for(int k = 0; k < rowSize; k++){
                    System.out.print("Board " + (k + rowSize * i) + ": " );
                    for(int m = 0; m < rowSize; m++){
                      System.out.print(boards[k + (rowSize * i)].boxes[m + (rowSize * j)].placeHolder + " ");   
                    }
                    System.out.print(" ");
                }
                System.out.println();
                
            }
            System.out.println();
        } 
        
    }
    
    public String getMark(int row, int col)
    {
        return boards[row * rowSize + col].mark;
    }
    
    public boolean isFull()
    {
        for(Board b: boards)
            if(!b.isFull()) return false;
        return true;
    }
    
}
