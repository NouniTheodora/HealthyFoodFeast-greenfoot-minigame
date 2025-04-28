import greenfoot.*;

/**
 * ScoreCounter displays and manages the player's score.
 * 
 * It uses the Singleton pattern to ensure only one instance of the score counter exists 
 * during the game. The score increases whenever the player catches a HealthyFood item.
 * The current score is displayed at the top of the screen and updates live during gameplay.
 * 
 * This class provides methods to add points, retrieve the current score
 * and reset the counter when starting a new game.
 * 
 * @author (Theodora Nouni) 
 * @version (v1)
 */
public class ScoreCounter extends Actor
{
    private static ScoreCounter instance;

    private int score = 0;

    private ScoreCounter()
    {
        updateImage();
    }

    public static ScoreCounter getInstance()
    {
        if (instance == null)
        {
            instance = new ScoreCounter();
        }
        return instance;
    }

    public static void resetInstance()
    {
        instance = new ScoreCounter();
    }

    private void updateImage()
    {
        setImage(new GreenfootImage("Score: " + score, 24, Color.BLACK, new Color(0,0,0,0)));
    }

    public void addScore(int points)
    {
        score += points;
        updateImage();
    }

    public int getScore()
    {
        return score;
    }
}
