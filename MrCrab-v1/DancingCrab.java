import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DancingCrab is a Actor or a crab with animation.
 * A set of 3 crab images are set as image in a interval.
 * 
 * @author Santosh Gurung
 * @version 2.1
 */
public class DancingCrab extends Actor
{
    private int timer=0,imageNumber=0,moveTowards=1;
    /*
     * Dancingcrab() is constructor
     */
    public DancingCrab()
    {
        timer=1;
        imageNumber=1;
        moveTowards=1; //It signals the crab to move towards point B
    }
    
    /**
     * Act - do whatever the DancingCrab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
       timer++;
       animate();
       crabMove(250,350,162); // Set pointA and pointB
    }    
    
    /**
     * animate() checks timer 
     */
    public void animate()
    {
        if(timer%27==0) changeImage();
        if(timer>=100) timer=0; //It will ensure timer doesn't increment to infinity or upto limit.
    }
    
    /**
     * changeImage() changes the image of the crab.
     * imageNumber is the number of image or more specifically big-crab-X.png (big-crab-1.png)
     * X is the imageNumber. There is 3 image which is 
     * big-crab-1.png 
     * big-crab-2.png
     * big-crab-3.png
     *
     * Hence, setImage("big-crab-" + this.imageNumber + ".png"); sets those 3 images in sequence.
     */
    public void changeImage()
    {
       if(imageNumber<3 && imageNumber>=1)  imageNumber=imageNumber + 1;
       else  imageNumber=1;
       
       setImage("big-crab-" + imageNumber + ".png"); 
    }
    
    /**
     * crabMove function can be used to set location of a actor.
     * This function is pretty basic.
     * 
     * x axis will be incremented by 1 if moveTowards is 1.
     * movetowards=1 means move towards point A.
     * 
     * x axis will be decremented by 1 if moveTowards is 0.
     * movetowards=0 means move towards point B.
     *                                |
     *                                |
     *  A----------------------B    (Y Axis)
     * @Param pointA is the point A where the crab will start moving from which means crab will move from A to B.
     * @Param pointB is the point B where the Crab will move towards and crab will move towards B to A once it reach B.
     *
     */
    public void crabMove(int pointA,int pointB,int fixedY)
    {
        int x=getX();
        if(x<pointA){  
           x=pointA+2;  //It check if crab is not between A---B it sets it to start from point A
           moveTowards=1;
        }
        if(x>pointB){
            x=pointB-2;
            moveTowards=0;
        }
        if(moveTowards==1) x++;  //
        else x--;
        setLocation(x,fixedY); 
    }
}
