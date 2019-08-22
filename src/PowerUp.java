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
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import java.util.Random;


//PowerUp Class to make power ups in the game
public class PowerUp extends GameToken 
{

    //Constructor
    public PowerUp( int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.height = height;
        this.width = width;
        //starting  random location on the Game Board
        Random rand = new Random();
        int n = rand.nextInt(10);
        int m = rand.nextInt(10);
        System.out.println("random int n =" + n);
        System.out.println("random int m =" + m);
        gridX= n * GameBoard.gridSize ;
        gridY= (m * GameBoard.gridSize) ;
        
        setLocation(gridX, gridY);
        setSize(width,height);
        setVisible(true);
 
 
    }

    //Graphics of Power Up
   @Override
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
    
      //set background square to black
        Graphics2D bg = (Graphics2D) g;
        bg.setColor(Color.BLACK);
        bg.fillRect(0, 0,height,width);
    //set border color to gray
        Graphics2D brdr = (Graphics2D) g;
        brdr.setColor(Color.DARK_GRAY);
        brdr.drawRect(0, 0,height,width);
        
        
        // Power up graphics
        
   
        //Outside rectangle
        Graphics2D g3d = (Graphics2D) g;
        g3d.setColor(Color.BLUE);
        g3d.fillRect(0, 0,5,70);
        g3d.fillRect(0, 0,70,5);

        g3d.fillRect(0, 65,70,5);
        g3d.fillRect(65, 0,5,70);
      

        
       
    

        


        
  
    }


}


