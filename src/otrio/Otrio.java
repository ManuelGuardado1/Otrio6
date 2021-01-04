
package otrio;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class Otrio extends JFrame implements Runnable {

   

    
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    Image gameBoard;
    public static boolean StartMenu = true;
    static boolean RulesMenu; 
    static boolean EndMenu;
    static int timeCount;

    public static void main(String[] args) {
        Otrio frame = new Otrio();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    

    public Otrio() {
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    int x = e.getX() - Window.getX(0);
                    int y = e.getY() - Window.getY(0);
//                    Board.AddPiecePixel(x,y);
                    if (StartMenu == true) {
                       
                        
                        Board.RULES(x,y);
                        
                        Board.oneRound(x,y);
                        Board.threeRound(x,y);
                        Board.fiveRound(x,y);
                        Board.SevenRound(x,y);
                        System.out.println(x + " " + y);
                    }
                    else if (RulesMenu == true){
                        Board.RULESBACK(x, y);
                    }
                    else 
                    Board.PlacePiecePixel(x,y);
                    
   
                }
                if (e.BUTTON3 == e.getButton()) {

                    int x = e.getX() - Window.getX(0);
                    int y = e.getY() - Window.getY(0);
     
                    Board.ChoosePiece(x,y);

                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
//                    Board.PlayOtrio();
                } else if (e.VK_ESCAPE == e.getKeyCode()) { 
                    Board.keepRoundCount = 0;
                    reset();
                   
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
          g.setColor(new Color(232,232,232));

        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border

        g.drawImage(gameBoard,Window.getX(0),Window.getY(0),
                Window.getWidth2(),Window.getHeight2(),this);
        
//         drawImage(image,Window.getX(xPos),Window.getYNormal(yPos),0.0,1.0,1.0 );
        
        
//        g.setColor(Color.white);
//        g.fillPolygon(x, y, 4);
       
// draw border
        g.setColor(Color.BLACK);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
       
        Board.Draw(g);
        
         if(StartMenu){ 
             
           
            g.setColor(new Color(244,157,128));
            g.fillRect(0, 0, Window.xsize, Window.ysize);
            
            g.setColor(new Color(126,12,231));
            g.setFont(new Font("d",Font.BOLD,150)); 
            g.drawString("Otrio ",130,200);  
            
            g.setColor(Color.yellow);
            g.setFont(new Font("d",Font.BOLD,150));  
            g.drawString("Otrio ",160,180); 
         
           
            
//            
//            g.setColor(new Color(234,182,130));
//            g.fillRect(74, 220, 250, 80);
//            
//            g.setColor(Color.white);
//            g.setFont(new Font("Verdana",Font.BOLD,80));  
//           
//            g.drawString("PLAY",84,290); 
//            
            ////1 round
            
              g.setColor(new Color(140,182,170));
            g.fillRect(27, 330, 160, 60);
            
            g.setColor(Color.white);
            g.setFont(new Font("Verdana",Font.BOLD,30));  
           
            g.drawString("3 Rounds",30,370); 
            
            
            ///3 rounds 
            g.setColor(new Color(234,110,130));
              g.fillRect(230, 330, 160, 60);
            
            g.setColor(Color.white);
          
           
            g.drawString("5 Rounds",233,370); 
            
        
             g.setColor(new Color(234,182,130));
                 g.fillRect(433, 330, 160, 60);
            
           
            
            ///////////////////
            
             g.setColor(new Color(234,182,130));
                 g.fillRect(230, 230, 160, 60);
            
            g.setColor(Color.white);
            
            g.drawString("1 Round",233,270);
            
/////////////////////////////////////
            g.drawString("7 Rounds",436,370); 
            
            
            g.setColor(new Color(234,182,130));
            g.fillRect(70, 460, 290, 100);
            
            g.setColor(Color.white);
            g.setFont(new Font("Verdana",Font.BOLD,80));  
           
            g.drawString("RULES",74,540); 
            
//            String fonts[]
//        = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//
//for (int i = 0; i < fonts.length; i++) {
//    System.out.println(fonts[i]);
//}
        }
         
        if(RulesMenu){ 
            g.setColor(new Color(244,207,128));
            g.fillRect(0, 0, Window.xsize, Window.ysize);
            
            g.setColor(Color.white);
            g.setFont(new Font("MS UI Gothic",Font.BOLD,70));  
            g.drawString("RULES",20,100); 
            
            g.setFont(new Font("MS UI Gothic",Font.BOLD,30));  
            g.drawString("//BLUE Player Starts first, " ,100,200); 
            g.drawString("order follows a counter - clockwise rotation " ,10,250); 
            
            g.setFont(new Font("MS UI Gothic",Font.BOLD,40));  
            g.drawString("ORDER",100,150); 
            
             g.setFont(new Font("MS UI Gothic",Font.BOLD,40));  
            g.drawString("WINS",100,320); 
            
            g.setFont(new Font("MS UI Gothic",Font.BOLD,30));  
            g.drawString("//Win by 3 SAME COLOR pieces in: ",100,370); 
             g.drawString(" Concentric order  ",10,420); 
             g.drawString(" Acending or decending order (3 in a row) ",10,460); 
             g.drawString(" Same sized peices (3 in a row)",10,500); 
             
             
            g.setColor(new Color(230,0,20));
            g.fillOval(27, 630, 90, 60);
            
            g.setColor(Color.white);
            g.setFont(new Font("Verdana",Font.BOLD,30));  
           
            g.drawString("Back",30,670); 
             
               g.setFont(new Font("MS UI Gothic",Font.BOLD,40));  
              g.drawString("Rounds",100,540);        
              g.setFont(new Font("MS UI Gothic",Font.BOLD,20));  
              g.drawString("// Go for as many rounds as you choose",100,570); 
               g.drawString("//Player who wins in the round gets points ",100,590); 
               g.drawString("added on to their total score",100,610); 
               g.drawString("//Player who has the most points at the end WINS ! ",100,630); 
              
          }
        
       
        if (EndMenu == true){
         Color Blue = new Color(82,96,224);  
         Color NavyBlue = new Color(19,122,172);
        Color Yellow = new Color(211,202,20); 
        Color Red = new Color(194,73,73); 
        Color Green = new Color(37,156,32); 
        Color Black = Color.BLACK;
        Color White = Color.WHITE;
        
        
        int xdelta = 24;
        int ydelta = 22;
        int highestScore = Board.PlyOneTotScore; 
        boolean MultWin = false;
        Player winner = Player.getPlayer()[0];
        Player winner1 = null;
        Player winner2 = null;
        Player winner3 = null;
        Player winner4 = null;
        
       
        
        if (Board.PlyTwoTotScore >  highestScore){
            highestScore = Board.PlyTwoTotScore;
            winner = Player.getPlayer()[1];     
        }
        if (Board.PlyThreeTotScore >  highestScore){
            highestScore = Board.PlyThreeTotScore;
            winner = Player.getPlayer()[2];
        }
        if (Board.PlyFourTotScore >  highestScore){
            highestScore = Board.PlyFourTotScore;
            winner = Player.getPlayer()[3];
        }
        
        
        
        if (Player.getPlayer()[0] != winner && Board.PlyOneTotScore ==  highestScore){
            MultWin = true;
            winner1 = Player.getPlayer()[0];
        }
        if (Player.getPlayer()[1] != winner && Board.PlyTwoTotScore ==  highestScore){
            winner2 = Player.getPlayer()[1];
             MultWin = true;
        }
        if (Player.getPlayer()[2] != winner && Board.PlyThreeTotScore ==  highestScore){
            winner3 = Player.getPlayer()[2];
             MultWin = true;
        }
        if (Player.getPlayer()[3] != winner && Board.PlyFourTotScore ==  highestScore){
            winner4 = Player.getPlayer()[3];
             MultWin = true;
        }
        
//        else if (Board.PlyTwoTotScore ==  highestScore){
//            winner2 = Player.getPlayer()[1];
//             MultWin = true;
//        }
        
        
        
       
//        else if (Board.PlyThreeTotScore ==  highestScore){
//           winner3 = Player.getPlayer()[2];
//            MultWin = true;
//        }
        
        
//        else if (Board.PlyFourTotScore ==  highestScore){
//             winner4 = Player.getPlayer()[3];
//             MultWin = true;
//        }
        
        
             
             g.setColor(NavyBlue);
            g.fillRect(0, 0, Window.xsize, Window.ysize);
            
            g.setFont(new Font("Helvetica ",Font.BOLD,30));
             g.setColor(Color.BLACK);
            g.drawString("Press (esc) to end game",Window.getX(0*xdelta-15),60);
            
           
            
//                g.setFont(new Font("TimesNewRoman",Font.BOLD,15));
//            if (Player.GetCurrentPlayer().getColor() == Color.YELLOW){
//                 g.setColor(Yellow);                
//            g.drawString("Yellow !",Window.getX(10*xdelta),50); 
//          
//            }
//            else if (Player.GetCurrentPlayer().getColor() == Color.RED){
//                 g.setColor(Red);
//            g.drawString("Red !",Window.getX(10*xdelta),50); 
//        
//            }
//            else if (Player.GetCurrentPlayer().getColor() == Color.BLUE){
//                g.setColor(Blue);
//            g.drawString("Blue !",Window.getX(10*xdelta),50);  
//          
//            }
//            else {
//                g.setColor(Green);
//            g.drawString("Green !",Window.getX(10*xdelta),50);  
//          
//            }
            
            
           if (MultWin){
              g.setFont(new Font("Helvetica ",Font.BOLD,80));
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("Tie",Window.getX(10*xdelta),Window.getX(17*ydelta)); 
            
             if (winner != null)
              g.drawString(winner.getName(),Window.getX(13*xdelta),Window.getX(21*ydelta));
              
//             if (winner1 != null)
//              g.drawString(winner1.getName(),Window.getX(13*xdelta),Window.getX(18*ydelta));
             
              if (winner2 != null)
              g.drawString(winner2.getName(),Window.getX(13*xdelta),Window.getX(24*ydelta));
              
              if (winner3 != null)
              g.drawString(winner3.getName(),Window.getX(13*xdelta),Window.getX(27*ydelta));
              
              if (winner4 != null)
              g.drawString(winner4.getName(),Window.getX(13*xdelta),Window.getX(30*ydelta));
           }
           else {
            g.setFont(new Font("Helvetica ",Font.BOLD,80));
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("Congrats",Window.getX(10*xdelta),Window.getX(17*ydelta));
            
            g.drawString(winner.getName(),Window.getX(13*xdelta),Window.getX(23*ydelta));
                   }
            
            g.setColor(White);
             g.setFont(new Font("Helvetica ",Font.BOLD,120));
            g.drawString("Otrio !",Window.getX(4*xdelta),Window.getX(8*ydelta));
               g.setFont(new Font("Helvetica ",Font.BOLD,30));
               
               
            g.drawString("Final Scores",Window.getX(0*xdelta),Window.getX(17*ydelta));
            
            
              
            g.setColor(Blue);
            g.drawString("Blue = " + Board.PlyOneTotScore  ,Window.getX(0*xdelta),Window.getX(20*ydelta));
            
            g.setColor(Yellow);
            g.drawString("Yellow = " + Board.PlyTwoTotScore,Window.getX(0*xdelta),Window.getX(23*ydelta));
            
            g.setColor(Red);
            g.drawString("Red = " + Board.PlyThreeTotScore,Window.getX(0*xdelta),Window.getX(26*ydelta));
            
            g.setColor(Green);
            g.drawString("Green = " + Board.PlyFourTotScore,Window.getX(0*xdelta),Window.getX(29*ydelta));
        }
         
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .02;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Player.Reset();
        Board.Reset();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            
            gameBoard = Toolkit.getDefaultToolkit().getImage("./WB1.jpg");
            
            
            
            reset();        
        }
        
        if (Board.TimeCountStart)
        timeCount++;
        
        

        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}

 