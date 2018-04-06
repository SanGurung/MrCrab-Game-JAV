import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Home Button, when clicked will show the StartGame window.
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class homeButton extends button
{
    int status=0;
    music speaker=new music();
   
    /**
     * Constructor for homeButton class.
     * 
     * @param level is the level of the game.
     */
    public homeButton()
    {
       super.setSettings(this,"home");
    }
    
    /**
     * Act - do whatever the homeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        status=isMouseClicked();
        if(status==1)
        {
            speaker.sound.stop();
            Greenfoot.setWorld(new StartGame(false));
        }
    }    
}