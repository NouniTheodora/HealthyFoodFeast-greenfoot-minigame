import greenfoot.*;

/**
 * FallingFood is an abstract base class for all food items in the game.
 * 
 * It defines the basic falling behavior shared by both HealthyFood and UnhealthyFood.
 * 
 * Every FallingFood object falls down the screen at a certain speed and 
 * is automatically removed if it reaches the bottom of the world.
 * 
 * Subclasses can extend this class to add specific behaviors for different types of food.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class FallingObject extends Actor
{
    protected int speed;

    public FallingObject()
    {
        speed = 2; // Default fall speed
    }

    public void act()
    {
        fall();
        checkBottom();
    }
    
    protected void fall()
    {
        setLocation(getX(), getY() + speed);
    }

    protected void checkBottom()
    {
        if (getY() >= getWorld().getHeight() - 1)
        {
            getWorld().removeObject(this);
        }
    }
}
