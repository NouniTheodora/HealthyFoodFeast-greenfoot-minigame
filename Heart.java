import greenfoot.*;

/**
 * Heart represents one life of the player.
 * 
 * It can display either a full (red) heart or an empty (outline) heart
 * depending on the player's remaining lives. 
 * The heart image changes to empty when the player loses a life.
 * 
 * This class is used by the LifeCounter to visually represent the number of lives left.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class Heart extends Actor
{
    private GreenfootImage fullHeart = new GreenfootImage("heart_full.png");
    private GreenfootImage emptyHeart = new GreenfootImage("heart_empty.png");
    
    private boolean isFull = true;

    public Heart()
    {
        setImage(fullHeart);
        resize();
    }

    private void resize()
    {
        getImage().scale(30, 20);
    }
    
    public void lose()
    {
        if (isFull)
        {
            setImage(emptyHeart);
            resize();
            isFull = false;
        }
    }
    
    public boolean isFull()
    {
        return isFull;
    }
    
    public void fill()
    {
        isFull = true;
        setImage(new GreenfootImage("heart_full.png"));
        resize();
    }
}
