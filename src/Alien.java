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


//Alien Class to make Aliens in the game
public class Alien extends GameToken 
{
    //small alien size is default
    public int alienSize;
    protected static int alienPoint;
    protected static int alienSpeed;
   

    //Constructor
    public Alien( int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.height = height;
        this.width = width;
        //starting  random location
        Random rand = new Random();
        int n = rand.nextInt(10);
        int m = rand.nextInt(10);
        
        System.out.println("random int n =" + n);
        System.out.println("random int m =" + m);

        gridX= n * GameBoard.gridSize ;
        //- gameboard size since it starts above the gameboard
        gridY= (m * GameBoard.gridSize) - (GameBoard.boardSize);
        
        
        //small alien size is 0, point is 10
        if ( m==1 || m==4 || m==7 ){
            if(n== 9||n== 3){
                alienSize=0;
                alienPoint =Configuration.smallAlienPoint;
                alienSpeed = 3;
            }
        }
        //medium aliem size is 1, point is 25
        else if (m==0 || m==2 || m==5 || m==8){
        
                alienSize=1;
                alienPoint =Configuration.mediumAlienPoint;
                alienSpeed = 2;
            
        }
        //large alien size is 2, point is 50
        else if (m==3 || m==6 || m==9){
            
                alienSize=2;
                alienPoint =Configuration.largeAlienPoint;
                alienSpeed = 1;
            
        }
        //if 1 point shows up, theres a bug
        else{
            alienSize=4;
            alienPoint =1;
        }

        setLocation(gridX, gridY);
        setSize(width,height);
        setVisible(true);
       
       
 
    }

    //Graphics of alien
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

        //if alien is small (30x30)
        if(alienSize== 0){
            alienPoint =10;
            Graphics2D g3d = (Graphics2D) g;
            g3d.setColor(Color.GREEN);
           //left side antenna   
            g3d.fillRect(25, 20,5,5);
            //right side antenna    
            g3d.fillRect(40, 20,5,5);
            //body
            g3d.fillRect(20, 25,30,15);
            //legs left
            g3d.fillRect(25, 40,5,5);
            g3d.fillRect(20, 45,5,5);
            //legs right
            g3d.fillRect(40, 40,5,5);
            g3d.fillRect(45, 45,5,5);
            //eyes
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(25, 30,5,5);
            g2d.fillRect(40, 30,5,5);

            
          }

      //if alien is medium (50x50)
      else if(alienSize== 1){
        alienPoint =25;
        Graphics2D g3d = (Graphics2D) g;
        g3d.setColor(Color.GREEN);
       //left side antenna   
        g3d.fillRect(10, 10,5,5);
        g3d.fillRect(10, 15,5,5);
        g3d.fillRect(10, 10,5,5);
        g3d.fillRect(10, 15,5,5);
        //right side antenna    
        g3d.fillRect(55, 10,5,5);
        g3d.fillRect(55, 15,5,5);
        g3d.fillRect(55, 10,5,5);
        g3d.fillRect(55, 15,5,5);
        //body
        g3d.fillRect(15, 20,40,20);
        //arms left
        g3d.fillRect(10, 25,5,5);
        g3d.fillRect(15, 40,5,5);
        g3d.fillRect(10, 45,5,5);
        //arms right
        g3d.fillRect(55, 25,5,5);
        g3d.fillRect(50, 40,5,5);
        g3d.fillRect(55, 45,5,5);
        //legs left
        g3d.fillRect(25, 40,5,10);
        g3d.fillRect(22, 50,5,10);
        //legs right
        g3d.fillRect(40, 40,5,10);
        g3d.fillRect(43, 50,5,10);
        //eyes
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(20, 25,5,10);
        g2d.fillRect(45, 25,5,10);

        
      }

      //if alien is large(70x70)
      else if (alienSize == 2){
        alienPoint =50;
        Graphics2D g3d = (Graphics2D) g;
        g3d.setColor(Color.GREEN);
       //left side antenna
        g3d.fillRect(0, 0,5,5);
        g3d.fillRect(5, 5,5,5);
        g3d.fillRect(10, 10,5,5);
        g3d.fillRect(10, 15,5,5);
        g3d.fillRect(10, 10,5,5);
        g3d.fillRect(10, 15,5,5);
        //right side antenna
        g3d.fillRect(65, 0,5,5);
        g3d.fillRect(60, 5,5,5);
        g3d.fillRect(55, 10,5,5);
        g3d.fillRect(55, 15,5,5);
        g3d.fillRect(55, 10,5,5);
        g3d.fillRect(55, 15,5,5);
        //body
        g3d.fillRect(15, 20,40,20);
        //arms left
        g3d.fillRect(10, 25,5,5);
        g3d.fillRect(0, 30,10,5);
        g3d.fillRect(15, 40,5,5);
        g3d.fillRect(10, 45,5,5);
        g3d.fillRect(0, 50,10,5);
        //arms right
        g3d.fillRect(55, 25,5,5);
        g3d.fillRect(60, 30,10,5);
        g3d.fillRect(50, 40,5,5);
        g3d.fillRect(55, 45,5,5);
        g3d.fillRect(60, 50,10,5);
        //legs left
        g3d.fillRect(25, 40,5,10);
        g3d.fillRect(22, 50,5,10);
        g3d.fillRect(17, 60,5,10);
        g3d.fillRect(65, 65,5,5);
        g3d.fillRect(60, 65,5,5);
        g3d.fillRect(55, 65,5,5);
        g3d.fillRect(50, 65,5,5);
        //legs right
        g3d.fillRect(40, 40,5,10);
        g3d.fillRect(43, 50,5,10);
        g3d.fillRect(48, 60,5,10);
        g3d.fillRect(0, 65,5,5);
        g3d.fillRect(5, 65,5,5);
        g3d.fillRect(10, 65,5,5);
        g3d.fillRect(15, 65,5,5);
        //eyes
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(20, 25,5,10);
        g2d.fillRect(45, 25,5,10);


        
      }
      //if this shows up, theres something wrong
      else if(alienSize==4){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(20, 25,5,10);
        g2d.fillRect(45, 25,5,10);

      }
      else{
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(20, 25,5,10);
        g2d.fillRect(45, 25,5,10);

      }
        


        
  
    }


}


