import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Credits Button, when clicked will show the credits window.
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class creditsButton extends button
{
    int status=0;
    music speaker=new music();
   
    /**
     * Constructor for creditsButton class.
     * 
     */
    public creditsButton()
    {
       super.setSettings(this,"credits");
    }
    
    /**
     * Act - do whatever the creditsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        status=isMouseClicked();
        if(status==1)
        {
            speaker.sound.stop();
            Greenfoot.setWorld(new Credits());
        }
    }    
}