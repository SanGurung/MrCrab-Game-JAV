import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for lobster which is the villian in the game (Eats mrCrab).
 * 
 * @author Santosh Gurung
 * @version 1.1
 */
public class Lobster extends Actor
{   int k=0;
    private int imageNumber = 1;
    private int timer=1;
    public int level=1;
    public mrCrab iCrab;
    public Lobster(int level,mrCrab iCrab)
    {
        timer=1;
        this.level=level;
        this.iCrab=iCrab;
    }
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //levelWorld is created to check if the game is being pause or not.
        Level levelWorld = (Level) getWorld();  
        
        if(!levelWorld.isPaused){
            timer++;
            animate();
            
            if(!levelWorld.getObjects(mrCrab.class).isEmpty())
            {
                if(iCrab.isIdleForLong() && crabExist())   ultimateHunt();
                else scout();
                huntCrab();
            }
        }
    }    
       
    /**
     * This method is called in act to check if the lobster has eaten crab which means if crab is in same location as lobster.
     */
    public void huntCrab()
    {
        Actor crab;
        crab=getOneObjectAtOffset(0,0,mrCrab.class);
        if(crab!=null)
        {
            World world;
            world=getWorld();
            world.removeObject(crab);

            Greenfoot.setWorld(new GameOver(level));
        }   
    }  
    
    public boolean crabExist() 
    {
        World world=getWorld();
        int numberOfWorms=0;
        numberOfWorms=world.getObjects(Worm.class).size();
        if(numberOfWorms>0) return true;
        return false;
    }
    
    /**
     * 
     */
    public void ultimateHunt()
    {
        
        huntCrab();
        int xC=0,xL=0,yC=0,yL=0;
        //xC and yC is the Crab(x,y) or x and y axis of crab.
        //In xC c stands for Crab.
        xC=iCrab.getX();
        yC=iCrab.getY();
        //xL and yL is the Lobster(x,y) or x and y axis of lobster.
        //In xL L stands for Lobster
        xL=this.getX();
        yL=this.getY();
        
        moveTowardsCrab(xC,yC,xL,yL);
        turnTowardsCrab(xC,yC,xL,yL);
    }
    
    
    /**
     * This method enables Lobster to move towards crab.
     * It calculates the coordinates of Crab and sets the x and y coordinate of Lobster accordingly.
     */
    public void moveTowardsCrab(int xC,int yC,int xL,int yL)
    {
        int x=0,y=0;
        if(xL<xC) x=xL+1;
        else x=xL-1;
        if(yL<yC) y=yL+1;
        else y=yL-1;
        
        this.setLocation(x, y); 
    }
    
    /**
     * This method makes the lobster face towards the crab to mimic natural movement(*attempt).
     */
    public void turnTowardsCrab(int xC,int yC,int xL,int yL)
    {
        double km= 0;
        km=Math.toDegrees(Math.atan2(yC-yL,xC-xL));
        if(km<0) km=(180-Math.abs(km))+180;
        int i=(int)km;
        this.setRotation(i);
    }
    
    /**
     * This method is called in act to enable the lobster to scout or have a random movement.
     */
    public void scout()
    {
        move(1);
        if(Greenfoot.getRandomNumber(100)<10)               turn(Greenfoot.getRandomNumber(90)-45);
        if(getX() <=5 || getX()>=getWorld().getWidth()-5)   turn(180);
        if(getY()<=5 || getY()>=getWorld().getHeight()-5)   turn(180);
    }
    
    /**
     * animate() checks timer and changes the image of the lobster according to the time.
     * timer%17==0 checks if current timer is divisible by 17 giving remainder 17.
     * Hence it helps to keep an interval of about 17 act() cycles.
     */
    public void animate()
    {
        if(timer%17==0) changeImage();
        if(timer>=100) timer=0; //It will ensure timer doesn't increment to infinity or upto limit.
    }
    
    /**
     * changeImage() changes the image of the Lobster.
     * imageNumber is the number of image or more specifically Lobster-sprite-X.png (Lobster-sprite-1.png)
     * X is the imageNumber. There is 3 image which is 
     * Lobster-sprite-1.png 
     * Lobster-sprite-2.png
     * Lobster-sprite-3.png
     *
     * Hence, setImage("lobster-sprite-" + imageNumber + ".png"); sets those 3 images in sequence.
     */
    public void changeImage()
    {
       if(imageNumber<3 && imageNumber>=1)  imageNumber=imageNumber + 1;
       else  imageNumber=1;
       
       setImage("Lobster-sprite-" + imageNumber + ".png"); 
    }
}
