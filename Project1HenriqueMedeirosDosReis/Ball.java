import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
                
/**
 * The ball in the soccer game
 * 
 * @author Henrique Medeiros Dos Reis 
 * @version 10/25/2019
 */
public class Ball extends Actor
{
    
    private int kicked; // current value that shows if the ball has been kicked 
    /**
     * sets the value of kicked to 1 in order to show that the ball was kicked
     */
    public int getKicked()
    {
        return kicked = 1;
    }  
       
    /**
     *  1-Keeps the Ball moving, if it was kicked 
     *  2-Verify if it is touching anything 
     *      I- If the ball is thouching the scoreboard between the goalposts, it adds a goal to the scoreboard
     *      II- If touching the goalie, it adds a miss to the scoreboard
     *      III- If touching the goalpost, it adds a miss to the scoreboard
     *      IV- If it touches any side besides the top, it adds a miss to the scoreboard
     */
    public void act() 
    {   
        MyWorld myWorld = (MyWorld) getWorld();
        ScoreBoard myScore = myWorld.getScoreBoard();
        Shooter myShooter = myWorld.getShooter();
        GoalPost posts = (GoalPost) getOneIntersectingObject(GoalPost.class);
        Goalie goalie = (Goalie) getOneIntersectingObject(Goalie.class);
        
        int worldWidth = myWorld.getWidth();
        int worldHeight = myWorld.getHeight();
        
        
        if(kicked == 1)
        {
            int deltaX = getX() - myShooter.getX();
            int deltaY = myShooter.getY() - getY();
            
            double tanValue = deltaY / deltaX;
            
            double degrees = Math.atan(tanValue);
            degrees = Math.toDegrees(degrees);
            if(deltaX < 0)
            {
                degrees = degrees + 180;
            }
            degrees = -degrees;
            setRotation((int)degrees);
            move(1);
        }
        if((getX()>=worldWidth-1 || getX() <= 0) || (getY()>= worldHeight-1 || getY() <= 0))  
        { 
            myScore.addMiss();//missed + reset the ball
            myWorld.removeObject(this);
            myWorld.addObject(new Ball(), Greenfoot.getRandomNumber(myWorld.getWidth()),Greenfoot.getRandomNumber(301)+125);
        }
        else if(posts!=null || goalie!=null)
        {
            myScore.addMiss();//missed + reset the ball
            myWorld.removeObject(this);
            myWorld.addObject(new Ball(), Greenfoot.getRandomNumber(myWorld.getWidth()),Greenfoot.getRandomNumber(301)+125);
        }
        else if(getY() <= 40 && (getX()<=550 && getX() >= 250))
        {
            myScore.addGoal();// goal + reset the ball
            myWorld.removeObject(this);
            myWorld.addObject(new Ball(), Greenfoot.getRandomNumber(myWorld.getWidth()),Greenfoot.getRandomNumber(301)+125);
        }
    }    
}
