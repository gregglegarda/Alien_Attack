/**
 * CSCI 2113 - Project 2 - Alien Attack
 * 
 * @author [Gregg Legarda]
 *
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Random;
import java.util.*;




//Class for creating the whole frame
public class AlienAttackFrame extends JFrame
{
   
  // Creating the objects in the frame
   public GameBoard aaBoard;
   public GameToken aaPlayer;
   public PowerUp aaPower;
   public Alien aaAlien1;
   public Alien aaAlien2;
   public Alien aaAlien3;
   public Alien aaAlien4;
   public Alien aaAlien5;
   public Alien aaAlien6;
   public Alien aaAlien7;
   public Alien aaAlien8;
   public Alien aaAlien9;
   public Alien aaAlien10;
   public Alien aaAlien11;
   public Alien aaAlien12;
   public Alien aaAlien13;
   public Alien aaAlien14;
   public Alien aaAlien15;
   public Alien aaAlien16;
   public Alien aaAlien17;
   public Alien aaAlien18;
   public Alien aaAlien19;
   public Alien aaAlien20;

//Game Timer
   public Timer aaGameTimer;
   public int seconds;
   public int minutes;
   public int hours;

//Timer and Label 
   public Timer aaTimer;
   public JLabel timeLabel;
   public int elapsedTime;
   public int timeUp;
   public int totalPoints;
   public int highScore;
//button modes
   public int demoMode;
   public int startMode; 
   public int endMode;
   


   public AlienAttackFrame()
   {
      //FRAME CODES
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setTitle("Alien Attack!");
         setSize(GameBoard.boardSize,GameBoard.boardSize+77);
         //setResizable(false);
         setVisible(true);
      
      //GAME TIMER CODES
         GameTimer gameTime = new GameTimer();
         seconds =0;
         aaGameTimer = new Timer(1000, gameTime);
         aaGameTimer.setInitialDelay(1);

      //TIMER CODES
         TimeListener timeListener = new TimeListener();
         elapsedTime = 0;
         timeUp = Configuration.timerEndInSeconds;
         aaTimer = new Timer(Configuration.cycleTime, timeListener);

         //Label for the timer
            timeLabel = new JLabel("PLEASE PRESS START");
            timeLabel.setForeground (Color.WHITE);
            aaTimer.setInitialDelay(1);
      
      
         //Create the Top panel for the timer and put it in the frame
         JPanel TopPanel = new JPanel();
         TopPanel.setBackground(Color.BLACK);
         TopPanel.add(timeLabel);
         getContentPane().add(TopPanel, BorderLayout.NORTH);


      //MAINSCREEN AND BOARD CODES
         //create board instance
         aaBoard = new GameBoard();
         //create player instance, player is 70x70 since game board is 700x700
         aaPlayer = new GameToken(0, 0, 70, 70);
         
         
       
         
         //add board to frame
         add(aaBoard);
         //add player to frame
         aaBoard.add(aaPlayer);
         //Power up
         aaPower = new PowerUp(0, 0, 70, 70);

         //Alien instances
         aaAlien1 = new Alien(0, 0, 70, 70);
         aaAlien2 = new Alien(0, 0, 70, 70);
         aaAlien3 = new Alien(0, 0, 70, 70);
         aaAlien4 = new Alien(0, 0, 70, 70);
         aaAlien5 = new Alien(0, 0, 70, 70);
         aaAlien6 = new Alien(0, 0, 70, 70);
         aaAlien7 = new Alien(0, 0, 70, 70);
         aaAlien8 = new Alien(0, 0, 70, 70);
         aaAlien9 = new Alien(0, 0, 70, 70);
         aaAlien10 = new Alien(0, 0, 70, 70);
         aaAlien11 = new Alien(0, 0, 70, 70);
         aaAlien12 = new Alien(0, 0, 70, 70);
         aaAlien13 = new Alien(0, 0, 70, 70);
         aaAlien14 = new Alien(0, 0, 70, 70);
         aaAlien15 = new Alien(0, 0, 70, 70);
         aaAlien16 = new Alien(0, 0, 70, 70);
         aaAlien17 = new Alien(0, 0, 70, 70);
         aaAlien18 = new Alien(0, 0, 70, 70);
         aaAlien19 = new Alien(0, 0, 70, 70);
         aaAlien20 = new Alien(0, 0, 70, 70);
         //set num aliens to starting num aliens
         Configuration.setNumAliens =Configuration.startingMinAliens;
     
      
      //BUTTON CODES
         //Create the bottom panel and put it in the frame
         JPanel BottomPanel = new JPanel();
         BottomPanel.setLayout(new GridLayout(1,4));
         BottomPanel.setBackground(Color.BLUE);
         getContentPane().add(BottomPanel, BorderLayout.SOUTH);

         //Create the buttons and add it to the bottom panel of the board
         JButton Start = new JButton("Start");
         Start.setName("Start");
         JButton Pause = new JButton("Pause");
         Pause.setName("Pause");
         JButton End = new JButton("End");
         End.setName("End");
         JButton Demo = new JButton("Demo");
          Demo.setName("Demo");
  

      //BUTTONS AND ACTION LISTENERS
         //Add listeners to the button
         ButtonListener buttonListener = new ButtonListener();
         Start.addActionListener(buttonListener);
         Pause.addActionListener(buttonListener);
         End.addActionListener(buttonListener);
         Demo.addActionListener(buttonListener);
      
         //Key listeners
         ButtonKeyListener buttonKeyListener = new ButtonKeyListener();
         Start.addKeyListener(buttonKeyListener);

         //Add buttons to panel
         BottomPanel.add(Start, BorderLayout.SOUTH);
         BottomPanel.add(Pause, BorderLayout.SOUTH);
         BottomPanel.add(End, BorderLayout.SOUTH);
         BottomPanel.add(Demo, BorderLayout.SOUTH);
        

   }
   
   //Action listener for buttons
   class  ButtonListener implements ActionListener{
   

      @Override
      public void actionPerformed(ActionEvent e){
         Object obj = e.getSource();
         
         if (((JComponent)obj).getName() == "Start" ){
               
               //reset if player is dead, tier is up, end is pressed
               if(GameToken.tokenSize  ==-1 || elapsedTime==0 || endMode ==1 || demoMode==1){
                  //reset board
                  aaBoard = new GameBoard();
                  add(aaBoard);
                  //reset player
                  aaPlayer = new GameToken(0, 0, 70, 70);
                  aaBoard.add(aaPlayer);
                  GameToken.tokenSize  = 3;

                  //reset points and buttons
                  elapsedTime=0;
                  seconds=0;
                  totalPoints=0;
                  demoMode=0; 
                  endMode =0;
                  
               }
               //timer starts when start button is pressed
               aaGameTimer.start();
               aaTimer.start();
               System.out.println("Start clicked");

               //reset start button
               startMode=1;
              
         }
        else if(((JComponent)obj).getName() == "Pause"){
               demoMode=0;   
               //timer stiops when pause button is pressed
               aaGameTimer.stop();
               aaTimer.stop();
               timeLabel.setText("STATUS: GAME PAUSED             SCORE: " + totalPoints + "             HIGH SCORE: " + highScore);
               System.out.println("Pause clicked");
         }
         else if(((JComponent)obj).getName() == "End" ){
              
            
            
               //label
               timeLabel.setText("STATUS: GAME OVER!              SCORE: " + totalPoints + "             HIGH SCORE: " + highScore);
               System.out.println("End clicked");
               //timer stops and resets when start button is pressed
               aaGameTimer.stop();
               aaTimer.stop();
               elapsedTime=0;
               seconds=0;
               //totalPoints =0;

               //reset end button
               endMode = 1;

                //top scores

               Configuration.highScoreList[10] = totalPoints;
               
               int temp;
                for (int i = 1; i < Configuration.highScoreList.length; i++) {
                  for (int j = i; j > 0; j--) {
                   if (Configuration.highScoreList[j] > Configuration.highScoreList [j - 1]) {
                    temp = Configuration.highScoreList[j];
                    Configuration.highScoreList[j] = Configuration.highScoreList[j - 1];
                    Configuration.highScoreList[j - 1] = temp;
                   }
                  }
                 }

                JOptionPane.showMessageDialog(aaBoard,
                "1.    "+ Configuration.highScoreList[0]+ "  \n"+
                "2.    "+ Configuration.highScoreList[1]+ "  \n"+
                "3.    "+ Configuration.highScoreList[2]+ "  \n"+
                "4.    "+ Configuration.highScoreList[3]+ "  \n"+
                "5.    "+ Configuration.highScoreList[4]+ "  \n"+
                "6.    "+ Configuration.highScoreList[5]+ "  \n"+
                "7.    "+ Configuration.highScoreList[6]+ "  \n"+
                "8.    "+ Configuration.highScoreList[7]+ "  \n"+
                "9.    "+ Configuration.highScoreList[8]+ "  \n"+
                "10.  "+ Configuration.highScoreList[9]+ "  \n",
               "TOP 10 HIGH SCORES:",
               JOptionPane.PLAIN_MESSAGE);
      
            
         }
         else if(((JComponent)obj).getName() == "Demo"){
         
               

               //reset if player is dead, tier is up, end is pressed, then reset demo board
               if(GameToken.tokenSize  ==-1 || elapsedTime==0 || endMode ==1 || startMode==1){
                  //reset board
                  aaBoard = new GameBoard();
                  add(aaBoard);
                  //reset player
                  aaPlayer = new GameToken(0, 0, 70, 70);
                  aaBoard.add(aaPlayer);
                  GameToken.tokenSize  = 3;
                  //reset buttons end, start
                  elapsedTime=0;
                  seconds=0;
                  totalPoints=0;
                  //reset buttons
                  endMode =0;
                  startMode=0;

                  
               }
               //timer starts when start button is pressed
               aaGameTimer.start();
               aaTimer.start();
               System.out.println("Demo clicked");
               //reset demo mode
               demoMode=1;

         }
         
      }

   }   
   //Key listener for arrow key buttons
   class  ButtonKeyListener  implements KeyListener{
      
      @Override
      public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT   ) {
            System.out.println("Right key typed");
            
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT  ) {
            System.out.println("Left key typed");
   
        }
        if (e.getKeyCode() == KeyEvent.VK_UP  ) {
         System.out.println("Up key typed");

         }
         if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
         System.out.println("Down key typed");

         }

      }
      //Position setting of player when key buttons are pressed
      @Override
      public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && aaPlayer.getGridX() <  GameBoard.boardSize-GameBoard.gridSize) {
            System.out.println("Right key pressed");
            //move player to right grid
            aaPlayer.setGridX(+1);
            
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && aaPlayer.getGridX() > 0 ) {
            System.out.println("Left key pressed");
            //move player to left grid
            aaPlayer.setGridX(-1);
            
        }
        if(e.getKeyCode() == KeyEvent.VK_UP && aaPlayer.getGridY() > 0 ){
            //move player to upper grid
            aaPlayer.setGridY(-1);
            System.out.println("Up key pressed");
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN && aaPlayer.getGridY() < GameBoard.boardSize-GameBoard.gridSize){
            //move player to lower grid
            aaPlayer.setGridY(+1);
            System.out.println("Down key pressed");
         }



      }

      @Override
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
         System.out.println("Up key Released");
         }
         if (e.getKeyCode() == KeyEvent.VK_DOWN) {
         System.out.println("Down key Released");
         }
      }

   }

   //Timer Action Listener
   class TimeListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e)
      {
        
        
         //If timer is not up yet
        if (seconds<timeUp) {
         ++elapsedTime;
         //Label text on the screen
        timeLabel.setText("TIME: " + String.valueOf(String.format("%02d", hours))+ ":"+String.valueOf(String.format("%02d", minutes))+":"+String.valueOf(String.format("%02d", seconds))  + "              SCORE: " + totalPoints + "              HIGH SCORE: " + highScore) ;
         System.out.println("tick");
              //demo mode random moves
              if (demoMode==1){
               Random rand = new Random();
               int randomMove = rand.nextInt(7);
                  //move right
                  if((randomMove== 1 || randomMove == 4)&& aaPlayer.getGridX() <  GameBoard.boardSize-GameBoard.gridSize){
                     aaPlayer.setGridX(+1);
                  }
                  //move left
                  if((randomMove== 0 || randomMove == 5) && aaPlayer.getGridX() > 0){
                     aaPlayer.setGridX(-1);
                  }
                  //move up
                  if((randomMove== 3 || randomMove == 6) && aaPlayer.getGridY() > 0){
                     aaPlayer.setGridY(-1);
                  }
                  //move down
                  if((randomMove== 2 || randomMove == 7) && aaPlayer.getGridY() <  GameBoard.boardSize-GameBoard.gridSize){
                     aaPlayer.setGridY(+1);
                  }



              }
               
            
               //waves
               if (elapsedTime == 1 
               || elapsedTime% 20==0
               
               ){
                  //make power up disappear before every wave
                  aaPower.setGridY(+20);
                  aaAlien1.setGridY(+20);
                  aaAlien2.setGridY(+20);
                  aaAlien3.setGridY(+20);
                  aaAlien4.setGridY(+20);
                  aaAlien5.setGridY(+20);
                  aaAlien6.setGridY(+20);
                  aaAlien7.setGridY(+20);
                  aaAlien8.setGridY(+20);
                  aaAlien9.setGridY(+20);
                  aaAlien10.setGridY(+20);
                  aaAlien11.setGridY(+20);
                  aaAlien12.setGridY(+20);
                  aaAlien13.setGridY(+20);
                  aaAlien14.setGridY(+20);
                  aaAlien15.setGridY(+20);
                  aaAlien16.setGridY(+20);
                  aaAlien17.setGridY(+20);
                  aaAlien18.setGridY(+20);
                  aaAlien19.setGridY(+20);
                  aaAlien20.setGridY(+20);

                  //recreate random powerup
                  aaPower = new PowerUp(0, 0, 70, 70);

                  //recreate wave of random aliens
                  if(Configuration.setNumAliens >=1){ aaAlien1 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=2){aaAlien2 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=3){ aaAlien3 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=4){aaAlien4 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=5){aaAlien5 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=6){aaAlien6 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=7){aaAlien7 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=8){aaAlien8 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=9){aaAlien9 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=10){aaAlien10 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=11){aaAlien11 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=12){aaAlien12 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=13){aaAlien13 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=14){aaAlien14 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=15){aaAlien15 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=16){aaAlien16 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=17){aaAlien17 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=18){aaAlien18 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=19){aaAlien19 = new Alien(0, 0, 70, 70);}
                  if(Configuration.setNumAliens >=20){aaAlien20 = new Alien(0, 0, 70, 70);}

                  //If constr.numalien >=1 add alien to board
                  //add aliens
                  if(Configuration.setNumAliens >=1){ aaBoard.add(aaAlien1);}
                  if(Configuration.setNumAliens >=2){ aaBoard.add(aaAlien2);}
                  if(Configuration.setNumAliens >=3){ aaBoard.add(aaAlien3);}
                  if(Configuration.setNumAliens >=4){ aaBoard.add(aaAlien4);}
                  if(Configuration.setNumAliens >=5){ aaBoard.add(aaAlien5);}
                  if(Configuration.setNumAliens >=6){ aaBoard.add(aaAlien6);}
                  if(Configuration.setNumAliens >=7){ aaBoard.add(aaAlien7);}
                  if(Configuration.setNumAliens >=8){ aaBoard.add(aaAlien8);}
                  if(Configuration.setNumAliens >=9){ aaBoard.add(aaAlien9);}
                  if(Configuration.setNumAliens >=10){ aaBoard.add(aaAlien10);}
                  if(Configuration.setNumAliens >=11){ aaBoard.add(aaAlien11);}
                  if(Configuration.setNumAliens >=12){ aaBoard.add(aaAlien12);}
                  if(Configuration.setNumAliens >=13){ aaBoard.add(aaAlien13);}
                  if(Configuration.setNumAliens >=14){ aaBoard.add(aaAlien14);}
                  if(Configuration.setNumAliens >=15){ aaBoard.add(aaAlien15);}
                  if(Configuration.setNumAliens >=16){ aaBoard.add(aaAlien16);}
                  if(Configuration.setNumAliens >=17){ aaBoard.add(aaAlien17);}
                  if(Configuration.setNumAliens >=18){ aaBoard.add(aaAlien18);}
                  if(Configuration.setNumAliens >=19){ aaBoard.add(aaAlien19);}
                  if(Configuration.setNumAliens >=20){ aaBoard.add(aaAlien20);}

                 
                  //add aliens everywave as long as its not the max limit
                  if(Configuration.setNumAliens< Configuration.startingMaxAliens){
                     Configuration.setNumAliens++;
                     System.out.println("Alien number incremented!!!");
                  }
                  else{
                     Configuration.cycleTime = Configuration.cycleTime - Configuration.increaseInterval;
                  }
                  
                  //add power up
                  aaBoard.add(aaPower);
                  
                      
               }
               

               //aliens
               aaAlien1.setGridY(+1);
               aaAlien2.setGridY(+1);
               aaAlien3.setGridY(+1);
               aaAlien4.setGridY(+1);
               aaAlien5.setGridY(+1);
               aaAlien6.setGridY(+1);
               aaAlien7.setGridY(+1);
               aaAlien8.setGridY(+1);
               aaAlien9.setGridY(+1);
               aaAlien10.setGridY(+1);
               aaAlien11.setGridY(+1);
               aaAlien12.setGridY(+1);
               aaAlien13.setGridY(+1);
               aaAlien14.setGridY(+1);
               aaAlien15.setGridY(+1);
               aaAlien16.setGridY(+1);
               aaAlien17.setGridY(+1);
               aaAlien18.setGridY(+1);
               aaAlien19.setGridY(+1);
               aaAlien20.setGridY(+1);
               




               //exploding graphics of large
               if (GameToken.tokenSize == -3){
                  //back to downsizing to medium
                  GameToken.tokenSize = 2; 
                  
                  System.out.println("player attacked!!!");
               } 
               //exploding graphics of medium
                else if (GameToken.tokenSize == -2){
                  //back to downsizing to small
                  GameToken.tokenSize = 1; 
                  System.out.println("player attacked!!!");
               }

               //Catching the powerup

                        if(//if player catches it or if
                        aaPower.getGridX()== aaPlayer.getGridX() && aaPower.getGridY()== aaPlayer.getGridY())
                        {
                           System.out.println("Power up!!!");
                           //player size back to normal
                              GameToken.tokenSize = 3; 
                           //powerup disappears from the board
                              aaPower.setGridY(+20);

                        }
                     


               // Getting attacked/hit by alien (If player is in the same grid as moving alien)
                     if(
                        aaAlien1.getGridX()== aaPlayer.getGridX() && aaAlien1.getGridY()== aaPlayer.getGridY()||
                        aaAlien2.getGridX()== aaPlayer.getGridX() && aaAlien2.getGridY()== aaPlayer.getGridY()||
                        aaAlien3.getGridX()== aaPlayer.getGridX() && aaAlien3.getGridY()== aaPlayer.getGridY()||
                        aaAlien4.getGridX()== aaPlayer.getGridX() && aaAlien4.getGridY()== aaPlayer.getGridY()||
                        aaAlien5.getGridX()== aaPlayer.getGridX() && aaAlien5.getGridY()== aaPlayer.getGridY()||
                        aaAlien6.getGridX()== aaPlayer.getGridX() && aaAlien6.getGridY()== aaPlayer.getGridY()||
                        aaAlien7.getGridX()== aaPlayer.getGridX() && aaAlien7.getGridY()== aaPlayer.getGridY()||
                        aaAlien8.getGridX()== aaPlayer.getGridX() && aaAlien8.getGridY()== aaPlayer.getGridY()||
                        aaAlien9.getGridX()== aaPlayer.getGridX() && aaAlien9.getGridY()== aaPlayer.getGridY()||
                        aaAlien10.getGridX()== aaPlayer.getGridX() && aaAlien10.getGridY()== aaPlayer.getGridY()||
                        aaAlien11.getGridX()== aaPlayer.getGridX() && aaAlien11.getGridY()== aaPlayer.getGridY()||
                        aaAlien12.getGridX()== aaPlayer.getGridX() && aaAlien12.getGridY()== aaPlayer.getGridY()||
                        aaAlien13.getGridX()== aaPlayer.getGridX() && aaAlien13.getGridY()== aaPlayer.getGridY()||
                        aaAlien14.getGridX()== aaPlayer.getGridX() && aaAlien14.getGridY()== aaPlayer.getGridY()||
                        aaAlien15.getGridX()== aaPlayer.getGridX() && aaAlien15.getGridY()== aaPlayer.getGridY()||
                        aaAlien16.getGridX()== aaPlayer.getGridX() && aaAlien16.getGridY()== aaPlayer.getGridY()||
                        aaAlien17.getGridX()== aaPlayer.getGridX() && aaAlien17.getGridY()== aaPlayer.getGridY()||
                        aaAlien18.getGridX()== aaPlayer.getGridX() && aaAlien18.getGridY()== aaPlayer.getGridY()||
                        aaAlien19.getGridX()== aaPlayer.getGridX() && aaAlien19.getGridY()== aaPlayer.getGridY()||
                        aaAlien20.getGridX()== aaPlayer.getGridX() && aaAlien20.getGridY()== aaPlayer.getGridY()
                        )
                     {
                        //change player size when hit
                           //if large, exploding graphics, then turn to medium in the begining of timer loop
                           if (GameToken.tokenSize == 3){
                              
                              GameToken.tokenSize = -3; 
                              System.out.println("player attacked!!!");
                              
                           } 
                           //if medium, exploding graphics, then turn to small  in the begining of timer loop
                           else if (GameToken.tokenSize == 2){
                              GameToken.tokenSize  =-2; 
                              System.out.println("player attacked!!!");
                           }
                           //if player size is small, make player die and end timer
                           else if (GameToken.tokenSize == 1 ){
                              //label
                              System.out.println("player attacked!!!");
                              timeLabel.setText("STATUS: GAME OVER! (Player died)" + "             SCORE: " + totalPoints + "              HIGH SCORE: " + highScore);
                              
                              //player dies and graphics is explosion
                              GameToken.tokenSize  =-1; 
                              aaGameTimer.stop();
                              aaTimer.stop();
                              
                             
                              
                              //top scores

                              Configuration.highScoreList[10] = totalPoints;
               
                              int temp;
                                 for (int i = 1; i < Configuration.highScoreList.length; i++) {
                                    for (int j = i; j > 0; j--) {
                                       if (Configuration.highScoreList[j] > Configuration.highScoreList [j - 1]) {
                                          temp = Configuration.highScoreList[j];
                                          Configuration.highScoreList[j] = Configuration.highScoreList[j - 1];
                                             Configuration.highScoreList[j - 1] = temp;
                                       }
                                    }
                                 }

                              JOptionPane.showMessageDialog(aaBoard,
                               "1.    "+ Configuration.highScoreList[0]+ "  \n"+
                               "2.    "+ Configuration.highScoreList[1]+ "  \n"+
                              "3.    "+ Configuration.highScoreList[2]+ "  \n"+
                              "4.    "+ Configuration.highScoreList[3]+ "  \n"+
                               "5.    "+ Configuration.highScoreList[4]+ "  \n"+
                               "6.    "+ Configuration.highScoreList[5]+ "  \n"+
                               "7.    "+ Configuration.highScoreList[6]+ "  \n"+
                               "8.    "+ Configuration.highScoreList[7]+ "  \n"+
                                 "9.    "+ Configuration.highScoreList[8]+ "  \n"+
                              "10.  "+ Configuration.highScoreList[9]+ "  \n",
                               "TOP 10 HIGH SCORES:",
                              JOptionPane.PLAIN_MESSAGE);
                              

                               //reset time and points
                               seconds=0;
                               elapsedTime=0;
                               totalPoints =0;
                           }
                           

                  
                     }
                     
                     

               //Alien Passes the Player/not getting hit (if alien grid Y passed the board, and it is not equal to player position)
                     if(aaAlien1.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint; }
                     if(aaAlien2.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien3.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien4.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien5.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien6.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien7.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien8.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien9.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien10.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien11.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien12.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien13.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien14.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien15.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien16.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien17.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien18.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien19.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
                     if(aaAlien20.getGridY() == 630 )
                     {totalPoints = totalPoints+ Alien.alienPoint;}
           
            
                   
                     if(totalPoints>highScore){
                        highScore = totalPoints;
                     }  
                     aaBoard.repaint();
           
          
         
            
        } 
        //If timer is up
        else {
           //High score
            if(totalPoints>highScore){
               highScore = totalPoints;
               
            }
            timeLabel.setText("STATUS: GAME OVER! (Time's up)"+ "             SCORE: " + totalPoints + "             HIGH SCORE: " + highScore);
             //Reset time and position, stop time
             seconds=0;
             elapsedTime=0;
             aaGameTimer.stop();
             aaTimer.stop();

             //top scores

             Configuration.highScoreList[10] = totalPoints;
               
             int temp;
              for (int i = 1; i < Configuration.highScoreList.length; i++) {
                for (int j = i; j > 0; j--) {
                 if (Configuration.highScoreList[j] > Configuration.highScoreList [j - 1]) {
                  temp = Configuration.highScoreList[j];
                  Configuration.highScoreList[j] = Configuration.highScoreList[j - 1];
                  Configuration.highScoreList[j - 1] = temp;
                 }
                }
               }

              JOptionPane.showMessageDialog(aaBoard,
              "1.    "+ Configuration.highScoreList[0]+ "  \n"+
              "2.    "+ Configuration.highScoreList[1]+ "  \n"+
              "3.    "+ Configuration.highScoreList[2]+ "  \n"+
              "4.    "+ Configuration.highScoreList[3]+ "  \n"+
              "5.    "+ Configuration.highScoreList[4]+ "  \n"+
              "6.    "+ Configuration.highScoreList[5]+ "  \n"+
              "7.    "+ Configuration.highScoreList[6]+ "  \n"+
              "8.    "+ Configuration.highScoreList[7]+ "  \n"+
              "9.    "+ Configuration.highScoreList[8]+ "  \n"+
              "10.  "+ Configuration.highScoreList[9]+ "  \n",
             "TOP 10 HIGH SCORES:",
             JOptionPane.PLAIN_MESSAGE);
            
                
        }
      }
    
   




   }


   class GameTimer implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e)
      {
      
         
        ++seconds;
        if(seconds==60){
           minutes++;
           seconds=0;
        }
        if(minutes==60){
           hours++;
           minutes=0;
        }
        if(hours == 24){
           hours=0;
        }
         System.out.println("Gametick");
      
      }
   }
  


}


