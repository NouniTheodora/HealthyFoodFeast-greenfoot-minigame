import greenfoot.*;

/**
 * GameOverScreen is displayed when the player loses all lives or when time runs out
 * before reaching the winning score in Healthy Food Feast.
 * 
 * It shows the "Game Over" message, displays the final score, and offers an option
 * to restart the game by pressing the [ENTER] key.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class GameOverScreen extends World
{

    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen(int finalScore)
    {    
        super(800, 600, 1);
        showGameOver(finalScore);
        
        Greenfoot.playSound("game_over.wav");
    }
    
    private void showGameOver(int finalScore)
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
        bg.drawString("Game Over", 260, 250);

        bg.setFont(new Font("Arial", false, false, 32));
        bg.drawString("Your Score: " + finalScore, 280, 320);

        bg.setFont(new Font("Arial", false, false, 24));
        bg.drawString("Press [Enter] to Restart", 270, 380);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new EntryWorld());
        }
    }
}
