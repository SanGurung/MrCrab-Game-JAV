import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*; 
import javax.swing.*;
/**
 * Level Board
 * 
 * @author Santosh Gurung
 * @version 1.2
 */
public class levelBoard extends World
{
    int i=0;
    music speaker=new music();
    Volume volume = new Volume(true);
    public fileRead f=new fileRead();
    public boolean verified=false;
    public ArrayList<iLevel> fileArrayList=new ArrayList<iLevel>();
    /**
     * Constructor for objects of class levelBoard.
     * 
     */
    public levelBoard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        String fileName="crabWorld-Santos-score.txt";
        speaker.sound = new GreenfootSound("zero9sound-arcade-game-demo.mp3");
        if(f.verifyFile(fileName))  
        {
            verified=true;
            fileArrayList=(ArrayList<iLevel>)f.readFile(fileName);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Could not load data!\nYou might be running it in CD/DVD.\nPlease save the game in writable drive!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        //This code could be written in different way using for loop and array.
        ringLevelButton ringlevelbutton1 = new ringLevelButton(false,1);
        ringLevelButton ringlevelbutton2 = new ringLevelButton(false,2);
        ringLevelButton ringlevelbutton3 = new ringLevelButton(false,3);
        ringLevelButton ringlevelbutton4 = new ringLevelButton(false,4);
        ringLevelButton ringlevelbutton5 = new ringLevelButton(false,5);
        ringLevelButton ringlevelbutton6 = new ringLevelButton(false,6);
        ringLevelButton ringlevelbutton7 = new ringLevelButton(false,7);
        ringLevelButton ringlevelbutton8 = new ringLevelButton(false,8);
        ringLevelButton ringlevelbutton9 = new ringLevelButton(false,9);
        ringLevelButton ringlevelbutton10 = new ringLevelButton(false,10);
        
        Star star1 = new Star(0);
        Star star2 = new Star(0);
        Star star3 = new Star(0);
        Star star4 = new Star(0);
        Star star5 = new Star(0);
        Star star6 = new Star(0);
        Star star7 = new Star(0);
        Star star8 = new Star(0);
        Star star9 = new Star(0);
        Star star10 = new Star(0);

        if(verified)
        {
            ringlevelbutton1 = new ringLevelButton(fileArrayList.get(0).isPlayed(),1);
            ringlevelbutton2 = new ringLevelButton(fileArrayList.get(1).isPlayed(),2);
            ringlevelbutton3 = new ringLevelButton(fileArrayList.get(2).isPlayed(),3);
            ringlevelbutton4 = new ringLevelButton(fileArrayList.get(3).isPlayed(),4);
            ringlevelbutton5 = new ringLevelButton(fileArrayList.get(4).isPlayed(),5);
            ringlevelbutton6 = new ringLevelButton(fileArrayList.get(5).isPlayed(),6);
            ringlevelbutton7 = new ringLevelButton(fileArrayList.get(6).isPlayed(),7);
            ringlevelbutton8 = new ringLevelButton(fileArrayList.get(7).isPlayed(),8);
            ringlevelbutton9 = new ringLevelButton(fileArrayList.get(8).isPlayed(),9);
            ringlevelbutton10 = new ringLevelButton(fileArrayList.get(9).isPlayed(),10);

            
            star1 = new Star(fileArrayList.get(0).getPointsAchieved());
            star2 = new Star(fileArrayList.get(1).getPointsAchieved());
            star3 = new Star(fileArrayList.get(2).getPointsAchieved());
            star4 = new Star(fileArrayList.get(3).getPointsAchieved());
            star5 = new Star(fileArrayList.get(4).getPointsAchieved());
            star6 = new Star(fileArrayList.get(5).getPointsAchieved());
            star7 = new Star(fileArrayList.get(6).getPointsAchieved());
            star8 = new Star(fileArrayList.get(7).getPointsAchieved());
            star9 = new Star(fileArrayList.get(8).getPointsAchieved());
            star10 = new Star(fileArrayList.get(9).getPointsAchieved());
        }

        addObject(ringlevelbutton1, 54, 446);
        addObject(ringlevelbutton2, 162, 335);
        addObject(ringlevelbutton3, 358, 446);
        addObject(ringlevelbutton4, 146, 241);
        addObject(ringlevelbutton5, 301, 281);
        addObject(ringlevelbutton6, 461, 392);
        addObject(ringlevelbutton7, 417, 288);
        addObject(ringlevelbutton8, 552, 281);
        addObject(ringlevelbutton9, 396, 160);
        addObject(ringlevelbutton10, 539, 81);

        ringlevelbutton1.setLocation(48, 439);
        ringlevelbutton2.setLocation(155, 327);       
        ringlevelbutton3.setLocation(351, 439);
        ringlevelbutton4.setLocation(152, 242);
        ringlevelbutton5.setLocation(300, 286);
        ringlevelbutton6.setLocation(453, 386);
        ringlevelbutton7.setLocation(409, 286);
        ringlevelbutton8.setLocation(551, 279);
        ringlevelbutton9.setLocation(397, 162);
        ringlevelbutton10.setLocation(542, 90);
        
        
        addObject(volume, 572, 471);
        homeButton homebutton = new homeButton();
        addObject(homebutton, 43, 357);
        homebutton.setLocation(554, 443);
        volume.setLocation(25, 22);

        
        
        
        
        addObject(star1, 163, 361);
        addObject(star2, 160, 362);
        addObject(star3, 361, 494);
        addObject(star4, 154, 218);
        addObject(star5, 306, 254);
        addObject(star6, 461, 362);
        addObject(star7, 416, 265);
        addObject(star8, 562, 332);
        addObject(star9, 405, 195);
        addObject(star10, 539, 123);
        
        star1.setLocation(45, 408);       
        star2.setLocation(153, 357); 
        star3.setLocation(351, 411);
        star4.setLocation(150, 285);      
        star5.setLocation(299, 255);
        star6.setLocation(454, 429);
        star7.setLocation(409, 314);
        star8.setLocation(551, 325);
        star9.setLocation(399, 191);
        star10.setLocation(543, 118);
    }
    
    public void stopSound()
    {
        speaker.sound.stop();
    }
    /**
     * It makes the sound run on time after the form or levelBoard window is loaded.
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
