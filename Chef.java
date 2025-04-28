import greenfoot.*;

/**
 * Chef is the player's character in the Healthy Food Feast game.
 * 
 * The Chef can move left and right using the keyboard to catch falling HealthyFood items
 * and avoid UnhealthyFood items. Catching HealthyFood increases the player's score, 
 * while touching UnhealthyFood causes the player to lose a life.
 * 
 * The Chef's animations change based on movement direction and interactions 
 * (moving left, right, standing still).
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class Chef extends Actor
{
    private GreenfootImage[] walkRightFrames;
    private GreenfootImage[] walkLeftFrames;
    private GreenfootImage standStillFrame;
    
    private int animationCounter = 0;
    private int frameIndex = 0;
    
    public Chef()
    {
        prepareImages();
        setImage(standStillFrame);
    }
    
    private void prepareImages()
    {
        GreenfootImage spriteSheet = new GreenfootImage("mouse-chef.png");
        
        int frameWidth = spriteSheet.getWidth() / 3;
        int frameHeight = spriteSheet.getHeight() / 4;

        walkRightFrames = new GreenfootImage[3];
        for (int i = 0; i < 3; i++)
        {
            walkRightFrames[i] = new GreenfootImage(frameWidth, frameHeight);
            walkRightFrames[i].drawImage(spriteSheet, -i * frameWidth, -frameHeight);
            
            walkRightFrames[i].scale(frameWidth * 2, frameHeight * 2);
        }
        
        walkLeftFrames = new GreenfootImage[3];
        for (int i = 0; i < 3; i++)
        {
            walkLeftFrames[i] = new GreenfootImage(frameWidth, frameHeight);
            walkLeftFrames[i].drawImage(spriteSheet, -i * frameWidth, -frameHeight * 3);
            
            walkLeftFrames[i].scale(frameWidth * 2, frameHeight * 2);
        }
        
        standStillFrame = new GreenfootImage(frameWidth, frameHeight);
        standStillFrame.drawImage(spriteSheet, -frameWidth, -frameHeight * 2);
        
        standStillFrame.scale(frameWidth * 2, frameHeight * 2);
    }
    
    public void act()
    {
        handleMovement();
        checkFoodCollision();
    }
    
    private void handleMovement()
    {
        boolean moving = false;
        
        if (Greenfoot.isKeyDown("right"))
        {
            move(4);
            animate(walkRightFrames);
            moving = true;
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            move(-4);
            animate(walkLeftFrames);
            moving = true;
        }
        
        if (!moving)
        {
            setImage(standStillFrame);
        }
    }
    
    private void animate(GreenfootImage[] frames)
    {
        animationCounter++;
        if (animationCounter >= 10)
        {
            frameIndex = (frameIndex + 1) % frames.length;
            setImage(frames[frameIndex]);
            animationCounter = 0;
        }
    }
    
    private void checkFoodCollision()
    {
        HealthyFood healthy = (HealthyFood)getOneIntersectingObject(HealthyFood.class);
        if (healthy != null)
        {
            getWorld().removeObject(healthy);
            HealthyFoodFeastWorld world = (HealthyFoodFeastWorld)getWorld();
            
            world.addScore(world.getPointsPerLevel());
            
            Greenfoot.playSound("healthy_food.wav");
        }
    
        UnhealthyFood unhealthy = (UnhealthyFood)getOneIntersectingObject(UnhealthyFood.class);
        if (unhealthy != null)
        {
            getWorld().removeObject(unhealthy);
    
            HealthyFoodFeastWorld world = (HealthyFoodFeastWorld)getWorld();
            world.loseLife();
            
            Greenfoot.playSound("unhealthy_food.wav");
        }
        
        HeartBonus heart = (HeartBonus)getOneIntersectingObject(HeartBonus.class);
        if (heart != null)
        {
            getWorld().removeObject(heart);
    
            HealthyFoodFeastWorld world = (HealthyFoodFeastWorld)getWorld();
            world.gainLife();
            
            Greenfoot.playSound("gain_life.wav");
        }
    }

}
