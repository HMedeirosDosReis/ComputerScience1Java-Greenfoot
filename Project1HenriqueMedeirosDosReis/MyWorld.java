import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "Soccer Field" itself, where the game is played
 * 
 * @author Henrique Medeiros Dos Reis
 * @version 10/25/2019
 */
public class MyWorld extends World
{ 
    
    private ScoreBoard results; //Current object that holds the goal, misses and percentage
    /**
     * Construct a new Score board with zero goals and misses
     */
    public ScoreBoard getScoreBoard()
    {
        return results;
    }
    private Shooter kicker;  //Current object that hold the shooter of the game
    /**
     * Contruct a new Shooter object that will play the game 
     */
    public Shooter getShooter()
    {
        return kicker;
    }
    private Goalie niceGoalie;// Current object that hold the Gollie of the game
    /**
     * Create a new Goallie that will try to protect the Goal
     */
    public Goalie getGoalie()
    {
        return niceGoalie;
    }
    public MyWorld()
    {    
        
        super(800, 600, 1); 
        createWorld();
        
    }
    /**
     * Contruct a world with two Goal posts, one goalie, one shooter and one ball
     */
    public void createWorld()
    {
        results = new ScoreBoard();
        kicker = new Shooter();
        niceGoalie = new Goalie();
        addObject(results, 400, 10);
        addObject(new GoalPost(), 250,40);
        addObject(new GoalPost(), 550,40);
        addObject(niceGoalie, 400,40);
        addObject(kicker, 400,300);
        addObject(new Ball(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(301)+125);
        
    }
}
