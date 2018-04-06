import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class Star extends Actor
{
    /**
     * Constructerfor Star
     * 
     * @param number It is the score or the number of stars the user got in particular level.
     */
    public Star(int number)
    {
        this.setImage("star-"+number+".png");
    }
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
