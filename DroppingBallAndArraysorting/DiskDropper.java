import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Rectangle that can move left (left arrow), right (right arrow),
 *   and/or drop disks (space bar). 
 * 
 * @author Stephen Blythe
 * @version 11/2019
 */
public class DiskDropper extends Actor
{
    public static final int DROPPER_SIZE = 25; // dimension of image
    
    /**
     * COnstructor that simply draws the image for a disk dropper
     */
    public DiskDropper()
    {
        redraw(); //yeah, go ahead and draw the image
    }

    // draws gray rectangle of correct size for image
    private void redraw()
    {
        // get current image and adjust size if needed. 
        GreenfootImage img=getImage();        
        if  (img==null || 
             img.getWidth()!=DROPPER_SIZE || 
             img.getHeight()!=DROPPER_SIZE)
        {
            img = new GreenfootImage(DROPPER_SIZE, DROPPER_SIZE);
        }
        
        // go ahead and fill image with grat.
        img.setColor(Color.GRAY);
        img.fill();
      
        // use gray box we just created. 
        setImage(img);
    }
    
    /**
     * Allows us to move left or right one pixel at a time, stopping
     *   at edges of playing area. Also allows a new disk to be added.
     */
    public void act() 
    {
        List<Disk> oneDisk = getWorld().getObjects(Disk.class);
        if(Greenfoot.isKeyDown("space") && (oneDisk.size() == 0))
        {
            getWorld().addObject(new Disk(getX(),getY()), getX(), getY());
        }
        if((getX()>=15) && (getX()<=385))
        {
            if (Greenfoot.isKeyDown("right"))
            setLocation(getX()+1, getY());
            if (Greenfoot.isKeyDown("left"))
            setLocation(getX()-1, getY());
        }
        else if(getX()<=15)
        {
            setLocation(getX()+1,getY());
        }
        else if(getX()>=385)
        {
            setLocation(getX()-1,getY());
        }
    }    
}
