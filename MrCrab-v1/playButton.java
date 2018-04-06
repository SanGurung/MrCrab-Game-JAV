import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * playButton is a button which is designed to be used in start screen however could be used in other world as well.
 * 
 * @author Santosh Gurung
 * @version 1.3
 */
public class playButton extends button
{
    boolean start=false;
    int status=0;
    music speaker=new music();
    GreenfootSound sound;
    /**
     * Constructor for playButton class.
     * 
     * @param sound is the Sound/music which will be played by the start form, hence to stop it from playing further this variable is sent to stop the sound.
     * @param level is the level of the game.
     */
    public playButton(boolean start,GreenfootSound sound)
    {
       super.setSettings(this,"play");
       this.start=start;
       this.sound=sound;
    }
    
    /**
     * Act - do whatever the playButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        status=isMouseClicked();
        if(status==1)
        {
            if(start) {
                sound.stop();
                speaker.sound.stop();
                Greenfoot.setWorld(new gameInstruction());
            }
            else {
                sound.stop();
                speaker.sound.stop();
                Greenfoot.setWorld(new Level(1));
            }
        }
    }    
}