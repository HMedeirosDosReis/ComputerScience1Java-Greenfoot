import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The "player" which will be controlled by the person who is play and is trying to score goals
 * 
 * @author Henrique Medeiros Dos Reis
 * @version 10/25/2019
 */
public class Shooter extends Actor
{
    private int checker;
    /**
     * Act - allows the player to move and kicks the ball whenever he touches it
     *   
     */
    public void addBomb()
    {
        checker =1;
    }
    public void removeBomb()
    {
        checker = 0;
    }
    public int bombState()
    {
        return checker;
    }
    public void act() 
    {
        if (Greenfoot.isKeyDown("up"))
            setLocation(getX(), getY()-1);
        if (Greenfoot.isKeyDown("down"))
            setLocation(getX(), getY()+1);
        if (Greenfoot.isKeyDown("right"))
        {
            int cr = Greenfoot.getRandomNumber(2);
            //System.out.print(cr);
            setLocation(getX()+1, getY());
        }
        if (Greenfoot.isKeyDown("left"))
            setLocation(getX()-1, getY());
        Ball kicked = (Ball) getOneIntersectingObject(Ball.class);
        if(kicked!=null)
            kicked.getKicked();
        test newTEST = new test();
        if(Greenfoot.isKeyDown("b" )&&bombState()==0)
        {
            World myWorld = getWorld();
            myWorld.addObject(newTEST, 100,100);
            addBomb();
        }
        if(Greenfoot.isKeyDown("n"))
        {
            removeBomb();
            World myWorld = getWorld();
           
        }
    }    
}
