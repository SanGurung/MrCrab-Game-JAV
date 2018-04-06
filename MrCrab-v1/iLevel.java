
/**
 * This class is to store the CrabWorld game level details.
 * 
 * @author  Santosh Gurung 
 * @version 1.0
 */
public class iLevel implements java.io.Serializable
{
    private boolean played=false;
    private int pointsAchieved=0;
    public iLevel(){
        
    }
    
    public void setLevel(boolean played,int starsPoints)
    {
        this.played=played;
        this.pointsAchieved=starsPoints;
    }
    /**
     * This method tell the caller that if the level is played already.
     */
    public boolean isPlayed()
    {
        return this.played;
    }
    
    /**
     * Points achieved in the game which is 0-3 stars
     */
    public int getPointsAchieved()
    {
        return this.pointsAchieved;
    }
}
