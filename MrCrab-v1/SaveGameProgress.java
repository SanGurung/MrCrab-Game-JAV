import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * This method needs fileRead class to run (*Which i wrote to save data to file)
 * 
 * @author Santosh Gurung 
 * @version 1.0
 */
public class SaveGameProgress extends World
{
    public int level=1;
    public int starPoints;
    public int timer=0,i=0;
    public music speaker=new music();
    public Volume volume = new Volume(true);
    /**
     * Constructor for objects of class loading.
     * 
     */
    public SaveGameProgress(int level,int starPoints)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        this.level=level;
        this.starPoints=starPoints;
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        Greenfoot.setSpeed(50);
        prepare();
    }
    
    public void saveToFile()
    {
        fileRead san=new fileRead();
        if(san.verifyFile("crabWorld-Santos-score.txt"))  san.saveProgress(level,starPoints);
        else      JOptionPane.showMessageDialog(null, "Your progress wasn't saved.\nYou might be running it in CD/DVD.\nPlease save the game in writable drive!", "Alert", JOptionPane.ERROR_MESSAGE);

        level=level+1;
        speaker.sound.stop();
        if(level>10) Greenfoot.setWorld(new GameComplete());
        else Greenfoot.setWorld(new Level(level));
    }

    public void act()
    {
        Greenfoot.setSpeed(50);
        if(timer>200)
        {
            saveToFile();
        }
        timer++;
        
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
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        addObject(volume, 572, 471);
        circleLoading circleloading = new circleLoading();
        addObject(circleloading, 298, 220);
        circleloading.setLocation(287, 220);

        DancingLobster dancinglobster = new DancingLobster();
        addObject(dancinglobster, 289, 206);
        dancinglobster.setLocation(291, 208);
        circleloading.setLocation(287, 241);
        dancinglobster.setLocation(291, 232);
    }
}
