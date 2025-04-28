import greenfoot.*;
/**
 * EntryWorld is the entry screen of the Healthy Food Feast game.
 * 
 * It displays the game title, purpose, basic rules, and instructions
 * for the player. The player can read the information and start the game
 * by pressing the [ENTER] key. Once [ENTER] is pressed, the game switches
 * to the main gameplay world (HealthyFoodFeastWorld).
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class EntryWorld extends World
{
    private int blinkCounter = 0;
    private boolean showPressEnter = true;
    
    public EntryWorld()
    {    
        super(800, 600, 1);
        showStartScreen();
    }
    
    private void showStartScreen()
    {
        setBackground("HealthyFoodFeastBackgroundL1.png");
        GreenfootImage bg = getBackground();
        bg.setTransparency(180);
        
        GreenfootImage textPanel = new GreenfootImage(700, 540);
        textPanel.setColor(new Color(255, 255, 255, 180));
        textPanel.fill();

        bg.setColor(Color.BLACK);
        
        bg.drawImage(textPanel, 50, 30);
        
        bg.setFont(new Font("Arial", true, false, 45));
        bg.drawString("Healthy Food Feast", 200, 90);
        
        bg.setFont(new Font("Arial", false, false, 24));
        bg.drawString("You are Chef Fresh, the hero of healthy eating.", 130, 150);
        bg.drawString("Catch healthy foods (fruits and veggies) to gain points.", 110, 180);
        bg.drawString("Avoid junk food like candies, pizza, burgers etc.", 160, 210);

        bg.setFont(new Font("Arial", true, false, 28));
        bg.drawString("Rules:", 110, 270);

        bg.setFont(new Font("Arial", false, false, 22));
        bg.drawString("- Move LEFT and RIGHT with arrow keys.", 130, 310);
        bg.drawString("- Catch healthy food (+10 points/level 1, +20 points/level 2).", 130, 340);
        bg.drawString("- Avoid junk food (lose 1 life).", 130, 370);
        bg.drawString("- You have 3 lives total.", 130, 400);
        bg.drawString("- You have 60 seconds to score as much as you can.", 130, 430);
        bg.drawString("- Level 2 Unlocks at 100 Points (faster food, more junk falling).", 130, 460);
        bg.drawString("- Try to reach the 250 points.", 130, 490);

        if (showPressEnter)
        {
            bg.setFont(new Font("Arial", true, false, 26));
            bg.setColor(Color.BLACK);
            bg.drawString("Press [ENTER] to Start the Feast", 200, 530);
        }
    }
    
    public void act()
    {
        blinkCounter++;
        if (blinkCounter > 20) // Blink every ~0.2 seconds
        {
            showPressEnter = !showPressEnter;
            blinkCounter = 0;
            showStartScreen();
        }

        if (Greenfoot.isKeyDown("enter"))
        {
            ScoreCounter.resetInstance(); // Reset score to 0 points
            TimerCounter.resetInstance(60); // Reset timer to 60 seconds
            Greenfoot.setWorld(new HealthyFoodFeastWorld());
        }
    }
}
