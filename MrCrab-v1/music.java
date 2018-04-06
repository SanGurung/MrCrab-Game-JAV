import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Music Class to be used with volume button.
 * 
 * @author Santosh Gurung 
 * @version 1.1
 */
public class music  
{
    public static GreenfootSound sound;
    public static boolean volume;
    /**
     * mute() and volume() method are here for future extension, right now volume is accessed to check volume status.
     */
    public void mute()
    {
        this.volume=false;
    }
    
    public void volume()
    {
        this.volume=true;
    }
}
