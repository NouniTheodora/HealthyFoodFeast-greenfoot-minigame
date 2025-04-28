import greenfoot.*;

/**
 * HealthyFoodFeastWorld is the main gameplay world for the Healthy Food Feast game.
 * 
 * It manages the player (Chef), falling objects (HealthyFood, UnhealthyFood, HeartBonus),
 * score, lives, timer, and level progression.
 * 
 * The world starts at Level 1, where the player collects healthy foods to earn points,
 * and progresses to Level 2 when a score threshold is reached (100), increasing difficulty
 * by throwing faster the food with more junks.
 * 
 * The world also handles transitions to the Game Over and You Win screens based on 
 * the player's performance.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class HealthyFoodFeastWorld extends World
{
    private LifeCounter lifeCounter;
    private int spawnTimer = 0;
    private int spawnRate = 60;
    private ScoreCounter scoreCounter;
    private int level = 1;
    private static HealthyFoodFeastWorld instance;
    private TimerCounter timerCounter;

    public HealthyFoodFeastWorld()
    {    
        super(800, 600, 1);
        setBackground("HealthyFoodFeastBackgroundL1.png");
        
        Chef chef = new Chef();
        addObject(chef, getWidth() / 2, 550);
        
        lifeCounter = new LifeCounter();
        addObject(lifeCounter, 0, 0);
        
        scoreCounter = ScoreCounter.getInstance();
        addObject(scoreCounter, 730, 30);
        
        instance = this;
        
        timerCounter = TimerCounter.getInstance();
        addObject(timerCounter, 400, 30);
    }
    
    public void act()
    {
        if (scoreCounter.getScore() >= 250)
        {
            Greenfoot.setWorld(new YouWinScreen(scoreCounter.getScore()));
            return;
        }
    
        spawnFood();
        
        if (scoreCounter.getScore() >= 100 && level == 1)
        {
            levelUp();
        }
    }
    
    private void spawnFood()
    {
        spawnTimer++;
    
        if (spawnTimer >= spawnRate)    // Every 60 frames (~1 second) (LEVEL 1)
                                        // every 40 frames (LEVEL 2)
        {
            spawnTimer = 0;
            int random = Greenfoot.getRandomNumber(100); // Random number 0-99
            
            // 5% chance to spawn a HeartBonus first
            if (random < 5)
            {
                HeartBonus heart = new HeartBonus();
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = 0;
                addObject(heart, x, y);
            }
            else
            {
                if (level == 1)
                {
                    if (random < 70)
                    {
                        spawnHealthy();
                        
                    }
                    else
                    {
                        spawnUnhealthy();
                        
                    }
                } else if (level == 2)
                {
                    if (random < 50)
                    {
                        spawnHealthy();
                    }
                    else
                    {
                        spawnUnhealthy();
                    }                
                }
            }
        }
    }
    
    private void spawnHealthy() {
        HealthyFood food = new HealthyFood();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(food, x, y);
    }
    
    private void spawnUnhealthy() {
        UnhealthyFood junk = new UnhealthyFood();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = 0;
        addObject(junk, x, y);
    }
    
    public void loseLife()
    {
        lifeCounter.loseLife();
        
        if (lifeCounter.getLives() == 0)
        {
            Greenfoot.setWorld(new GameOverScreen(scoreCounter.getScore()));
        }
    }
    
    public void addScore(int points)
    {
        scoreCounter.addScore(points);
    }
    
    private void levelUp()
    {
        Greenfoot.playSound("level_up.wav");
        
        level = 2;
        spawnRate = 40;

        setBackground("HealthyFoodFeastBackgroundL2.png");
        
        GreenfootImage bg = getBackground();
        
        GreenfootImage panel = new GreenfootImage(300, 100);
        panel.setColor(new Color(255, 255, 255, 220)); // White with some transparency
        panel.fill();
    
        panel.setColor(Color.BLACK);
        panel.setFont(new Font("Arial", true, false, 36));
        panel.drawString("Level 2!", 80, 60);
    
        bg.drawImage(panel, (getWidth() - panel.getWidth()) / 2, (getHeight() - panel.getHeight()) / 2);
    
        Greenfoot.delay(50);
        
        setBackground("HealthyFoodFeastBackgroundL2.png");
    }
    
    public static HealthyFoodFeastWorld getWorldInstance()
    {
        return instance;
    }
    
    public int getScore()
    {
        return scoreCounter.getScore();
    }
    
    public int getPointsPerLevel()
    {
        return (level == 1) ? 10 : 20;
    }
    
    public void gainLife()
    {
        lifeCounter.gainLife();
    }
}
