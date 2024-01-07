import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private int width = (getImage()).getWidth();
    private int height = (getImage()).getHeight();
    int xspeed = (int)(Math.random()*(6))+1;
    int yspeed = (int)(Math.random()*(6))+1;
    int x = (int)((Math.random() *573)+28); 
    int y=(int)((Math.random() * 372)+28);
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ball(){
        int a = (int)( Math.random()*2); 
        int b = (int)( Math.random()*2);
        
        if (a==1){
            xspeed*=-1;
        }
        if (b==1){
            yspeed*=-1; 
        }
    }
    public void act() 
    {   
           setLocation(getX()+xspeed,getY()+yspeed); 
            if ((getY()-height/2) <=0){
                turnAtTop(); 
            }
            if (getY()+height/2 >=400){
                turnAtBottom(); 
            }
            if (getX()-width/2 <=0){
                turnAtLeft();
            }
            if (getX() +width/2 >=600){
                turnAtRight(); 
            }
        
    }  
    public void turnAtBottom(){
         yspeed*=-1;
    }
    public void turnAtRight(){
        xspeed*=-1;
    }
    public void turnAtTop(){
        yspeed*=-1; 
    }
    public void turnAtLeft(){
        xspeed*=-1;
    }
}
