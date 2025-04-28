import greenfoot.*;

/**
 * YouWinScreen is displayed when the player reaches the winning score in Healthy Food Feast.
 * 
 * The screen appears immediately when the player collects enough points 
 * (250 points or more) during gameplay. Pressing the [ENTER] key from this screen 
 * resets the game and returns to the EntryWorld.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class YouWinScreen extends World
{

    public YouWinScreen(int finalScore)
    {    
        super(800, 600, 1);
        showWinScreen(finalScore);
        
        Greenfoot.playSound("win.wav");
    }
    
    private void showWinScreen(int finalScore)
    {
        setBackground("HealthyFoodFeastBackgroundL1.png");
        GreenfootImage bg = getBackground();
        bg.setTransparency(200);

        GreenfootImage panel = new GreenfootImage(500, 300);
        panel.setColor(new Color(255, 255, 255, 220));
        panel.fill();

        bg.drawImage(panel, 150, 150);

        bg.setColor(Color.BLACK);
        bg.setFont(new Font("Arial", true, false, 48));
        bg.drawString("You Win!", 280, 250);

        bg.setFont(new Font("Arial", false, false, 32));
        bg.drawString("Your Score: " + finalScore, 280, 320);

        bg.setFont(new Font("Arial", false, false, 24));
        bg.drawString("Press [ENTER] to Restart", 260, 380);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            TimerCounter.resetInstance(60);
            ScoreCounter.resetInstance();
            Greenfoot.setWorld(new EntryWorld());
        }
    }
}
