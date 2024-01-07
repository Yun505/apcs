import greenfoot.*;

/**
 * This is a stick man. Make him run and jump.
 * 
 * @author 
 * @version 
 */
public class Stickman extends Actor
{
    /**
     * Make the stickman act.
     */
    public void act() 
    {  
        if (isAtEdge()){
            gameWon();
        }
        if (isTouching(FallingObject.class)){
            gameLost();
        }
        move(4);
        checkKeyPress();
    }    
    public void checkKeyPress() {
        if (Greenfoot.isKeyDown("space")) {
            move(-6);
     
        }
    }
    public void gameWon(){
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop(); 
    }
    public void gameLost(){
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
    }
}
