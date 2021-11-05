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
public class RoboPlayer extends APlayer{
    
    public RoboPlayer(String name, String mark){
        super(name, mark);
    }
    
    @Override
   public int selectBoxNum(int range)
   {
       System.out.println("Enter a box value between 0 and 8: \n");
       int num = randomNumber(range);
       System.out.print(num + "\n");
       return num;
   }
   @Override
   public int selectBoardNum(int range)
   {
       System.out.println("Enter a board value between 0 and 8: \n");
       int num1 = randomNumber(range);
       System.out.print(num1 + "\n");
       return num1;
   }
   
   private int randomNumber(int range)
   {
       
       return (int) (Math.random() * range);
   }
}
