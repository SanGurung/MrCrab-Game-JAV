import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level Button, when clicked will show the levelBoard window.
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class levelButton extends button
{
    int level=0;
    int status=0;
    music speaker=new music();
   
    /**
     * Constructor for levelButton class.
     * 
     * @param level is the level of the game.
     */
    public levelButton(int level)
    {
       super.setSettings(this,"level");
       //super.backgroundSound(sound);
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
            Greenfoot.setWorld(new levelBoard());
        }
    }    
}