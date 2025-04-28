import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UnhealthyFood represents the junk food items the player should avoid.
 * 
 * Each UnhealthyFood object randomly selects and displays a junk food item
 * from the unhealthy_food sprite sheet when it is created.
 * 
 * UnhealthyFood objects inherit falling behavior from FallingObject
 * and move downward automatically.
 * 
 * Touching an UnhealthyFood will cause the player to lose one life.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class UnhealthyFood extends FallingObject
{
    public UnhealthyFood()
    {
        GreenfootImage spriteSheet = new GreenfootImage("unhealthy_food.png");

        int cols = 24;
        int tileSize = 32;

        int randomCol = Greenfoot.getRandomNumber(cols);

        GreenfootImage junkFoodImage = new GreenfootImage(tileSize, tileSize);
        junkFoodImage.drawImage(spriteSheet, -randomCol * tileSize, 0);

        setImage(junkFoodImage);
    }
}
