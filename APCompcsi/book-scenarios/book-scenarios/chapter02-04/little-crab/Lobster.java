import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(5);
                
        randomTurn();
        
        if (isAtEdge()) {
            turn(17);
        }
        
        lookForCrab();
    }    
    public void randomTurn(){
        //if (Math.random() <.1){
            //int angle = (int) (Math.random()*91)-45;
            //turn(angle);
        //}
        turn(-5); 
    }
    public void lookForCrab(){
        if (isTouching(Crab.class)){
                removeTouching(Crab.class);
                Greenfoot.playSound("au.wav");
                Greenfoot.stop();
            }
        }
}
