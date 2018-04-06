import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * StartGame is where the game starts. It loads the start screen.
 * Once it load it plays music and when play button is clicked, you can play game.
 * 
 * @author Santosh Gurung
 * @version 2.1
 */
public class StartGame extends World
{
    int i=0;
    music speaker=new music();
    Volume volume = new Volume(true);
    /**
     * Constructor for objects of class StartGame.
     * setSpeed(50) sets the speed of the game to 50 which means the act() method will be called accordingly.
     */
    public StartGame(boolean start)
    {    
        // Create a new world with 600x500 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        Greenfoot.setSpeed(50);
        prepare();
        if(start) volume.setVolume(true);
    }
    
    public StartGame()
    {
       // Create a new world with 600x500 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        Greenfoot.setSpeed(50);
        prepare();
        volume.setVolume(true);
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        DancingCrab dancingcrab = new DancingCrab();
        addObject(dancingcrab, 294, 175);

        playButton playbutton = new playButton(true,speaker.sound);
        addObject(playbutton, 299, 355);
        playbutton.setLocation(345, 371);

        Worm worm = new Worm();
        Worm worm2 = new Worm();
        Worm worm3 = new Worm();
        addObject(worm, 275, 246);
        addObject(worm2, 445, 267);
        addObject(worm3, 186, 312);
        worm2.setLocation(456, 250);
        worm3.setLocation(447, 263);
        addObject(volume, 572, 471);

        levelButton levelbutton = new levelButton(0);
        addObject(levelbutton, 238, 386);
        levelbutton.setLocation(269, 372);
        creditsButton creditsbutton = new creditsButton();
        addObject(creditsbutton, 198, 379);
        playbutton.setLocation(396, 372);
        levelbutton.setLocation(307, 372);
        creditsbutton.setLocation(217, 377);
        creditsbutton.setLocation(217, 373);
        creditsbutton.setLocation(217, 374);
    }
    
    /**
     * It makes the sound run on time after the form or StartGame window is loaded.
     */
    public void act()
    {
        if(i<=10){
            if(i==10) { 
                speaker.sound.playLoop(); 
                //Ensures the music will play in the begining.
                //volume.setVolume(true);
                if(speaker.volume) speaker.sound.playLoop();
                else speaker.sound.stop();
            }
            i++;
        }
        else { i=20; }
    }
    
   
    /**
     * Reset the game
     */
    public void reset()
    {
        
    }
}
