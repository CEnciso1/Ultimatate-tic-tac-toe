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
public class Box {
    int row;
    int col;
    int number;
    final static String DASH = "-";
    public String placeHolder = Box.DASH;
    
    
    //Constructor that initializes the row and col values
    Box(int row, int col, int number)
    {
        this.row = row;
        this.col = col;
        this.number = number;
    }
    
    public String getPlaceHolder()
    {
        return placeHolder;
    }
    
    public void setPlaceHolder(String placeHolder)
    {
        this.placeHolder = placeHolder;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    //Checks if the box is empty (occupied by dash symbol)
    public boolean isFull()
    {
        return !this.placeHolder.equals(Box.DASH);
    } 
    
}
