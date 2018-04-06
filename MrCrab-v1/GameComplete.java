import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game complete window
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class GameComplete extends World
{

    /**
     * Constructor for objects of class GameComplete.
     * 
     */
    public GameComplete()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        homeButton homebutton = new homeButton();
        addObject(homebutton, 305, 403);
        homebutton.setLocation(296, 394);
        Volume volume = new Volume(true);
        addObject(volume, 574, 470);
    }
}
