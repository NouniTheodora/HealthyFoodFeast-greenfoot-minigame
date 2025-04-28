import greenfoot.*;

/**
 * HealthyFood represents the fruits and vegetables the player should catch.
 * 
 * Each HealthyFood object randomly selects and displays a healthy food item
 * from a sprite sheet when it is created. 
 * 
 * HealthyFood objects inherit falling behavior from FallingObject
 * and move downward automatically.
 * 
 * Catching HealthyFood will reward the player with points (10/level 1, 20/level 2).
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class HealthyFood extends FallingObject
{
    public HealthyFood()
    {
        GreenfootImage spriteSheet = new GreenfootImage("healthy_food_24px.png");

        int cols = 5;
        int rows = 4;
        int tileSizeOriginal = 24;
        int tileSizeTarget = 32;

        // Randomly pick a tile
        int randomCol = Greenfoot.getRandomNumber(cols);
        int randomRow = Greenfoot.getRandomNumber(rows);

        GreenfootImage croppedTile = new GreenfootImage(tileSizeOriginal, tileSizeOriginal);
        croppedTile.drawImage(spriteSheet, -randomCol * tileSizeOriginal, -randomRow * tileSizeOriginal);

        croppedTile.scale(tileSizeTarget, tileSizeTarget);

        setImage(croppedTile);
    }
}
