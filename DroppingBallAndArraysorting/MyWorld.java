import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.FileDialog;
import java.io.*;
import java.util.Scanner;

/**
 * World for the "plinko like" game where disks are dropped from
 * the top of the world , hit pins and bounce off of them, and
 * are "absorbed" by scoring units. 
 * 
 * @author Henrique Medeiros Dos Reis
 * @version 12/04/2019
 */
public class MyWorld extends World
{  
    private Score myScore; // Instance variable that holds the current score of the player
    /**
     * Constructor for objects of class MyWorld.
     * -Initiates the variable myScore at 0;
     * -Creates cliclable objects that will allow the user to make actions
     * -Creates a moveble object of type DiskDropper in the world
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        
        super(600, 600, 1);
        
        myScore = new Score();//creates a new objects of type Score 
        addObject(new Load(), 500, 100); // create the button Load
        addObject(new SortByCount(), 500, 50); //create the button Sort by Count
        addObject(new SortByValues(), 500, 75); //create the button Sort by Values
        addObject(myScore, 500, 25); // shows the object in the world
        addObject(new DiskDropper(),200,15);//create the Disk Dropper
        
        // draw an area to place the game score, buttons, and hit counts
        getBackground().setColor(Color.LIGHT_GRAY);
        getBackground().fillRect(400,0,600,600);
    }
    /**
     * Get the current value of the player Score
     * 
     * @return the score value 
     */
    public Score getScore()
    {
        return myScore;
    }


}
