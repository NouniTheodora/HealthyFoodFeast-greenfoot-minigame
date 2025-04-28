import greenfoot.*;

/**
 * TimerCounter manages the countdown timer during the game.
 * 
 * The timer starts from a predefined number of seconds and decreases by one every real second.
 * 
 * When the timer reaches zero, the game checks the player's progress:
 * - If the player is still in Level 1, the Game Over screen is shown.
 * - If the player is in Level 2, the outcome depends on the final score (Win or Game Over).
 * 
 * TimerCounter is designed as a singleton to ensure only one timer instance exists during gameplay.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class TimerCounter extends Actor
{
    private static TimerCounter instance;

    private int timeLeft;
    private int frameCounter;

    private TimerCounter(int startTime)
    {
        timeLeft = startTime;
        frameCounter = 0;
        updateImage();
    }

    public static TimerCounter getInstance()
    {
        if (instance == null)
        {
            instance = new TimerCounter(60); // default 60 sec
        }
        return instance;
    }

    public static void resetInstance(int startTime)
    {
        instance = new TimerCounter(startTime);
    }

    public void act()
    {
        frameCounter++;
        if (frameCounter >= 60)
        {
            frameCounter = 0;
            timeLeft--;
            updateImage();

            if (timeLeft <= 0)
            {
                timeLeft = 0;
                Greenfoot.setWorld(new GameOverScreen(HealthyFoodFeastWorld.getWorldInstance().getScore()));
            }
        }
    }

    private void updateImage()
    {
        setImage(new GreenfootImage("Time: " + timeLeft, 24, Color.BLACK, new Color(0,0,0,0)));
    }
}
