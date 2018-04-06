import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * retryButton, when clicked will show the previous level window.
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class retryButton extends button
{
    int status=0;
    music speaker=new music();
    public int level=1;
    /**
     * Constructor for retryButton class.
     * 
     * @param level is the level of the game.
     */
    public retryButton(int level)
    {
       super.setSettings(this,"retry");
       this.level=level;
    }
    
    /**
     * Act - do whatever the levelButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        status=isMouseClicked();
        if(status==1)
        {
            speaker.sound.stop();
            Greenfoot.setWorld(new Level(level));
        }
    }    
}