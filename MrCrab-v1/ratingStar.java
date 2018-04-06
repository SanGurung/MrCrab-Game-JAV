import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ratingStar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ratingStar extends Actor
{
    /**
     * Act - do whatever the ratingStar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public ratingStar(int starType)
    {
        if(starType==1) setImage("star-yellow.png");
        else 
        setImage("star-fail.png");
    }
}
