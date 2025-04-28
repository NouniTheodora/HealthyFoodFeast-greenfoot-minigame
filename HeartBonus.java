import greenfoot.*;

/**
 * The HeartBonus class represents a special falling object in the game world.
 * 
 * When the player (Chef) collects a HeartBonus, they gain one additional life,
 * provided they have not already reached the maximum number of lives.
 * 
 * HeartBonus objects appear rarely during gameplay and offer players an extra chance
 * to survive and continue playing for a longer time.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class HeartBonus extends FallingObject
{
    public HeartBonus()
    {
        GreenfootImage heartImage = new GreenfootImage("heart_full.png");
        heartImage.scale(30, 20);
        setImage(heartImage);
    }
}
