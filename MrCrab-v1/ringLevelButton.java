import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * ringLevelButton is being used in level board to show the progress.
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class ringLevelButton extends Actor
{
    public boolean completed=false;
    public int level=1;
    private boolean isMouseOnThis=false;  
    private boolean isMouseDown=false;
    private Actor x;
    music speaker=new music();
    public ringLevelButton(boolean completed,int level)
    {
        this.completed=completed;
        this.level=level;
        x=this;
        isMouseOnThis=false;
        isMouseDown=false;
       
        if(completed) setImage("levelDone.png");
        else setImage("levelNotDone.png");
    }
    /**
     * Act - do whatever the ringLevelButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(completed && isMouseClicked(true)==1)
        {
            speaker.sound.stop();
            levelBoard l=new levelBoard();
            l.stopSound();
            Greenfoot.setWorld(new Level(level));
        } 
        if(!completed && isMouseClicked(false)==1)
        {
            JOptionPane.showMessageDialog(null, "This level is locked.", "Crab World", 1);
        }
    }    
    
    public int isMouseClicked(boolean xm)
    {
        int status=0;

        if (!isMouseDown && Greenfoot.mousePressed(x)) {      
            x.setImage("levelDone-up.png"); 
            isMouseDown = true; 
        }  
        if(Greenfoot.mouseMoved(null))  
            isMouseOnThis = Greenfoot.mouseMoved(x);  
        if(!isMouseDown && isMouseOnThis)
             x.setImage("levelDone-up.png");
        if(!isMouseDown && !isMouseOnThis)
            if(xm) x.setImage("levelDone.png");   
            else x.setImage("levelNotDone.png");  
        if (isMouseDown && Greenfoot.mouseClicked(x)) {    
            x.setImage("levelDone-up.png"); 
            isMouseDown = false; 
            if(level==0){
                speaker.sound.stop();
                levelBoard l=new levelBoard();
                l.stopSound();
            }
            status=1;
        } 
        return status; 
     }
}
