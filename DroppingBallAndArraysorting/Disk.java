import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Double;
/**
 * The Disk that drops down the screen. Until it hits a pin.
 * 
 * @author Henrique Medeiros Dos Reis
 * @version 12/04/2019
 */
public class Disk extends Actor
{
    private double xSpeed; //Current value of the X velocity
    private double ySpeed; //Current value of the X velocity
    private double xLocation; //curent x position
    private double yLocation; //curent y position
    public static final int DISK_SIZE = 20; // the diameter of a disk
    
    /**
     * Constructor for Disk in the x and y position in the world. With a speed
     * of zero in both x and y.
     * 
     * @Param xLoc X location where the disk should be created 
     * @Param yLoc Y location where the disk should be created
     */
    public Disk(double xLoc, double yLoc)
    {
        xSpeed = 0;
        ySpeed = 0;
        xLocation = xLoc;
        yLocation = yLoc;
        redraw();  // draw the disk
    }
    
    // draw a red disk for our image 
    private void redraw()
    {
        // get the current image, and if it is not the correct
        // size, redraw it. 
        GreenfootImage img=getImage();       
        if  (img==null || 
             img.getWidth()!=DISK_SIZE || 
             img.getHeight()!=DISK_SIZE)
        {
            img = new GreenfootImage(DISK_SIZE, 
                                     DISK_SIZE);
        }
        
        // draw a red disk
        img.setColor(Color.RED);
        img.fillOval(0,0,DISK_SIZE,DISK_SIZE);
        
        // use the new image
        setImage(img);
    }
    
    /**
     *  a Disk that falls, bounce off pins and walls, and is absorbed by 
     *    Absorber to get game points
     */
    public void act() 
    { 
        MyWorld myWorld = (MyWorld) getWorld();
        Score myScore = myWorld.getScore();
        Absorber abs = (Absorber) getOneIntersectingObject(Absorber.class);
        Pin pins = (Pin) getOneIntersectingObject(Pin.class);
        if(abs != null)
        {
            
            int score = abs.getScoreValue();
            myScore.addTo(score);
            List<AbsorberCount> allCounters = getWorld().getObjects(AbsorberCount.class);
            for(AbsorberCount nextCounter: allCounters)
            {
                if(score == nextCounter.getScoreValue())
                {
                    nextCounter.incHits();
                }
            }
            getWorld().removeObject(this);
        }
        else if(getY() >= getWorld().getHeight()-1)
        {
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            bouceOff();
        }
        else if(getX() >= 399)
        {
            bouceOff();
        }
        else if(pins != null)
        {
            
            double distance = Math.sqrt((pins.getX()-getX())*(pins.getX()-getX())+
                                        (pins.getY()-getY())*(pins.getY()-getY()));
            if(distance < 12.6)
            {
                changeYSpeed();
                double xDist = getX() - pins.getX();
                if(Math.abs(xDist)>0.01)
                {
                    changeXSpeed(xDist);
                }
                else if(Math.abs(xDist)<=0.01)
                {
                    pickRandomXSpeed();
                }
                
            }
        }
        addSpeeds();
        gravity();
        setLocation(getNewX(),getNewY());
    }
    /**
     * change the x speed to the opposite side 
     */
    public void bouceOff()
    {
        xSpeed = -xSpeed;
    }
    /**
     *  change the y speed based on how fast the disk was when hit a pin
     */
    public void changeYSpeed()
    {
        ySpeed = -ySpeed*4/10;
    }
    /**
     *  change the x speed based in the distance from the pin hitted
     *  
     *  @param xDistance the distance from the pin and the disk
     */
    public void changeXSpeed(double xDistance)
    {
        xSpeed = 0.2 * (Math.abs(xDistance)/xDistance);
    }
    /**
     *  get a random int between 0 and 1, then set the x speed to either 0.2
     *  or -0.2 based on the random number picked.
     */
    public void pickRandomXSpeed()
    {
        int random = Greenfoot.getRandomNumber(2);
        double newXSp;
        if(random == 0)
        {
            newXSp = 0.2;
        }
        else if(random == 1);
        {
            newXSp = -0.2;
        }
        xSpeed = newXSp;
    }
    /**
     * Add the current x and y speeds to the x and y current location
     */
    public void addSpeeds()
    {
        xLocation += xSpeed;
        yLocation += ySpeed;
    }
    /**
     * simulates the gravity adding a small number to the y Speed.
     */
    private void gravity()
    {
        ySpeed += 0.01;
    }
    /**
     * get the current x Location, transformed into an int
     * 
     * @return xLocation
     */
    public int getNewX()
    {
        return (int) xLocation;
    }
    /**
     * get the current y Location, transformed into an int
     * 
     * @return yLocation
     */
    public int getNewY()
    {
        return (int) yLocation;
    }
    
    
}
