/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ultimatettt;

import java.util.Scanner;

public class HumanPlayer  extends APlayer{
    
    
    
    public HumanPlayer(String name, String mark){
        
        super(name, mark);
    }
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public int selectBoxNum(int range){
        System.out.print("Enter a box value between 0 and 8: \n");
        int boxNumber;
        do{
            boxNumber = input.nextInt();
            if(boxNumber < 0 || boxNumber > (range-1)) System.out.println("Invalid entry try again");
            
        }while(boxNumber < 0 || boxNumber > (range-1));
        
       return boxNumber;
    }
    
    @Override
    public int selectBoardNum(int range){
        System.out.print("Enter a board value between 0 and 8: \n");
        int boardNumber;
        do{
            boardNumber = input.nextInt();
          if(boardNumber < 0 || boardNumber > (range-1)) System.out.println("Invalid entry try again");
            
        }while(boardNumber < 0 || boardNumber > (range-1));
        
       return boardNumber;
    }
    
}
