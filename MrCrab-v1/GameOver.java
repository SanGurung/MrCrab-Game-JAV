import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOver is the last window which is loaded when the game is over or the crab has been caught by the lobster.
 * 
 * @author Santosh Gurung 
 * @version 2.1
 */
public class GameOver extends World
{
    int i=0;
    music speaker=new music();
    Volume volume = new Volume(true);
    int level=1;
    /**
     * Constructor for objects of class GameOver.
     */
    public GameOver(int level)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        this.level=level;
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(volume, 577, 469);
        volume.setLocation(572, 472);
        DancingLobster dancinglobster = new DancingLobster();
        addObject(dancinglobster, 310, 200);
        dancinglobster.setLocation(305, 194);

        retryButton retrybutton = new retryButton(level);
        addObject(retrybutton, 367, 355);
        homeButton homebutton = new homeButton();
        addObject(homebutton, 276, 350);
        homebutton.setLocation(262, 344);
        retrybutton.setLocation(352, 346);
    }


    /**
     * It makes the sound run on time after the form or GameOver window is loaded.
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
}
