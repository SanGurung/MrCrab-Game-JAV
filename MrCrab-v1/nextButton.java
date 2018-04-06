import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level Button, when clicked will show the levelBoard window.
 * 
 * @author Santosh Gurung
 * @version 1.2
 */
public class nextButton extends button
{
    int level=0;
    int status=0;
    int stars=0;
    music speaker=new music();
   
    /**
     * Constructor for nextlButton class.
     * 
     * @param level is the level of the game.
     */
    public nextButton(int level,int stars)
    {
       super.setSettings(this,"next");
       //super.backgroundSound(sound);
       this.level=level;
       this.stars=stars;
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
            Greenfoot.setWorld(new SaveGameProgress(level,stars));
        }
    }    
}