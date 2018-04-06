import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * mrCrab is the Mr Crab character of the game, mrCrab moves according to keys pressed which is right and left.
 * 
 * @author Santosh Gurung
 * @version 2.0
 */
public class mrCrab extends Actor
{
    private int imageNumber = 1;
    public int timer=1,idleTimer=1;
    music sound=new music();   
    public score scoreCounter;
    public int numberOfWormsToEat=0;
    public int level=0;
    public int crabTimeLimit=100;

    /**
     * Constructor for mrCrab class
     */
    public mrCrab(score sc,int numberOfWormsToEat,int level)
    {
        timer=1;
        idleTimer=1;
        scoreCounter=sc;
        this.level=level;
        if(level==1) crabTimeLimit=60;
        else if(level==2) crabTimeLimit=50;
        else if(level==3) crabTimeLimit=45;
        else if(level<=5) crabTimeLimit=60;
        else if(level<=7) crabTimeLimit=200;
        else if(level<9) crabTimeLimit=250;
        else crabTimeLimit=250;
        
        this.numberOfWormsToEat=numberOfWormsToEat;
    }
    
    /**
     * Act - do whatever the mrCrab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //levelWorld is created to check if the game is being pause or not.
        Level levelWorld = (Level) getWorld();  
        if(!levelWorld.isPaused)
        {
            timer++;
            idleTimer++;
            animate();
            playKeyMode pKey=new playKeyMode(this);
            if(!pKey.status()) continuousWalk();
            else gamersStyleCrabMove(3);
            eatWorm();
            if(this.missionAccomplished()) 
            {
                 Greenfoot.setWorld(new ScoreBoard(level,levelWorld.bonusPointTimer));
            }
        }
    }   
    
    /**
     * This method is should be called in mrCrab method to ensure crab movement. If right or left key is pressed it turns
     */
    public void continuousWalk()
    {
        move(3);
        if(Greenfoot.isKeyDown("left")){
           turn(-4);  
           idleTimer=0;
        }
        if(Greenfoot.isKeyDown("right")){
            turn(4);
            idleTimer=0;
        }
    }
    
    /**
     * This methods could be used by lobster to get the idle time. If it is idle for long time Lobster will use its ultimateHunt method.
     */
    public boolean isIdleForLong()
    {
        //if the crab is idle for more than 500 crabs act() cycle then it will return true which means crab is idle.
        if(idleTimer>crabTimeLimit) return true;
        else return false;
    }
    
    /**
     * This method is should be called in mrCrab method to ensure crab movement.
     * This method is to be used instead of continuousWalk()
     * If right or left key is pressed it turns and if up or down key is pressed it moves.
     * Hence movement is combination of right or left key with up or down key.
     */
    public void advancedWalk()
    {
        if(Greenfoot.isKeyDown("up")) move(2);
        if(Greenfoot.isKeyDown("down")) move(-2);

        if(Greenfoot.isKeyDown("left"))  turn(-4);  
        if(Greenfoot.isKeyDown("right"))  turn(4);
    }
    
    /**
     * This method is gamer style crab movement or use up,down,right & left key to move the crab around.
     */
    public void gamersStyleCrabMove(int v)
    {
        if(Greenfoot.isKeyDown("up"))     
        {
            setLocation(getX(), getY()-v); 
            setRotation(0);
            idleTimer=0;
        }
        if(Greenfoot.isKeyDown("down"))   
        {
            setLocation(getX(), getY()+v); 
            setRotation(180);
            idleTimer=0;
        }
        if(Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+v, getY()); 
            idleTimer=0;
        }
        if(Greenfoot.isKeyDown("left"))  
        {
            setLocation(getX()-v, getY()); 
            idleTimer=0;
        }

    }
    
    
    /**
     * animate() checks timer and changes the image of the crab according to the time.
     * timer%17==0 checks if current timer is divisible by 17 giving remainder 17.
     * Hence it helps to keep an interval of about 17 act() cycles.
     */
    public void animate()
    {
        if(timer%17==0) changeImage();
        if(timer>=100) timer=0; //It will ensure timer doesn't increment to infinity or upto limit.
    }
    
    /**
     * This method is called to eat the worm which means if worm.class is in same location as crab then remove worm.
     */
    public void eatWorm()
    {
        Actor worm;
        worm=getOneObjectAtOffset(0,0,Worm.class);
        if(worm!=null)
        {
            World world;
            world=getWorld();
            world.removeObject(worm);
            scoreCounter.addPoints();
            //play the sound only if volume is on or true.
            if(sound.volume) Greenfoot.playSound("eating.wav");
        }   
    }   
    
    /**
     * 
     */
    public boolean missionAccomplished()
    {
        if(scoreCounter.countPoints()>=this.numberOfWormsToEat) return true;
        else return false;
    }
    
    /**
     * changeImage() changes the image of the mrCrab.
     * imageNumber is the number of image or more specifically crab-sprite-X.png (crab-sprite-1.png)
     * X is the imageNumber. There is 3 image which is 
     * crab-sprite-1.png 
     * crab-sprite-2.png
     * crab-sprite-3.png
     *
     * Hence, setImage("crab-sprite-" + imageNumber + ".png"); sets those 3 images in sequence.
     */
    public void changeImage()
    {
       if(imageNumber<3 && imageNumber>=1)  imageNumber=imageNumber + 1;
       else  imageNumber=1;
       
       setImage("crab-sprite-" + imageNumber + ".png"); 
    }
}



    /**
     * This method is should be called in mrCrab method to ensure crab movement. If right or left key is pressed it turns however thr
     */
/*    public void walk()
    {

        boolean movement=Greenfoot.isKeyDown("space");
        if(Greenfoot.isKeyDown("up")) move(2);
        if(Greenfoot.isKeyDown("down")) move(-2);
        
        if(!(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left")))
        {
            if(Greenfoot.isKeyDown("left"))  turn(-4);  
            if(Greenfoot.isKeyDown("right"))  turn(4);
        }
        
    }
    */