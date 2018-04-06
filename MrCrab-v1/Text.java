import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
/**
 * 
 * 
 * @author Santosh Gurung
 * @version 1.2
 */
public class Text extends Actor
{
    int num=0;
    /**
     * Constructor for Text
     */
    public Text(int number)
    {
        this.num=number;
    }
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
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
        image.setFont(font.deriveFont(20F));  
        
        GreenfootImage scoreText = getImage();
        scoreText.clear();  
        String space="";
        if(num<10) space="    ";
        else if(num<100) space="   ";
        else if(num<1000)space=" ";
        else space="";
        scoreText.drawString(space+ num, 1, 18);
    }
}
