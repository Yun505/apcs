import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void act() 
    {
       setLocation(getX(), getY()-8);
       checkCollision(); 
    }    
     private void checkCollision(){
        if (isTouching(Ufo.class)){
            ((MyWorld)getWorld()).addScore(10); 
            removeTouching(Ufo.class);
            getWorld().removeObject(this);
        }
        if (getY() ==0){
            ((MyWorld)getWorld()).addScore(-10); 
            getWorld().removeObject(this);
        }
    }
}
