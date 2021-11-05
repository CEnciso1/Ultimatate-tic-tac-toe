
package com.mycompany.ultimatettt;
 
public class Board {
    public Box[] boxes;
    public int num;
    public int rowVal;
    public int colVal;
    private int rowSize;
    private int colSize;
    public String mark = "-";
    public boolean won = false;
    
    //Custom constructor
    Board(int rowVal, int colVal, int num)
    {
        this.rowSize = 3;
        this.colSize = 3;
        this.rowVal = rowVal;
        this.colVal = colVal;
        this.num = num;
        init();
    }
    
     public int getRowSize()
    {
        return rowSize;
    }
    
    public int getColSize()
    {
        return colSize;
    }
    
    private void init()
    {
        boxes = new Box[rowSize * colSize];
        
        for(int i = 0; i < boxes.length; i++)
        {
            Box b = new Box(i/rowSize, i%colSize, i);
            boxes[i] = b;
        }
    }
    
    
    public String getMark(int row, int col)
    {
        return boxes[row * rowSize + col].getPlaceHolder();
    }

    
//    //Checks if the board is full
    public boolean isFull()
    {
        if(won) return true;
        for(Box b: boxes)
            if(!b.isFull()) return false;
        return true;
    }
    
    
    
    public boolean horizontalWin(){
        
        String symbol = " ";
        boolean result = true;
        for(int i = 0; i < rowSize; i++)
        {
            result = true;
            if(getMark(i,0).equals("-")) {
                result = false;
                continue;  
            }
                
            
            symbol = getMark(i,0);
            
            for(int j = 1; j< colSize; j++)
            {
                if(!(getMark(i,j).equals(symbol))) 
                {
                    result = false;
                }
            }
            
            if(result){
                if(mark.equals("-")){
                    mark = symbol;
                    return true;
                }
                return false;
            }
        }
        
        if(symbol.equals(" ")) result = false;
        return result;
    }
    
    public boolean verticalWin(){
        String symbol = " ";
        boolean result = true;
        for(int i = 0; i < colSize; i++)
        {
            result = true;
            if(getMark(0,i).equals("-"))
            {
                result = false;
                continue;
            }
            
            
            symbol = getMark(0,i);
            
            for(int j = 1; j< rowSize; j++)
            {
                
                if(!(getMark(j,i).equals(symbol))) 
                {
                    result = false;
                } 
                
            }
            
            if(result)
            {
                if(mark.equals("-")){
                    mark = symbol;
                    return true;
                }
                
                return false;
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
        for(i = 0; i < rowSize; i++)
        {
            
            if(!(getMark(0,0).equals("-"))) symbol = getMark(0,0);
            
            for(j = 1; j< colSize; j++)
            {
                
                if((i==j) && !(getMark(i,j).equals(symbol))) 
                {
                    result = false;
                    break;
                } 
            }
        }
        
        if(symbol.equals(" ")) result = false;
        
        if(result) { 
             if(mark.equals("-")){
                    mark = symbol;
                    return true;
                }
                
                return false;
        }
        
        return result;
    }
//    //checks for a diagonal win from right to left
    public boolean rightDiagonalWin(){
        
        String symbol = " ";
        boolean result = true;
        int i;
        int j;
        for(i = 0; i < rowSize; i++)
        {
            
            if(!(getMark(0,rowSize-1).equals("-"))) symbol = getMark(0,rowSize-1);
            
            for(j = 1; j< rowSize - 1; j++)
            {
                
                if((i==j) && !(getMark(i,j).equals(symbol))) 
                {
                    result = false;
                    break;
                } 
            }
        }
        
        if(symbol.equals(" ")) result = false;
        
        if(!(getMark(rowSize-1,0).equals(symbol))) result = false;
        
        if(result) { 
            if(mark.equals("-")){
                    mark = symbol;
                    return true;
                }
                
                return false;
        }
        
        return result;
    }
    
    void checkForWinner(){
        if(horizontalWin()){
            won = true;
        }
        else if(verticalWin()){
            won =  true;
        }
        else if(leftDiagonalWin()){
            won = true;
        }
        else if(rightDiagonalWin()){
            won = true;
        }
        
    }
    
}
