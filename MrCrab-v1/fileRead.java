import java.io.*;
import java.util.*; 
import javax.swing.*;
/**
 * This class can be used to save game progress or to get data from score file.
 */
public class fileRead
{
    /**
     * Creates a file with arraylist of level but with default value.
     */
    public boolean verifyFile(String fileName)
    {
              try
              {
                  File file = new File(fileName);
                  if(!file.exists() || file.length() == 0) 
                  {  
                      file.createNewFile();
                      FileOutputStream fileOut = new FileOutputStream(fileName);
                      ObjectOutputStream out = new ObjectOutputStream(fileOut);
                     
                      iLevel lvl=new iLevel();
                      lvl.setLevel(false,0);
                      
                      ArrayList<iLevel> levelList = new ArrayList<iLevel>(); 
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);
                      levelList.add(lvl);              
                      out.writeObject(levelList);
                      out.close();
                      fileOut.close();
                      return true;
                  }
              }catch(IOException i)
              {
                 JOptionPane.showMessageDialog(null, "Game data file not found or \nIt is saved in read only drive!", "alert", JOptionPane.ERROR_MESSAGE);
                 return false;
              }
              return true;
    }
    
    public void checkFile(String fileName)
    {
        boolean T=false;
        T=verifyFile(fileName);
    }
    
    /**
     * This method is called to read the file and to get the arraylist for further use.
     */
    public ArrayList<iLevel> readFile(String fileName)
    {
          checkFile(fileName);
          ArrayList<iLevel> levelList = new ArrayList<iLevel>();
          try
          {
             FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn);

             levelList = (ArrayList<iLevel>)in.readObject();
             in.close();
             fileIn.close();     
             return levelList;
          }catch(IOException i)
          {
             JOptionPane.showMessageDialog(null, "Game data file not found or \nIt is saved in read only drive!", "alert", JOptionPane.ERROR_MESSAGE);
          }catch(ClassNotFoundException c)
          {
             JOptionPane.showMessageDialog(null, "Sorry data some file is missing.", "alert", JOptionPane.ERROR_MESSAGE);
          }
          return levelList;
    }
    
    /**
     * This method is called to save game progress or to save the points of each level
     * 
     * @param level It is the level the game is at.
     * @param points Points are the bonusPoints which range from 0-3 which is the star in each level.
     */
    public boolean saveProgress(int level,int points)
    {
        String fileName="crabWorld-Santos-score.txt";
        ArrayList<iLevel> levelList=null;
        levelList=readFile(fileName);
        
              if(!(level<=10 && level>=1)) return false;
              try
              {
                 checkFile(fileName); 
                 FileOutputStream fileOut = new FileOutputStream(fileName);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut);
                 
                 level=level-1;
                 iLevel SaveL=new iLevel();
                 SaveL.setLevel(true,points);
                 levelList.set(level,SaveL);  //.setLevel(true,points);
                 out.writeObject(levelList);
                 out.close();
                 fileOut.close();
                 return true;
              }catch(IOException i)
              {
                 JOptionPane.showMessageDialog(null, "File is Read only\nPlease save the game in writable drive!", "alert", JOptionPane.ERROR_MESSAGE);
                 return false;
              }
    }
}