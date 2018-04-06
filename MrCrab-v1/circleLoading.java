import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * circleLoading is a Actor or a circle with animation(color change).
 * A set of 3 different coloured circle images are set as image in a interval.
 * 
 * @author Santosh Gurung
 * @version 1.0
 */
public class circleLoading extends Actor
{
    private int timer=0,imageNumber=0;
    /*
     * Constructor for circleLoading
     */
    public circleLoading()
    {
        timer=1;
        imageNumber=1;
    }
    
    /**
     * Act - do whatever the circleLoading wants to do. This method is called whenever
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
        if(timer%17==0) changeImage();
        if(timer>=100) timer=0; //It will ensure timer doesn't increment to infinity or upto limit.
    }
    
    /**
     * changeImage() changes the image of the circle.
     * imageNumber is the number of image or more specifically circle-X.png (circle-1.png)
     * X is the imageNumber. There is 3 image which is 
     * circle-1.png 
     * circle-2.png
     * circle-3.png
     *
     * Hence, setImage("circle-" + this.imageNumber + ".png"); sets those 3 images in sequence.
     */
    public void changeImage()
    {
       if(imageNumber<3 && imageNumber>=1)  imageNumber=imageNumber + 1;
       else  imageNumber=1;
       
       setImage("circle-" + imageNumber + ".png"); 
    }
}
