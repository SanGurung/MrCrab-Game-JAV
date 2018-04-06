import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A button class which could be used to create different types of button such as play, pause, retry.
 * 
 * @author Santosh Gurung
 * @version 1.2
 */
public class button extends Actor
{
    private boolean isMouseOnThis=false;  
    private boolean isMouseDown=false;
    private String buttonName="";
    private int stageLevel=1;
    GreenfootSound startSound;
    private Actor x;
    music sound=new music();
    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public button()
    {
       isMouseOnThis=false;
       isMouseDown=false;
    }
    
    /**
     * It is the method to enable the button to react to mouse over, mouse down and mouse click.
     * 
     * @return status  It return status which is 0 or 1. If its 1 it means mouse was clicked.
     */
    public int isMouseClicked()
    {
        int status=0;
        if (!isMouseDown && Greenfoot.mousePressed(x)) {      
            x.setImage(buttonName+"-button-clicked.png");   
            isMouseDown = true; 
        }  
        if(Greenfoot.mouseMoved(null))  
            isMouseOnThis = Greenfoot.mouseMoved(x);  
        if(!isMouseDown && isMouseOnThis)
            x.setImage(buttonName+"-button-down.png");
        if(!isMouseDown && !isMouseOnThis)
            x.setImage(buttonName+"-button-up.png");   
        if (isMouseDown && Greenfoot.mouseClicked(x)) {    
            x.setImage(buttonName+"-button-up.png"); 
            if(sound.volume)  Greenfoot.playSound("button-sound.wav");
            isMouseDown = false; 
            if(stageLevel==0){
                sound.sound.stop();
            }
            status=1;
        } 
        return status;
    }
    
    /**
     * This method sets the sub class button or Actor nx to button class so that isMouseClicked can set the image for the button.
     * 
     * @param nX is a Actor or the subclass button. Sub class button such as playButton can use it's isMouseClicked method.
     * @param nButtonName is the name of the button such as "play", "retry" which would be the image file name.
     */
    public void setSettings(Actor nX,String nButtonName)
    {
        x=nX;
        buttonName=nButtonName;
    }
    
    /**
     * @param sound is the Sound/music which was being played by startForm. Its passed to stop it when button is clicked.
     */
    public void backgroundSound(GreenfootSound sound)
    {
        startSound=sound;
    }
}
