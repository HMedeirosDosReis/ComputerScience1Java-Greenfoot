import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Keeps track of goals, misses, and percentage for CSC14400
 *    project #1. 
 * 
 * Although you are welcome to modify this class, it is highly
 *    inadvisable to do so. 
 * 
 * @author Stephen Blythe
 * @version 7/2019
 */
public class ScoreBoard extends Actor
{
    private int numGoals;  // number of goals scored
    private int numMisses; // number of missed shots
    
    /** 
     * Initializes ScoreBoard to have zero shots and misses.
     */
    public ScoreBoard()
    {
        numGoals=0;
        numMisses=0; 
    }
    
    // called automatically after a Scoreboard is added to a world
    //   * gives image correct size and then fills the image. 
    protected void addedToWorld(World inWorld)
    {
        // build correct size for iamge based on world width
        setImage(new GreenfootImage(getWorld().getWidth(), 30));
        
        // generate the correct sized font to use. 
        getImage().setFont(getImage().getFont().deriveFont(24));
        
        // fill the image appropriately (see below)
        redraw(); 
    }
    
    // redraws the image for a ScoreBoard based on the current stats
    private void redraw()
    {
        GreenfootImage img = getImage();
        
        // set image background
        img.setColor(Color.GRAY);
        img.fill();
        
        // add in statistice ...
        img.setColor(Color.BLACK);
        img.drawString("Misses:"+numMisses, 100, 25);
        img.drawString("Goals:"+numGoals, 300, 25);
        if (numMisses+numGoals>0)
        {
            int percentage = (int) (100.0*numGoals/(numMisses+numGoals) );
            img.drawString("PCT:"+percentage, 600, 25);
        }
        else
            img.drawString("PCT: ---", 600, 25);

    }

    /** 
     * Adds a single missed goal to the stats
     */
    public void addMiss()
    {
        numMisses++;
        redraw();
    }
    
    /**
     * Adds a made goal to the stats
     */
    public void addGoal()
    {
        numGoals++;
        redraw();
    }
}
