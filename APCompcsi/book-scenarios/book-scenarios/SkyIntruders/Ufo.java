import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ufo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ufo extends Actor
{
    int speed = (int)(Math.random()*(6))+1; 
    /**
     * Act - do whatever the Ufo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ufo(){
        int a = (int)( Math.random()*2); 
        
        if (a==1){
            speed*=-1;
        }
    }
    public void act() 
    {
        move(speed); 
        if (isAtEdge()){
            setLocation(getX(), getY()+15); 
             move(speed*=-1); 
           
        }
    }    
}
