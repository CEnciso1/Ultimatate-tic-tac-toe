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
public abstract class APlayer {
    //The states of the APlayer class
    private String name;
    private String mark;
    
    //APlayer class cosntructor 
   APlayer(String name, String mark)
   {
       this.setName(name);
       this.setMark(mark);
   }
   //Setter and Getter mathods
   public String getName()
   {
       return name;
   }
   
   void setName(String name)
   {
       this.name = name;
   }
   
   public String getMark()
   {
       return mark;
   }
   
   void setMark(String mark)
   {
       this.mark = mark;
   }
   
    public abstract int selectBoardNum(int range);
    
    public abstract int selectBoxNum(int range);
    
}
