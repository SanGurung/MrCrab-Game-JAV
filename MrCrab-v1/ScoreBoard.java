import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author Santosh Gurung
 * @version 2.0
 */
public class ScoreBoard extends World
{
    public int level=1,playingTime=0,i=0;
    public music speaker=new music();
    public Volume volume = new Volume(true);
    public ScoreBoard()
    {
        super(600, 500, 1); 
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        prepare();
    }


    /**
     * Constructor for objects of class ScoreBoard.
     * 
     */
    public ScoreBoard(int level,int bonusPointer)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        this.level=level;
        playingTime=bonusPointer;
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        DancingLobster dancinglobster = new DancingLobster();
        addObject(dancinglobster, 299, 158);
        dancinglobster.setLocation(296, 150);
        

        addObject(volume, 572, 471);

        int stars=1,firstScore=0,secondScore=0,thirdScore=0;
        if(level==1){
            firstScore=750;
            secondScore=900;
            thirdScore=1200;
        }
        else if(level==2){
            firstScore=1350;
            secondScore=1600;
            thirdScore=1800;
        }
        else if(level==3){
            firstScore=1480;
            secondScore=1600;
            thirdScore=1800;
        }
        else if(level==4){
            firstScore=1570;
            secondScore=1800;
            thirdScore=2000;
        }
        else if(level==5){
            firstScore=2200;
            secondScore=2500;
            thirdScore=2800;
        }
        else if(level==6){
            firstScore=2900;
            secondScore=3200;
            thirdScore=3400;
        }
        else if(level==7){
            firstScore=2900;
            secondScore=3300;
            thirdScore=3600;
        }
        else if(level==8){
            firstScore=3000;
            secondScore=3400;
            thirdScore=3600;
        }
        else if(level==9){
            firstScore=3300;
            secondScore=3500;
            thirdScore=3600;
        }
        else if(level==10){
            firstScore=2500;
            secondScore=2900;
            thirdScore=3200;
        }
        else
        {
            firstScore=750;
            secondScore=900;
            thirdScore=1200;
        }

        if(playingTime<=firstScore) stars=3;
        else if(playingTime<=secondScore) stars=2;
        else if(playingTime<=thirdScore) stars=1;
        else stars=0;

        ratingStar ratingstar1;
        ratingStar ratingstar2;
        ratingStar ratingstar3;
        if(stars>=3)
        {
            ratingstar1 = new ratingStar(1);
            ratingstar2 = new ratingStar(1);
            ratingstar3 = new ratingStar(1);
        }
        else if(stars==2)
        {
            ratingstar1 = new ratingStar(1);
            ratingstar2 = new ratingStar(1);
            ratingstar3 = new ratingStar(0);
        }
        else if(stars==1)
        {
            ratingstar1 = new ratingStar(1);
            ratingstar2 = new ratingStar(0);
            ratingstar3 = new ratingStar(0);
        }
        else
        {
            ratingstar1 = new ratingStar(0);
            ratingstar2 = new ratingStar(0);
            ratingstar3 = new ratingStar(0);
        }

        nextButton nextbutton = new nextButton(level,stars);
        addObject(nextbutton, 383, 354);
        nextbutton.setLocation(351, 375);
        
        addObject(ratingstar1, 198, 288);
        addObject(ratingstar2, 292, 294);
        addObject(ratingstar3, 382, 298);

        ratingstar2.setLocation(298, 287);
        ratingstar3.setLocation(388, 288);
        homeButton homebutton = new homeButton();
        addObject(homebutton, 248, 369);
        homebutton.setLocation(251, 375);
        nextbutton.setLocation(350, 378);
    }
    
    /**
     * It makes the sound run on time after the form or ScoreBoard window is loaded.
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
