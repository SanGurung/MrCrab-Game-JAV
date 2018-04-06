import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameInstruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameInstruction extends World
{
    int i=0;
    music speaker=new music();
    Volume volume = new Volume(true);
    
    /**
     * Constructor for objects of class gameInstruction.
     * 
     */
    public gameInstruction()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(volume, 572, 471);
        playButton playbutton = new playButton(false,speaker.sound);
        addObject(playbutton, 299, 355);
        playbutton.setLocation(345, 371);
        homeButton homebutton = new homeButton();
        addObject(homebutton, 371, 442);
        homebutton.setLocation(362, 442);
        levelButton levelbutton2 = new levelButton(1);
        addObject(levelbutton2, 444, 439);
        homebutton.setLocation(320, 437);
        levelbutton2.setLocation(419, 440);
        homebutton.setLocation(321, 440);
        playbutton.setLocation(504, 439);
    }
    
    /**
     * It makes the sound run on time after the form or gameInstruction window is loaded.
     */
    public void act()
    {
        if(i<=10){
            if(i==10) { 
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
