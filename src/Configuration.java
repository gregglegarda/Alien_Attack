/**
 * CSCI 2113 - Project 2 - Alien Attack
 * 
 * @author [Gregg Legarda]
 *
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import java.util.*;

// Configuration
public class Configuration 
{
  
    protected static int cycleTime = 100; // control speed
    protected static int largeAlienPoint=50; // Large alien point
    protected static int mediumAlienPoint=25; // medium alien point
    protected static int smallAlienPoint=10; // small alien point
    protected static int increaseInterval =10; // incraese interval
    protected static int startingMaxAliens=15;//max number of aliens from the start
    protected static int startingMinAliens=1;//min number of aliens from the start
    protected static int setNumAliens;// increases depends on starting min and max aliens
    protected static int timerEndInSeconds = 3600;// game ends in this number of seconds
    protected static int highScoreList[]= new int[11];//top 10 high scores
    

    
    

    //Constructor 
   protected Configuration()
   {


   }


   

}
