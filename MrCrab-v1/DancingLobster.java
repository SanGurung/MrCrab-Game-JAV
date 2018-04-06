import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DancingLobster is a Actor or a Lobster with animation.
 * A set of 3 lobster images are set as image in a interval.
 * 
 * @author Santosh Gurung
 * @version 2.1
 */
public class DancingLobster extends Actor
{
    private int timer=0,imageNumber=0;
    /*
     * DancingLobster() is constructor
     */
    public DancingLobster()
    {
        timer=1;
        imageNumber=1;
    }
    
    /**
     * Act - do whatever the DancingLobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
       timer++;
       animate();
    }    
    
    /**
     * animate() checks timer 
     */
    public void animate()
    {
        if(timer%7==0) changeImage();
        if(timer>=100) timer=0; //It will ensure timer doesn't increment to infinity or upto limit.
    }
    
    /**
     * changeImage() changes the image of the crab.
     * imageNumber is the number of image or more specifically big-lobster-X.png (big-lobster-1.png)
     * X is the imageNumber. There is 3 image which is 
     * big-lobster-1.png 
     * big-lobster-2.png
     * big-lobster-3.png
     *
     * Hence, setImage("big-lobster-" + this.imageNumber + ".png"); sets those 3 images in sequence.
     */
    public void changeImage()
    {
       if(imageNumber<3 && imageNumber>=1)  imageNumber=imageNumber + 1;
       else  imageNumber=1;
       
       setImage("big-lobster-" + imageNumber + ".png"); 
    }
}
