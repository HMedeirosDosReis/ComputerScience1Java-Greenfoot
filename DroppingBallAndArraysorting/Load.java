import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.awt.FileDialog;
/**
 * A clickable button that will read a file that the user will choose and 
 * add the correct objects read from the file to the world.
 * 
 * @author Henrique Medeiros Dos Reis
 * @version 12/04/2019
 */
public class Load extends ActionButton
{
    /**
     * Contructor for the Load. Simply calls the super class and write "Load" 
     * in the button.
     */
    public Load()
    {
        super("Load" );
    }
    /**
     * Once the user presses the buton load this method will read the file,
     * and add the objects in the world.
     */
    public void performAction()
    {
        // variable of the first position of the first object
        int countY = 135; 
        //read the file
        FileDialog fd = null;
	fd = new FileDialog(fd, "Pick a File", FileDialog.LOAD);
	fd.setVisible(true);
	File myFile = new File(fd.getDirectory() + fd.getFile());
	//make sure that the file was chosen 
	Scanner myScanner = null;
	try
	{
	    myScanner = new Scanner(myFile);
	}
	catch(FileNotFoundException fnfe)
	{
	    return;
	}
	//It keeps reading the file until there is nothing left 
	while(myScanner.hasNext())
	{
	    String str = myScanner.next();
	    //checks to see what kind of object should be added to the world
	    if(str.equalsIgnoreCase("pin"))
	    {
	        int pinX = myScanner.nextInt();//read the x value from the file
	        int pinY = myScanner.nextInt();//read the y value from the file
	        getWorld().addObject(new Pin(), pinX, pinY);//add the object to the world in the position that the file had 
	    }
	    else if(str.equalsIgnoreCase("absorber"))
	    {
	        int pointValue = myScanner.nextInt();
	        int abX = myScanner.nextInt();
	        int abY = myScanner.nextInt();
	        int counter = 0; //variable to check the absorbers with the same point value
	        getWorld().addObject(new Absorber(pointValue), abX, abY);
	        List<AbsorberCount> allCounters = getWorld().getObjects(AbsorberCount.class);
	        for(AbsorberCount nextCounter: allCounters)
	        {
	            if(nextCounter.getScoreValue() == pointValue)
	            {
	                counter =1;
	            }
	            
	        }
	        //checks if there is not an object with the same point value in the world
	        if(counter !=1)
	        {
	            getWorld().addObject(new AbsorberCount(pointValue), 500,countY);
	            countY = countY + 25;
	        }
	    }
	    
	}
    }
}
