import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pause extends Actor
{
    /**
     * Act - do whatever the pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Level levelWorld = (Level) getWorld();  
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("space"))
        {
            if(levelWorld.isPaused) levelWorld.isPaused=false;
            else levelWorld.isPaused=true;
        }
        if(levelWorld.isPaused) setImage("play.jpg");
        else setImage("pause.jpg");
    }    
}
