/**
 * CSCI 2113 - Project 2 - Alien Attack
 * 
 * @author [Gregg Legarda]
 *
 */
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


//GameBoard Class for main Screen
public class GameBoard extends JPanel
{
   
   //Setting Board size - 700x700 since 900x900 doesnt fit my screen
   protected static int boardSize = 700;
   protected static int numGrids = 10;
   protected static int gridSize = boardSize/numGrids;
   
   //Constructor
   public GameBoard()
   {
      setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
      setBackground(Color.BLACK);
      setLayout(null);

   }

   // Size Getter
   @Override
   public Dimension getPreferredSize()
   {
      //TODO: Set the game board size
      Dimension dimension = new Dimension(boardSize, boardSize);
      this.setPreferredSize(dimension);
      return dimension;
   }

   //Drawing the board
   @Override
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;

      // Draw grid
      g2d.setColor(Color.DARK_GRAY);
      int y1=0;
      int x = 0;  
      int y2 =boardSize;
        
      for (x=0; x<=boardSize ; x+= gridSize){  
         g2d.drawLine(x,y1,x,y2);
         g2d.drawLine(y1,x,y2,x);
      }        
      
    }
 
      
   }


