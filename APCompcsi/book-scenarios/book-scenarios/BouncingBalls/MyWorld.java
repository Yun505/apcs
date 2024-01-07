import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addBall();
        addBall();
        addBall();
      
    }
    public void addBall(){
        Ball ball4 = new Ball(); 
        addObject(ball4,xLocation(), yLocation());
         
        
    }
    private int xLocation(){
        int x = (int)(Math.random() *573); 
        if (x<28){
            x=28; 
        }
        return x;
    }
    private int yLocation(){
       int y=(int)(Math.random() * 372);
       if (y<28){
           y=28; 
        }
        return y; 
    }
 
}
