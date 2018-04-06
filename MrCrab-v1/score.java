import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * 
 * 
 * @author Score
 * @version 1.2
 */
public class score extends Actor
{
    public int wormsEaten=0;
    
    /**
     * Constructor for score
     */
    public score()
    {
        wormsEaten=0;
    }
    /**
     * Act - do whatever the score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        display();
    }    
    
    /**
     * 
     */
    public void display()
    {
        setImage(new GreenfootImage(40, 30));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(20.0F));  
        
        GreenfootImage scoreText = getImage();
        scoreText.clear();  
        String space="";
        if(wormsEaten<10) space="    ";
        else if(wormsEaten<100) space="   ";
        else if(wormsEaten<1000)space=" ";
        else space="";
        scoreText.drawString(space+ wormsEaten, 1, 18);
    }
    
    /**
     * 
     */
    public void addPoints()
    {
        wormsEaten=wormsEaten+1;
    }
    
    /**
     * 
     */
    public int countPoints()
    {
        return wormsEaten;
    }
}
