import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);
        
        prepare();
        
    }
    private void prepare(){
        Crab crab = new Crab();
        addObject(crab,69,270);
        
        Lobster lobster = new Lobster();
        addObject(lobster,398,56);
        
        Lobster lobster2 = new Lobster();
        addObject(lobster2,383,516);
        
        Worm worm = new Worm();
        addObject(worm,112,72);
        
        Worm worm2 = new Worm();
        addObject(worm2,463,25);
        Worm worm3 = new Worm();
        addObject(worm3,289,67);
        Worm worm4 = new Worm();
        addObject(worm4,397,185);
        Worm worm5 = new Worm();
        addObject(worm5,520,350);
        Worm worm6 = new Worm();
        addObject(worm6,495,508);
        Worm worm7 = new Worm();
        addObject(worm7,286,357);
        Worm worm8 = new Worm();
        addObject(worm8,40,522);
    
    }
}