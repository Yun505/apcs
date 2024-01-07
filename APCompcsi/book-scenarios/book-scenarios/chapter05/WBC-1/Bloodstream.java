import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bloodstream is the setting for our White Blood Cell scenario. 
 * It's a place where blood cells, bacteria and viruses float around.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Bloodstream extends World
{
    private int score;
    private int timer = 2000;

    /**
     * Constructor: Set up the starting objects.
     */
    public Bloodstream()
    {    
        super(780, 360, 1); 

        setPaintOrder(Border.class);
        prepare();
        score = 0;
        showScore();
        showTimer();
    }

    private void showScore() {
        showText("Score: " + score, 80, 25);
    }

    private void showTimer() {
        showText("Time: " + timer, 700, 25);
    }
    
    private void countTime() {
        timer--;
        showTimer();
        if (timer == 0) {
            showText("Time is up!", 390, 150);
            showText("Final score: " + score, 390, 170);
            Greenfoot.stop();
        }
    }
    
    public void addScore (int points) {
        score += points;
        showScore();
        if (score < 0) {
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();
        }
    }
    
    /**
     * Create new floating objects at irregular intervals.
     */
    public void act()
    {
        countTime();
        
        if (Greenfoot.getRandomNumber(100) < 3)
        {
            addObject(new Bacteria(), 779, Greenfoot.getRandomNumber(360));
        }
        
        if (Math.random() * 100 < 1) { 
            addObject ( new Lining(), 779, 0);
        }

        if (Math.random() * 100 < 1) { 
            addObject ( new Lining(), 779, 359);
        }

        if (Math.random() * 100 < 1) { 
            addObject(new Virus(), 779, Greenfoot.getRandomNumber(360));
        }

    }
    
    /**
     * Prepare the world for the start of the program. In this case: Create
     * a white blood cell and the lining at the edge of the blood stream.
     */
    private void prepare()
    {
        WhiteCell whitecell = new WhiteCell();
        addObject(whitecell, 83, 179);
        
        Lining lining = new Lining();
        addObject(lining, 126, 1);
        
        Lining lining2 = new Lining();
        addObject(lining2, 342, 5);
        Lining lining3 = new Lining();
        addObject(lining3, 589, 2);
        Lining lining4 = new Lining();
        addObject(lining4, 695, 5);
        Lining lining5 = new Lining();
        addObject(lining5, 114, 359);
        Lining lining6 = new Lining();
        addObject(lining6, 295, 353);
        Lining lining7 = new Lining();
        addObject(lining7, 480, 358);
        Lining lining8 = new Lining();
        addObject(lining8, 596, 359);
        Lining lining9 = new Lining();
        addObject(lining9, 740, 354);
        
        Border b = new Border();
        addObject(b, 0, 180);
        
        addObject(new Border(), 770, 180);
    }
}
