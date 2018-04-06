import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Credits page is the credit window.
 * 
 * @author Santosh Gurung 
 * @version 1.0
 */
public class Credits extends World
{
    public int i=0;
    public music speaker=new music();
    public Volume volume = new Volume(true);
    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Worm worm = new Worm();
        addObject(worm, 286, 272);
        Worm worm2 = new Worm();
        addObject(worm2, 226, 285);
        worm2.setLocation(223, 281);
        DancingCrab dancingcrab = new DancingCrab();
        addObject(dancingcrab, 300, 188);
        dancingcrab.setLocation(300, 192);
        homeButton homebutton = new homeButton();
        addObject(homebutton, 422, 187);

        dancingcrab.setLocation(312, 186);
        homebutton.setLocation(434, 111);
        addObject(volume, 572, 471);
    }
    
    /**
     * It makes the sound run on time after the form or Credits window is loaded.
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
