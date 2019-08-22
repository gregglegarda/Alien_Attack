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

// GameToken Class to create Player
public class GameToken extends JComponent 
{
    protected int gridX;
    protected int gridY;
    protected int width;
    protected int height;
    protected static int tokenSize= 3;//start with largest size
    
    private static final long serialVersionUID = 1L;

    //Constructor (position and size)
   protected GameToken(int x, int y, int width, int height)
   {
        
        super();     
        this.height = height;
        this.width = width; 
        //starting location
        gridX=0;
        gridY= GameBoard.boardSize - GameBoard.gridSize;
        setLocation(gridX, gridY);
        setSize(width,height);
        setVisible(true);
      

   }
   //Graphics of Player
   @Override
   protected void paintComponent(Graphics g)
   {
      super.paintComponent(g);
        

    if (tokenSize == 3){
    //if player is large (70x70)
        Graphics2D g3d = (Graphics2D) g;
        g3d.setColor(Color.BLUE);
        // player body
        g3d.fillRect(15, 20,40,30);
        //player gun
        g3d.fillRect(20, 0,5,20);
        g3d.fillRect(45, 0,5,20);
        //player wings left
        g3d.fillRect(10, 30,5,10);
        g3d.fillRect(5, 30,5,20);
        g3d.fillRect(0, 40,5,20);
        g3d.fillRect(5, 60,5,10);
        //player wings right
        g3d.fillRect(55, 30,5,10);
        g3d.fillRect(60, 30,5,20);
        g3d.fillRect(65, 40,5,20);
        g3d.fillRect(60, 60,5,10);
        //player window
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(20, 30,30,5);
    }

        //if player is medium (50x50)
        if (tokenSize == 2){
         
                Graphics2D g3d = (Graphics2D) g;
                g3d.setColor(Color.BLUE);
                // player body
                g3d.fillRect(20, 25,30,25);
                //player gun
                g3d.fillRect(20, 10,5,15);
                g3d.fillRect(45, 10,5,15);
                //player wings left
                g3d.fillRect(15, 30,5,15);
                g3d.fillRect(10, 45,5,15);
                //player wings right
                g3d.fillRect(50, 30,5,15);
                g3d.fillRect(55, 45,5,15);
                //player window
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                g2d.fillRect(20, 30,30,5);
            }

        //if player is small (30x30)
        if (tokenSize == 1){
         
                Graphics2D g3d = (Graphics2D) g;
                g3d.setColor(Color.BLUE);
                // player gun
                g3d.fillRect(20, 20,5,10);
                g3d.fillRect(45, 20,5,10);
                
                // player body
                g3d.fillRect(20, 25,30,25);
                
              
                //player window
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                g2d.fillRect(20, 30,30,5);
            }
            //if player is dead or hit, token size is negative
            if (tokenSize < 0 ){
         
                Graphics2D g3d = (Graphics2D) g;
                g3d.setColor(Color.RED);
                g3d.fillRect(0, 0,width,height);


                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.ORANGE);
                g2d.fillRect(0, 0,width-10,height-10);

                Graphics2D g1d = (Graphics2D) g;
                g1d.setColor(Color.YELLOW);
                g1d.fillRect(0, 0,width-20,height-20);
                
            }

      
      
  
    
        
  
    }
    
    //Size Getter
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
      }
    
    //Size Setter
    public Dimension setPreferredSize(int width, int height) {
        this.width = width;
        this.height = height;
    
        return new Dimension(width, height);
      }

    //GridX getter
    public int getGridX() {
        return gridX;
    }
    //GridY getter
    public int getGridY() {
        return gridY;
    }
    //GridX setter
    public void setGridX(int x) {
        gridX += x * GameBoard.gridSize;
        setLocation(gridX, gridY);
    }
    //GridX setter
    public void setGridY(int y) {
        gridY += y * GameBoard.gridSize;      
        setLocation(gridX, gridY);
    }


}
