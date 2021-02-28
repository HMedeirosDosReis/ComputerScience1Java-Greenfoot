import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class SortByCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SortByCount extends ActionButton
{
    private AbsorberCount[] counters; //Instance variable that holds all the AbsorberCount objects
    private int currSize;// Instance variable used to keep the size of the array counters 
    /**
     * Constructor for the SortByCount Object.
     * It initializes the array counters to a value of 500 objects and the current 
     * size at 0;
     * Calls the super with the name "Sort by Count" 
     */
    public SortByCount()
    {
        super("Sort by Count" );
        counters = new AbsorberCount[500];
        currSize = 0;
    }
    /**
     * Perform the action whenever the user clicks in the button.
     */
    public void performAction()
    {
        fillArray();//calls the method fillArray()
        sortC();//calls the method sortC()
    }
    /**
     * Swap - it will switch the objec in index1 to the object in index2
     * 
     * @param index1 the index of the first object
     * @param index2 the index of the seccond object
     */
    public void swap(int index1, int index2)
    {
        AbsorberCount temp1 = counters[index1];
        AbsorberCount temp2 = counters[index2];
        counters[index1] = temp2;
        counters[index2] = temp1;
        
    }
    /**
     * Fills the array counters with the objects that are already in the world.
     */
    public void fillArray()
    {
        int index = 0;
	List<AbsorberCount> allCounters = getWorld().getObjects(AbsorberCount.class);
	for(AbsorberCount nextCounter: allCounters)
	{
	    counters[index]= nextCounter;
	    index++;
	}
	currSize=index;
    }
    /**
     * Sorts the array based on the hit count of the Absorber. From the highest 
     * to the lowest.
     */
    public void sortC()
    {
        boolean swapMade;
			
	do
	{
	    swapMade=false;
	    for(int currIndex=0;currIndex<currSize-1;currIndex++)
	    {
	        int counter1 = counters[currIndex].getHitCount();
		int counter2 = counters[currIndex+1].getHitCount();
		if(counter1 < counter2)
		{
		    int newY = counters[currIndex+1].getY();
		    int newY2 = counters[currIndex].getY();
		    counters[currIndex].setLocation(500,newY);
		    counters[currIndex+1].setLocation(500,newY2);
		    swap(currIndex, currIndex+1);
		    swapMade=true; 
		}
	    }
	}
	while(swapMade);
    }
}
