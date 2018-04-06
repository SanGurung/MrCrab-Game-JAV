import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playKeyMode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playKeyMode extends Actor
{
    mrCrab crab;
    public playKeyMode(mrCrab crab)
    {
        this.crab=crab;
    }
    
    public static boolean gamersKey=false;
    /**
     * Act - do whatever the playKeyMode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if(Greenfoot.mouseClicked(this)) 
         {
             if(gamersKey) gamersKey=false;
             else gamersKey=true; 
             crab.setRotation(0);
         }
         if(gamersKey) 
         {
             setImage("gamersKey.png");
         }
         else setImage("normalKey.png");
    }    
    
    public boolean status()
    {
        return gamersKey;
    }
}
