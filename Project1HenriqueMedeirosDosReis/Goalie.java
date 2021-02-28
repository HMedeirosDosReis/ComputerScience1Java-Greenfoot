import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A goalie that just move back and forth between two goal posts all the time
 * 
 * @author Henrique Medeiros Dos Reis 
 * @version 10/25/2019
 */
public class Goalie extends Actor
{
    private GreenfootImage myImage = getImage(); // Hold the picture of the object in order to be able mirror it
    /**
     * Act - have the goalie just move back and forth between the goalposts
     */
    public void act() 
    {
        move(1);
        GoalPost post = (GoalPost) getOneIntersectingObject(GoalPost.class);
        if(post !=null)
        {
            myImage.mirrorVertically();
            turn(180);
        }
    } 
    
}
