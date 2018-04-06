import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Level is all levels window.
 * 
 * @author Santosh Gurung 
 * @version 2.0
 */
public class Level extends World
{
    public music speaker=new music();
    public Volume volume = new Volume(false);
    public boolean isPaused=false;
    public int bonusPointTimer=0;
    public int wormsTimer=0;
    public int wormsToEat=10;
    public score score = new score();
    public Text levelText;
    public Text totalWormsToEatText;
    public mrCrab mrcrab;
    public int level=1;
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level(int level)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        if(speaker.volume) Greenfoot.playSound("casual_game_level_complete.mp3");
        isPaused=false;
        this.level=level;
        prepareLevel(level);
    }

    /**
     * 
     */
    public void prepareLevel(int level)
    {
        levelText = new Text(level);
        addObject(levelText, 340, 18); 
        
        pause pause = new pause();
        addObject(pause, 541, 473);
        pause.setLocation(538, 471);
        
        addObject(volume, 572, 471);
        addObject(score, 228, 38);
        score.setLocation(398, 42);         
        
        if(level==1) 
        {
            this.wormsToEat=5;
            mrcrab= new mrCrab(score,wormsToEat,level);
            Greenfoot.setSpeed(50);
            setBackground("beachBackground.jpg");
        }   
        else if(level==2) 
        {
            this.wormsToEat=10;
            mrcrab= new mrCrab(score,wormsToEat,level);
            Greenfoot.setSpeed(50);
            setBackground("snowBackground.jpg");
        } 
        else if(level==3) 
        {
            this.wormsToEat=10;
            Greenfoot.setSpeed(50);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster2 = new Lobster(level,mrcrab);
            addObject(lobster2, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("gravelBackground.jpg");
        } 
        else if(level==4) 
        {
            this.wormsToEat=15;
            Greenfoot.setSpeed(50);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster3 = new Lobster(level,mrcrab);
            addObject(lobster3, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("grassBackground.jpg");
        } 
        else if(level==5) 
        {
            this.wormsToEat=20;
            Greenfoot.setSpeed(50);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster4 = new Lobster(level,mrcrab);
            addObject(lobster4, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("beachBackground.jpg");
        } 
        else if(level==6) 
        {
            this.wormsToEat=20;
            Greenfoot.setSpeed(50);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster5 = new Lobster(level,mrcrab);
            addObject(lobster5, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            
            Lobster lobster6 = new Lobster(level,mrcrab);
            addObject(lobster6, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("snowBackground.jpg");
        } 
        else if(level==7) 
        {
            this.wormsToEat=25;
            Greenfoot.setSpeed(50);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster7 = new Lobster(level,mrcrab);
            addObject(lobster7, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            
            Lobster lobster8 = new Lobster(level,mrcrab);
            addObject(lobster8, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("gravelBackground.jpg");
            
        } 
        else if(level==8) 
        {
            this.wormsToEat=20;
            Greenfoot.setSpeed(50);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster9 = new Lobster(level,mrcrab);
            addObject(lobster9, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            
            Lobster lobster10 = new Lobster(level,mrcrab);
            addObject(lobster10, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            
            Lobster lobster11 = new Lobster(level,mrcrab);
            addObject(lobster11, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("grassBackground.jpg");
        } 
        else if(level==9 || level==10) 
        {
            this.wormsToEat=20;
            Greenfoot.setSpeed(51);
            mrcrab= new mrCrab(score,wormsToEat,level);
            Lobster lobster9 = new Lobster(level,mrcrab);
            addObject(lobster9, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            
            Lobster lobster10 = new Lobster(level,mrcrab);
            addObject(lobster10, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            
            Lobster lobster11 = new Lobster(level,mrcrab);
            addObject(lobster11, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
            setBackground("mountainBackground.jpg");
        } 
        else
        { 
            this.wormsToEat=5;
            mrcrab= new mrCrab(score,wormsToEat,1);
            Greenfoot.setSpeed(50);
            setBackground("beachBackground.jpg");
        }
        

        
        addObject(mrcrab, 270, 432);
        mrcrab.setLocation(308, 461);
        
        totalWormsToEatText = new Text(wormsToEat);
        
        Lobster lobster = new Lobster(level,mrcrab);
        addObject(lobster, Greenfoot.getRandomNumber(580),Greenfoot.getRandomNumber(430));
        
        addObject(totalWormsToEatText, 228, 42);
        totalWormsToEatText.setLocation(228, 42);
	
	playKeyMode playkeymode = new playKeyMode(mrcrab);
        addObject(playkeymode, 50, 468);
    }
    
    
    public void act()
    {
        if(!this.isPaused) bonusPointTimer++;
        randomWorms();
    }
    
    /**
     * 
     */
    public void randomWorms()
    {
        if(!this.isPaused){
            if(countWorms()<10){
                if(wormsTimer%97==0){
                    int x=Greenfoot.getRandomNumber(580); 
                    int y=Greenfoot.getRandomNumber(430);
                    //It ensures the worms isnt in the left hand corner and is visible area.
                    if(x<65) x=83;
                    if(x>554) x=550-(x-540);
                    
                    if(y<77) y=72; 
                    if(y>410) y=410-(y-410);
                    addObject( new Worm(), x, y );
                }
                wormsTimer++;
            }
        }
    }
    
    /**
     * This method could be used to count number of worms in the world window.
     */
    public int countWorms() 
    {
        int numberOfWorms=0;
        numberOfWorms=this.getObjects(Worm.class).size();
        return numberOfWorms;
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
