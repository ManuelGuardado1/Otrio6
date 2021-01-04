         
package otrio;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Board {
    private final static int NUM_CONNECT = 4;
    private final static int NUM_ROWS = 25;
    private final static int NUM_COLUMNS = 25;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private final static int TieNum = 9;
    private static Otrio mainClassInst;
    
//    static int Scores[] = new int[4];
     static int PlyOneTotScore = 0;
     static int PlyTwoTotScore = 0;
     static int PlyThreeTotScore = 0; 
     static int PlyFourTotScore = 0;
    
    static int keepRoundCount = 0;
    private static int keepWinCount = 0;
    private static int NumPoints = 0;
    private static int Rounds = 0;
    
    static int rowBoard;
    static int colBoard;
    
   
    
    static Piece pieceChosen;
    static Piece pieceChosen2;
    private static boolean OutOfBounds;

    
     static boolean YellowWon = false;
     static boolean BlueWon = false;
     static boolean RedWon = false;
     static boolean GreenWon = false;
    
    static boolean oneRound;
    static boolean threeRound;
    static boolean fiveRound;
    static boolean sevenRound;
    static boolean NoWin = true;
    static boolean TimeCountStart;
    Otrio otrio;
    
    
//add or modify.  The TIE state has been added for you.    
    private enum WinState {NO_WIN,WIN_P1,WIN_P2,WIN_P3,WIN_P4,TIE};
    private static WinState winner;
    public static void Reset() {
//Clear the board. 

        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;  
        
        
        
//        board[4][1] = new Piece(Player.GetCurrentPlayer().getColor());


//        board[0][1] = new Piece(Color.BLACK);
//        board[0][2] = new Piece(Color.BLACK);
//        board[0][3] = new Piece(Color.BLACK);

//        board[0][0] = new Piece(Color.RED);

//
//         board[5][5] = new Piece(new Color (188,188,188), Piece.SIZE.BIG);
//         board[6][6] = new Piece(new Color (250,180,170), Piece.SIZE.MEDUIM);
//         board[7][7] = new Piece(new Color (250,180,170), Piece.SIZE.SMALL);
//         
//         board[5][10] = new Piece(new Color (250,180,170), Piece.SIZE.BIG);
//         board[6][11] = new Piece(new Color (250,180,170), Piece.SIZE.MEDUIM);
//         board[7][12] = new Piece(new Color (250,180,170), Piece.SIZE.SMALL);
//         
//         board[5][15] = new Piece(new Color (200,180,150), Piece.SIZE.BIG);
//         board[6][16] = new Piece(new Color (200,180,150), Piece.SIZE.MEDUIM);
//         board[7][17] = new Piece(new Color (200,180,150), Piece.SIZE.SMALL);
//         

     rowBoard = 0;
     colBoard = 0;
    
Otrio.timeCount = 0;   
NumPoints = 0;
  
TimeCountStart = false;


// PlyOneTotScore = 0;
// PlyTwoTotScore = 0;
// PlyThreeTotScore = 0;
// PlyFourTotScore = 0;
    
 NoWin = true;
 oneRound = false;
 threeRound = false;
 fiveRound = false;
          

 
 Otrio.EndMenu = false;
 Otrio.RulesMenu = false;
 
// Player.SwitchTurn();
 if ( keepRoundCount < 3 && keepRoundCount > 0){ 
      Player.SwitchTurn();
 }
 if ( keepRoundCount == 0){ 
     
     Otrio.StartMenu = true;
     
     YellowWon = false;
     BlueWon = false;
     RedWon = false;
     GreenWon = false;
     
 if (Otrio.EndMenu == false){
  PlyOneTotScore = 0;
  PlyTwoTotScore = 0;
  PlyThreeTotScore = 0;
  PlyFourTotScore = 0;
 }
 
 }
 else if ( keepRoundCount == Rounds){
     Otrio.EndMenu = true;
     keepRoundCount = 0;
 }
 
 pieceChosen = null;

 
            
        ////////////////////////////////////////////////////////////////////OUTISIDE
         
         board[0][5] = new Piece(Color.RED, Piece.SIZE.BIG);
         board[1][6] = new Piece(Color.RED, Piece.SIZE.MEDUIM);
         board[2][7] = new Piece(Color.RED, Piece.SIZE.SMALL);
         
         board[0][10] = new Piece(Color.RED, Piece.SIZE.BIG);
         board[1][11] = new Piece(Color.RED, Piece.SIZE.MEDUIM);
         board[2][12] = new Piece(Color.RED, Piece.SIZE.SMALL);
         
         board[0][15] = new Piece(Color.RED, Piece.SIZE.BIG);
         board[1][16] = new Piece(Color.RED, Piece.SIZE.MEDUIM);
         board[2][17] = new Piece(Color.RED, Piece.SIZE.SMALL);
         
         
         
         board[20][5] = new Piece(Color.blue, Piece.SIZE.BIG);
         board[21][6] = new Piece(Color.blue, Piece.SIZE.MEDUIM);
         board[22][7] = new Piece(Color.blue, Piece.SIZE.SMALL);
         
         board[20][10] = new Piece(Color.blue, Piece.SIZE.BIG);
         board[21][11] = new Piece(Color.blue, Piece.SIZE.MEDUIM);
         board[22][12] = new Piece(Color.blue, Piece.SIZE.SMALL);
         
         board[20][15] = new Piece(Color.blue, Piece.SIZE.BIG);
         board[21][16] = new Piece(Color.blue, Piece.SIZE.MEDUIM);
         board[22][17] = new Piece(Color.blue, Piece.SIZE.SMALL);
         
         
         
         board[5][0] = new Piece(Color.GREEN, Piece.SIZE.BIG);
         board[6][1] = new Piece(Color.GREEN, Piece.SIZE.MEDUIM);
         board[7][2] = new Piece(Color.GREEN, Piece.SIZE.SMALL);
         
         board[10][0] = new Piece(Color.GREEN, Piece.SIZE.BIG);
         board[11][1] = new Piece(Color.GREEN, Piece.SIZE.MEDUIM);
         board[12][2] = new Piece(Color.GREEN, Piece.SIZE.SMALL);
         
         board[15][0] = new Piece(Color.GREEN, Piece.SIZE.BIG);
         board[16][1] = new Piece(Color.GREEN, Piece.SIZE.MEDUIM);
         board[17][2] = new Piece(Color.GREEN, Piece.SIZE.SMALL);
         
         
         
         
         board[5][20] = new Piece(Color.YELLOW, Piece.SIZE.BIG);
         board[6][21] = new Piece(Color.YELLOW, Piece.SIZE.MEDUIM);
         board[7][22] = new Piece(Color.YELLOW, Piece.SIZE.SMALL);
         
         board[10][20] = new Piece(Color.YELLOW, Piece.SIZE.BIG);
         board[11][21] = new Piece(Color.YELLOW, Piece.SIZE.MEDUIM);
         board[12][22] = new Piece(Color.YELLOW, Piece.SIZE.SMALL);
         
         board[15][20] = new Piece(Color.YELLOW, Piece.SIZE.BIG);
         board[16][21] = new Piece(Color.YELLOW, Piece.SIZE.MEDUIM);
         board[17][22] = new Piece(Color.YELLOW, Piece.SIZE.SMALL);
         
         
        
         ////////////////////////////////////////////////////////////////////INSIDE
         board[5][5] = new Piece(new Color(241,191,104), Piece.SIZE.BIGBD);
         board[6][6] = new Piece(new Color(241,191,104), Piece.SIZE.MEDUIMBD);
         board[7][7] = new Piece(new Color(241,191,104), Piece.SIZE.SMALL);
         
         board[5][10] = new Piece(new Color(241,191,104), Piece.SIZE.BIGBD);
         board[6][11] = new Piece(new Color(241,191,104), Piece.SIZE.MEDUIMBD);
         board[7][12] = new Piece(new Color(241,191,104), Piece.SIZE.SMALL);
         
         board[5][15] = new Piece(new Color(241,191,104), Piece.SIZE.BIGBD);
         board[6][16] = new Piece(new Color(241,191,104), Piece.SIZE.MEDUIMBD);
         board[7][17] = new Piece(new Color(241,191,104), Piece.SIZE.SMALL);

         board[5][5] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[6][6] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[7][7] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         board[5][10] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[6][11] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[7][12] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         board[5][15] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[6][16] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[7][17] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         
         
         board[15][5] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[16][6] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[17][7] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         board[15][10] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[16][11] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[17][12] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         board[15][15] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[16][16] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[17][17] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
 
         board[10][5] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[11][6] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[12][7] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         board[10][10] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[11][11] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[12][12] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
         board[10][15] = new Piece(new Color(240,190,87), Piece.SIZE.BIGBD);
         board[11][16] = new Piece(new Color(232,185,89), Piece.SIZE.MEDUIMBD);
         board[12][17] = new Piece(new Color(220,170,30), Piece.SIZE.SMALL);
         
      
//         
//         
//         
//       
         

        winner = CheckWin();
    }
    
    
  
      public static void RULES(int xpixel, int ypixel){
          if (xpixel > 42 && xpixel < 334 && ypixel < 419 && ypixel > 320){
        Otrio.RulesMenu = true;
        Otrio.StartMenu = false;
          }
          
    }
      
      public static void RULESBACK(int xpixel, int ypixel){
          if (xpixel > 1 && xpixel < 88 && ypixel < 554 && ypixel > 492){
             Otrio.StartMenu = true;
             Otrio.RulesMenu = false;
          }
          
    }
      
       public static void OtrioEndGame(int xpixel, int ypixel){
          if (xpixel > 42 && xpixel < 334 && ypixel < 419 && ypixel > 320)
             Otrio.RulesMenu = true;
    }
      
      
      public static void threeRound(int xpixel, int ypixel){
          if (xpixel > 0 && xpixel < 148 && ypixel < 248 && ypixel > 191){
                oneRound = true;
                Otrio.StartMenu = false;
                Rounds = 3;
          }
    }
      
       public static void oneRound(int xpixel, int ypixel){
          if (xpixel > 203 && xpixel < 360 && ypixel < 150 && ypixel > 91){
                threeRound = true;
                Otrio.StartMenu = false;
                Rounds = 1;
          }
    }
      
      public static void fiveRound(int xpixel, int ypixel){
          if (xpixel > 203 && xpixel < 360 && ypixel < 248 && ypixel > 191){
                threeRound = true;
                Otrio.StartMenu = false;
                Rounds = 5;
          }
    }
      
      public static void SevenRound(int xpixel, int ypixel){
          if (xpixel > 405 && xpixel < 563 && ypixel < 248 && ypixel > 191){
                fiveRound = true;   
                Otrio.StartMenu = false;
                Rounds = 7;
          }
   
    }
      
   
      
      
    
    public static void ChoosePiece(int xpixel, int ypixel){
   

        if (CheckWin() != WinState.NO_WIN && CheckWin() == WinState.TIE)
            return;
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        int column = xpixel/(xdelta);   
        int row = ypixel/(ydelta);
        
         if ((xpixel >= Window.getWidth2()*.2 && xpixel < Window.getWidth2()*.8 ) && ypixel >= Window.getHeight2()*.2 && ypixel < Window.getHeight2()*.8){ 
             return;
         }

        if (OutOfBounds(row,column))
            return;
        

        
       int i = 0;
        while(i < NUM_COLUMNS && pieceChosen == null) 
            if (column >= i && column<(i+NUM_COLUMNS/5) && column != i+1 && column != i+2 && column != i+3 ){
                 column = i; 
                   int s = 0;
                        while(s < NUM_COLUMNS)
                            if (row >= s && row<(s+NUM_COLUMNS/5)){
                                 row = s;
                                 if (board[row][column] != null){
                                 if (board[row][column].getColor() == Player.GetCurrentPlayer().getColor()){
                               pieceChosen =  board[row][column];
                               rowBoard = row;
                               colBoard = column;
                               TimeCountStart = true;
                               board[row][column] = null; 
//                               }
                               return;
                                 }
                                 else 
                                    return;
                                 }
                                 else 
                                     return;
                            }
                            else
                                s+=(NUM_COLUMNS/5);    
            }
            
            
            else if (column == i+1 || column == i+2 || column == i+3){  
                if ( column == i+1 || column == i+3){
                 column = i+1; 
                }
                   int s = 0;
                        while(s < NUM_COLUMNS)
                            if ((row == s+1 || row == s+3) && column != i+2 ){ 
                               row = s+1;
                                  if (board[row][column] != null){
                               if ( board[row][column].getColor() == Player.GetCurrentPlayer().getColor()){
                               pieceChosen =  board[row][column];
                               rowBoard = row;
                               colBoard = column;
                               board[row][column] = null;
                               TimeCountStart = true;
                               
                               return;
                               }
                               else 
                                   return;
                                  }
                                  return;
                            }    
                            
                            
                            else if (row == s+2 && column == i+2 ){ 
                            
                               column = i+2;  
                               row = s+2;
                                  if (board[row][column] != null){
                               if (board[row][column].getColor() == Player.GetCurrentPlayer().getColor()){
                                    pieceChosen =  board[row][column];
                                    rowBoard = row;
                                    colBoard = column;
                                    board[row][column] = null; 
                                  
                                    TimeCountStart = true;
                                    return;
                               }
                                    else
                                         return;
                                  }
                                  else return;
                            } 
                            
                            
                            else if (row == s+2 && (column == i+1 || column == i+3)){ 
                            
                               row = s+1;
                                  if (board[row][column] != null){
                               if ( board[row][column].getColor() == Player.GetCurrentPlayer().getColor()){
                                    pieceChosen =  board[row][column];
                                    rowBoard = row;
                                    colBoard = column;
                                    board[row][column] = null; 
                                     TimeCountStart = true;
                                    return;
                               }
                               else
                                   return;
                                  }
                                  return;
                            } 
                            
                            else if (column == i+2 && (row == s+1 || row == s+3)){ 
                              
                               row = s+1;
                               column = i+1;
                                  if (board[row][column] != null){
                                if ( board[row][column].getColor() == Player.GetCurrentPlayer().getColor()){
                               pieceChosen =  board[row][column];
                               rowBoard = row;
                               colBoard = column;
                               board[row][column] = null; 
                                TimeCountStart = true;
                               return;
                                }
                                else
                                    return;
                                  }
                                  return;
                            } 
                     
                             
                            else if (row != s+1  && row != s+2 && row != s+3  && row >= s && row<(s+NUM_COLUMNS/5)){
                               
                                row = s;
                                column = i;
                                   if (board[row][column] != null){
                                if (board[row][column].getColor() == Player.GetCurrentPlayer().getColor()){
                                 pieceChosen =  board[row][column];
                                 rowBoard = row;
                                 colBoard = column;
                                 board[row][column] = null;
                                 TimeCountStart = true;

                                 
                                 return;   
                                }
                                else 
                                  return;
                                   }
                                   return;
                                
                            }
                            else 
                               s+=(NUM_COLUMNS/5);        
            }
            
            
            else
               i+=(NUM_COLUMNS/5); 
           
    }
    
    
     public static void PlacePiecePixel(int xpixel, int ypixel){
        
     
         
           if (CheckWin() != WinState.NO_WIN && CheckWin() == WinState.TIE)
            return;
          
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        int column = xpixel/(xdelta);   
        int row = ypixel/(ydelta);

         
             
        
        
         if ((xpixel >= Window.getWidth2()*.2 && xpixel < Window.getWidth2()*.8 ) && ypixel >= Window.getHeight2()*.2 && ypixel < Window.getHeight2()*.8){         
                   
        if (board[row][column] != null)
            if ((board[row][column].getColor() == Color.BLUE || board[row][column].getColor() == Color.YELLOW || board[row][column].getColor() == Color.RED || board[row][column].getColor() == Color.GREEN))
            return;
        
// 
//         return;
//        if (board[row][column].getColor() == new Color(240,190,87) || board[row][column].getColor() == new Color(232,185,89) || board[row][column].getColor() == new Color(220,170,30))
//            return;
        
       int i = 0;
        while(i < NUM_COLUMNS && pieceChosen != null) 
            if (column >= i && column<(i+NUM_COLUMNS/5) && column != i+1 && column != i+2 && column != i+3 && pieceChosen.getSize() == Piece.SIZE.BIG){
                 column = i; 
                   int s = 0;
                        while(s < NUM_COLUMNS)
                            if (row >= s && row<(s+NUM_COLUMNS/5)){
                                 row = s;
                                   if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
                                board[row][column] = pieceChosen;
                                pieceChosen = null; 
                                Player.SwitchTurn(); 
                               Otrio.timeCount = 0; 
                               return;
                                    }
                                    else 
                                        return;
                            }
                            else
                                s+=(NUM_COLUMNS/5);    
            }
            
            else if (column >= i && column<(i+NUM_COLUMNS/5) && column != i+1 && column != i+2 && column != i+3 && pieceChosen.getSize() != Piece.SIZE.BIG){
              return;
            }
            
            
             else if (column == i+1 || column == i+2 || column == i+3){  
                if ( column == i+1 || column == i+3){
                 column = i+1; 
                }
                   int s = 0;
                        while(s < NUM_COLUMNS)
                            if (((row == s+1 || row == s+3 ) && column != i+2) && pieceChosen.getSize() == Piece.SIZE.MEDUIM ){    
                               row = s+1;
                                      if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
                                board[row][column] = pieceChosen;
                                pieceChosen = null; 
                                Otrio.timeCount = 0;
                                Player.SwitchTurn(); 
                                return;
                                    }
                                    else 
                                        return;
                            }  
                            else if ((row == s+1 || row == s+3) && pieceChosen.getSize() != Piece.SIZE.MEDUIM ){                        
                               return;
                            }    
                            
                            
                             else if ((row == s+2 && column == i+2) && pieceChosen.getSize() == Piece.SIZE.SMALL ){ 
                               column = i+2;  
                               row = s+2;
                                  if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
//                                           if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
                                board[row][column] = pieceChosen;
                                pieceChosen = null; 
                                Otrio.timeCount = 0;
                                Player.SwitchTurn(); 
                                return;
                                            
                                    }
                                    else 
                                        return;
                            } 
                            else if ((row == s+2 && column == i+2) && pieceChosen.getSize() != Piece.SIZE.SMALL ){  
                               return;
                            } 

                            
                            
                            else if ((row == s+2 && (column == i+1 || column == i+3)) && pieceChosen.getSize() == Piece.SIZE.MEDUIM  ) { 
   
                               row = s+1;
                                   if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
                                board[row][column] = pieceChosen;
                                pieceChosen = null; 
                                Otrio.timeCount = 0;
                                Player.SwitchTurn(); 
                                return;
                                    }
                                    else 
                                        return;
                            } 
                             else if ((row == s+2 && (column == i+1 || column == i+3)) && pieceChosen.getSize() != Piece.SIZE.MEDUIM  ) { 
                               return;
                            } 
                          
                             
                             
                            else if ((column == i+2 && (row == s+1 || row == s+3)) && pieceChosen.getSize() == Piece.SIZE.MEDUIM){ 
                               row = s+1;
                               column = i+1;
                                     if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
                                board[row][column] = pieceChosen;
                                pieceChosen = null; 
                                Otrio.timeCount = 0;
                                Player.SwitchTurn(); 
                                return;
                                    }
                                    else 
                                        return;
                            } 
                             else if ((column == i+2 && (row == s+1 || row == +3)) && pieceChosen.getSize() != Piece.SIZE.MEDUIM){ 
                               return;
                            } 

                             
                             
                            else if (row != s+1  && row != s+2 && row != s+3  && row >= s && row<(s+NUM_COLUMNS/5) && pieceChosen.getSize() == Piece.SIZE.BIG ){
                                row = s;
                                column = i;
                                      if (board[row][column].getColor() != Color.BLUE && board[row][column].getColor() != Color.YELLOW && board[row][column].getColor() != Color.RED && board[row][column].getColor() != Color.GREEN){
                                board[row][column] = pieceChosen;
                                pieceChosen = null; 
                                Otrio.timeCount = 0;
                                Player.SwitchTurn(); 
                                return;
                                    }
                                    else 
                                        return;
                            }
                            else if (row != s+1  && row != s+2 && row != s+3  && row >= s && row<(s+NUM_COLUMNS/5) && pieceChosen.getSize() != Piece.SIZE.BIG ){
                                return;
                            }
                            else 
                               s+=(NUM_COLUMNS/5);        
            } 
            else
               i+=(NUM_COLUMNS/5);          
         }     
     }
     
     public static boolean OutOfBounds(int _row, int _column){
      int column = _column;
              
        if(column < NUM_COLUMNS/5 || column >= NUM_COLUMNS - (NUM_COLUMNS/5))
        {
            int row = _row;
            if ( row < NUM_COLUMNS/5 || row >= NUM_COLUMNS - (NUM_COLUMNS/5)){
                return true;
            }
        }
        else {
         return (false);
        }   
        return false; 
     }

    public static void Draw(Graphics2D g) {
//        Otrio.timeCount++;
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
//          g.fillRect(Window.getX(xdelta) - 3 , Window.getY(ydelta) -3, xdelta*5, ydelta*5);

//Draw the grid.        
  g.setStroke(new BasicStroke(5));
        g.setColor(Color.black);
        for (int zi = 0;zi<=NUM_ROWS;zi+=5)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
//        
        g.setColor(Color.BLACK);
        for (int zi = 0;zi<=NUM_COLUMNS;zi+=5)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
               
//Draw the pieces on the board.        
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null){
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
//                    board[zrow][zcol].drawSmall(g, zrow, zcol,xdelta, ydelta);
                }
            }
        }        
//          g.setColor(new Color(142,200,201));
int time = 15;
Color Blue = new Color(82,96,224);  
Color Yellow = new Color(211,202,20); 
Color Red = new Color(194,73,73); 
Color Green = new Color(37,156,32); 
Color Black = Color.BLACK;



            g.setColor(Black);     
            g.setFont(new Font("Helvetica ",Font.BOLD,15));
            g.drawString("timer = " + (time - Otrio.timeCount/32),Window.getX(0*xdelta),48);
            
            if (Otrio.timeCount == 32*time){  
                Otrio.timeCount = 0; 
                if (pieceChosen != null){
                board[rowBoard][colBoard] = new Piece(pieceChosen.getColor(), pieceChosen.getSize());
                pieceChosen = null;
                Player.SwitchTurn();
                }
                else
                    Player.SwitchTurn();
            }
//             g.drawString("time" + (Otrio.timeCount),180,68);
           
        
            g.setFont(new Font("TimesNewRoman",Font.BOLD,15));
            if (Player.GetCurrentPlayer().getColor() == Color.YELLOW){
                 g.setColor(Yellow);                
            g.drawString("YELLOW's turn",Window.getX(10*xdelta),50); 
          
            }
            else if (Player.GetCurrentPlayer().getColor() == Color.RED){
                 g.setColor(Red);
            g.drawString("RED's turn",Window.getX(10*xdelta),50); 
        
            }
            else if (Player.GetCurrentPlayer().getColor() == Color.BLUE){
                g.setColor(Blue);
            g.drawString("BLUE's turn",Window.getX(10*xdelta),50);  
          
            }
            else {
                g.setColor(Green);
            g.drawString("GREENS's turn",Window.getX(10*xdelta),50);  
          
            }
      ////////////////////////////////////////////////////////////////////////////////////////////////       
          g.setColor(new Color(232,232,232));
          
            g.fillRect(Window.getX(0*xdelta) - 3 , Window.getY(0*ydelta) -3, 5*xdelta, 5*ydelta);
          
                g.setFont(new Font("Helvetica ",Font.BOLD,15));
                g.setColor(new Color(37,156,32));
                g.drawString("Green's Score",Window.getX(0*xdelta) - 3 ,Window.getY(0*ydelta) -3);  
                
                 g.setFont(new Font("Helvetica ",Font.BOLD,70));
                 g.drawString("" + PlyFourTotScore,Window.getX(0*xdelta) + xdelta ,Window.getY(0*ydelta) + ydelta*3);
      ////////////////////////////////////////////////////////////////////////////////////////////////       
         g.setColor(new Color(232,232,232));
         
            g.fillRect(Window.getX(0*xdelta) - 3 , Window.getY(20*ydelta) +3, 5*xdelta, 7*ydelta);
            
                g.setFont(new Font("Helvetica ",Font.BOLD,15));
                g.setColor(new Color(82,96,224));
                g.drawString("Blue's Score",Window.getX(0*xdelta) - 3 ,Window.getY(25*ydelta));  
                
                 g.setFont(new Font("Helvetica ",Font.BOLD,70));
                 g.drawString("" + PlyOneTotScore,Window.getX(0*xdelta) + xdelta  ,Window.getY(23*ydelta));
                
       ////////////////////////////////////////////////////////////////////////////////////////////////  
          g.setColor(new Color(232,232,232));
          
             g.fillRect(Window.getX(20*xdelta) + 3 , Window.getY(0*ydelta) - 3, 7*xdelta, 5*ydelta);
             
                g.setFont(new Font("Helvetica ",Font.BOLD,15));
                g.setColor(new Color(194,73,73));
                g.drawString("Red's Score",Window.getX(20*xdelta) + 3 ,Window.getY(0*ydelta) - 3);
                
                g.setFont(new Font("Helvetica ",Font.BOLD,70));
                g.drawString("" + PlyThreeTotScore,Window.getX(20*xdelta) + xdelta  ,Window.getY(3*ydelta));
                
        ////////////////////////////////////////////////////////////////////////////////////////////////        
         g.setColor(new Color(232,232,232));
         
             g.fillRect(Window.getX(20*xdelta) + 3 , Window.getY(20*ydelta) + 3, 7*xdelta, 7*ydelta);
                
                g.setFont(new Font("Helvetica ",Font.BOLD,15));
                g.setColor(new Color(211,202,20));
                g.drawString("Yellow's Score",Window.getX(20*xdelta) + 3 ,Window.getY(25*ydelta));
                
                g.setFont(new Font("Helvetica ",Font.BOLD,70));
                g.drawString("" + PlyTwoTotScore,Window.getX(20*xdelta) + xdelta  ,Window.getY(23*ydelta));

           ////////////////////////////////////////////////////////////////////////////////////////////////  
//Display if a player has won.
        if (CheckWin() == WinState.WIN_P1) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("TimesNewRoman",Font.BOLD,20));
            g.drawString("BLUE Won !",200,50); 
            keepRoundCount++;
            PlyOneTotScore+=NumPoints;
            BlueWon = true;
            Reset();
      
        }
        if (CheckWin() == WinState.WIN_P2) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesNewRoman",Font.BOLD,20));
            g.drawString("Yellow Won !",200,50); 
            keepRoundCount++;
            PlyTwoTotScore+=NumPoints;
             YellowWon = true;
            Reset();
       
        }
        if (CheckWin() == WinState.WIN_P3) {
            g.setColor(Color.RED);
            g.setFont(new Font("TimesNewRoman",Font.BOLD,20));
            g.drawString("RED Won !",200,50);
            keepRoundCount++;
            PlyThreeTotScore+=NumPoints;
             RedWon = true;
            Reset();
        }
        if (CheckWin() == WinState.WIN_P4) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("TimesNewRoman",Font.BOLD,20));
            g.drawString("GREEN Won !",200,50); 
            keepRoundCount++;
            PlyFourTotScore+=NumPoints;
             GreenWon = true;
            Reset();
        }
        if (CheckTie() == WinState.TIE) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("Round Over",40,65);
            keepRoundCount++;
            Reset();
            
        }
        
       
    }
    
    
 
////////    
//CheckWin now checks the whole board.
    
//add or modify.  The CheckWin method should return a WinState value instead of a boolean value.
//                The diagonal wins have been removed from the code so that you only have to handle
//                horizontal and vertical wins.
    
     public static WinState CheckTie(){
       int isTie = 0;
       int tienum = 0;
 
       for (int row=5;row<NUM_ROWS-6;row+=5)
        {
            for (int col=5;col<NUM_COLUMNS-6;col+=5)
            {
                if (board[row][col] != null){
                    if (board[row][col].getColor() == Color.BLUE || board[row][col].getColor() == Color.YELLOW || board[row][col].getColor() == Color.RED || board[row][col].getColor() == Color.GREEN )      
                
                {   
                 
                 tienum++;    
                }
                if ( tienum == TieNum){
                    isTie++;
                }
                }
            }              
        }
       
         tienum = 0;
 
       for (int row=6;row<NUM_ROWS-6;row+=5)
        {
            for (int col=6;col<NUM_COLUMNS-6;col+=5)
            {
                 if (board[row][col] != null){
                  if (board[row][col].getColor() == Color.BLUE || board[row][col].getColor() == Color.YELLOW || board[row][col].getColor() == Color.RED || board[row][col].getColor() == Color.GREEN )      
               
                {   
                 
                 tienum++;  
                }
                if ( tienum == TieNum){
                    isTie++;
                }
                 }
            }              
        }
       
        tienum = 0;
 
       for (int row=7;row<NUM_ROWS-6;row+=5)
        {
            for (int col=7;col<NUM_COLUMNS-6;col+=5)
            {
                   
                if (board[row][col] != null){
                    if (board[row][col].getColor() == Color.BLUE || board[row][col].getColor() == Color.YELLOW || board[row][col].getColor() == Color.RED || board[row][col].getColor() == Color.GREEN )
                {   
                 
                 tienum++;     
                }
                if ( tienum == TieNum){
                    isTie++;
                }
                 }
            }              
        }
       
       if (isTie == 3){
           return WinState.TIE;
       }    
      
      return (WinState.NO_WIN);
      
    }
    public static WinState CheckWin()
    {
        
        int ValueCount = 0;
        
        Color colorMatch = null;
        int rowT;
        int colT;
        int keepcount;  
        
        int greenCount = 0;
        
////Check for Tie. 
                 
         rowT = 10;
         colT = 5;
         keepcount = 0;
         colorMatch = null;
           
             while(rowT<NUM_ROWS-5){
                 while (colT<NUM_COLUMNS-5 && colT > 4){ 
              
              
               
                if (board[rowT][colT] == null){ 
                          switch(colT) {
                              case 5:
                              case 10:
                              case 15:
                                  colT += 5;
                                  break;
                              case 6:
                              case 11:
                              case 16:
                                  colT += 4;
                                  rowT --;
                                  break;
                              case 7:
                              case 12:
                              case 17:
                                  colT += 3;
                                  rowT -= 2;
                                  break;
                          }
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                      } 

                 else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT++;
                       rowT++;
                       
   
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                          
                            
                           
                        }
                 }
                
                 else if (board[rowT][colT].getColor() != colorMatch){
                  
                      switch (colT) {
                        case 5:
                        case 10:
                        case 15:
                            break;
                        case 6:
                        case 11:
                        case 16:
                            colT+=4;
                            rowT --;
                            break;
                        case 7:
                        case 12:
                        case 17:
                            colT+=3;
                            rowT -=2;
                            break;            
                            
                    }
                       ValueCount = 0;
                       keepcount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }         
              }

          

         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
      
         
        
             while(rowT<NUM_ROWS-5){
                 while (colT<NUM_COLUMNS-5 && colT > 4){ 
                 
              
               
                if (board[rowT][colT] == null){ 
                          switch(colT) {
                              case 5:
                              case 10:
                              case 15:
                                  colT += 5;
                                  break;
                              case 6:
                              case 11:
                              case 16:
                                  colT += 4;
                                  rowT --;
                                  break;
                              case 7:
                              case 12:
                              case 17:
                                  colT += 3;
                                  rowT -= 2;
                                  break;
                          }
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                      } 

                 else if ( board[rowT][colT].getColor() == colorMatch){
                        ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT++;
                       rowT++;
                       
   
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                 }
                
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 5:
                        case 10:
                        case 15:
                            break;
                        case 6:
                        case 11:
                        case 16:
                            colT+=4;
                            rowT --;
                            break;
                        case 7:
                        case 12:
                        case 17:
                            colT+=3;
                            rowT -=2;
                            break;            
                            
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }         
              }
                 
         rowT = 15;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;

      
         
        
             while(rowT<NUM_ROWS-5){
                 while (colT<NUM_COLUMNS-5 && colT > 4){ 
                 
              
               
                if (board[rowT][colT] == null){ 
                          switch(colT) {
                              case 5:
                              case 10:
                              case 15:
                                  colT += 5;
                                  break;
                              case 6:
                              case 11:
                              case 16:
                                  colT += 4;
                                  rowT --;
                                  break;
                              case 7:
                              case 12:
                              case 17:
                                  colT += 3;
                                  rowT -= 2;
                                  break;
                          }
                         ValueCount = 0;
                         keepcount = 0;    
                         colorMatch = null; 
                      } 

                 else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT++;
                       rowT++;
                       
   
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                 }
                
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 5:
                        case 10:
                        case 15:
                            break;
                        case 6:
                        case 11:
                        case 16:
                            colT+=4;
                            rowT --;
                            break;
                        case 7:
                        case 12:
                        case 17:
                            colT+=3;
                            rowT -=2;
                            break;            
                            
                    }
                       ValueCount = 0;
                       keepcount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }         
              }
       

        //////top to bottom 
         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
        while(rowT<NUM_ROWS-6){
              while (colT<NUM_COLUMNS-6){  
                 if (board[rowT][colT] == null){ 
                    switch (rowT) {
                        case 5:
                            colT+=5;
                            break;
                        case 11:
                            colT+=4;
                            break;
                        default:
                            colT+=3;
                            break;
                    }
                       colorMatch = null;
                       rowT = 5;
                       keepcount = 0;
                       ValueCount = 0;
                 
                     }
                  
                 else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT++;
                       rowT+=6;
                        if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                 
                     } 
                 
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (rowT) {
                        case 5:
                            break;
                        case 11:
                            colT+=4;
                            break;
                        default:
                            colT+=3;
                            break;
                    }
                       rowT = 5;
                       ValueCount = 0;
                       keepcount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
               
                
              }
                   //////bottom to top 
         rowT = 15;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
         
        while(rowT<NUM_ROWS-6){
              while (colT<NUM_COLUMNS-6){
               
                if (board[rowT][colT] == null){ 
                    
                     switch (rowT) {
                        case 15:
                            colT+=5;
                            break;
                        case 11:
                            colT+=4;
                            break;
                        default:
                            colT+=3;
                            break;
                    }
                     colorMatch = null;
                     rowT = 15;
                     keepcount = 0;
                     ValueCount = 0;
                } 
                
                 else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
//                        System.out.println("VC" + ValueCount);
                       keepcount++;
                       colT++;
                       rowT-=4;
                       
                      if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                     }
                       
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (rowT) {
                        case 15:
                            break;
                        case 11:
                            colT+=4;
                            break;
                        default:
                            colT+=3;
                            break;
                    }
                       rowT = 15;
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
               
                
              }
           //////left to right   
         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
             while(rowT<NUM_ROWS-6){
              
               
                if (board[rowT][colT] == null){ 
                    
                     switch (colT) {
                        case 5:
                            rowT+=5;
                            break;
                        case 11:
                            rowT+=4;
                            break;
                        default:
                            rowT+=3;
                            break;
                    }
                     colorMatch = null;
                     colT = 5;
                     keepcount = 0;
                     ValueCount = 0;
                } 
                
                 else if ( board[rowT][colT].getColor() == colorMatch){
                     ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=6;
                       rowT++;
                       
                        if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 5:
                            break;
                        case 11:
                            rowT+=4;
                            break;
                        default:
                            rowT+=3;
                            break;
                    }
                       colT = 5;
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                         
               
                
              }
             
             
        //////right to left
         rowT = 5;
         colT = 15;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
              
               
                if (board[rowT][colT] == null){ 
                    
                     switch (colT) {
                        case 15:
                            rowT+=5;
                            break;
                        case 11:
                            rowT+=4;
                            break;
                        default:
                            rowT+=3;
                            break;
                    }
                     colorMatch = null;
                     colT = 15;
                     keepcount = 0;
                     ValueCount = 0;
                } 
                
                 else if ( board[rowT][colT].getColor() == colorMatch){
                     ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT-=4;
                       rowT++;
                       
                        if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                        case 11:
                            rowT+=4;
                            break;
                        default:
                            rowT+=3;
                            break;
                    }
                       colT = 15;
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
          ////Top right to bottom left
         rowT = 5;
         colT = 15;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT-=4;
                       rowT+=6;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
        
         rowT = 15;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       rowT-=4;
                       colT+=6;
                       
                       if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 5:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                
              }
             //////Top left to bottom right
           
         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
              
               
                if (board[rowT][colT] == null){
                   rowT = 20;      
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=6;
                       rowT+=6;
                       
                        if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 5:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                         
                
              }
                     
         //////////////BIG Top Right to bottom left   
         rowT = 5;
         colT = 15;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT-=5;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
            //////////////MED Top Right to bottom left   
         rowT = 6;
         colT = 16;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT-=5;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
         
            //////////////SMA Top Right to bottom left   
             rowT = 7;
         colT = 17;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT-=5;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
            
            
            
            
            
            
           //////////////BIG Top left to bottom right    
         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=5;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
            
             //////////////MED Top left to bottom right  
         rowT = 6;
         colT = 6;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=5;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
            
           //////////////SMA Top left to bottom right    
         rowT = 7;
         colT = 7;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                if (board[rowT][colT] == null){
                    rowT = 20;           
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=5;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
            
              ///////////////////////////////////////////////////////  
         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
       
            while(rowT<NUM_ROWS-6){
                while (colT<NUM_COLUMNS-6){ 
                if (board[rowT][colT] == null){
                   switch (colT) {
                        case 5:
                        case 10:
                        case 15:
                            colT+=5;
                            break;
                    }    
                   
                     switch (rowT) {
                         case 5:
                            break;
                        case 10:
                            colT+=5;
                            rowT-=5;
                            break;
                        case 15:
                            colT+=5;
                            rowT-=10;
                            break;
                    } 
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                     
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                       switch (rowT) {
                         case 5:
                            break;
                        case 10:
                            colT+=5;
                            rowT-=5;
                            break;
                        case 15:
                            colT+=5;
                            rowT-=10;
                            break;
                    } 
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
                
                
         rowT = 6;
         colT = 6;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
       
            while(rowT<NUM_ROWS-6){
                while (colT<NUM_COLUMNS-6){ 
                if (board[rowT][colT] == null){
                   switch (colT) {
                        case 6:
                        case 11:
                        case 16:
                            colT+=5;
                            break;
                    }    
                   
                     switch (rowT) {
                         case 6:
                            break;
                        case 11:
                            colT+=5;
                            rowT-=5;
                            break;
                        case 16:
                            colT+=5;
                            rowT-=10;
                            break;
                    } 
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                     
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                       switch (rowT) {
                         case 6:
                            break;
                        case 11:
                            colT+=5;
                            rowT-=5;
                            break;
                        case 16:
                            colT+=5;
                            rowT-=10;
                            break;
                    } 
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
                
         rowT = 7;
         colT = 7;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
       
            while(rowT<NUM_ROWS-6){
                while (colT<NUM_COLUMNS-6){ 
                if (board[rowT][colT] == null){
                   switch (colT) {
                        case 7:
                        case 12:
                        case 17:
                            colT+=5;
                            break;
                    }    
                   
                     switch (rowT) {
                         case 7:
                            break;
                        case 12:
                            colT+=5;
                            rowT-=5;
                            break;
                        case 17:
                            colT+=5;
                            rowT-=10;
                            break;
                    } 
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                     
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       rowT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                       switch (rowT) {
                         case 7:
                            break;
                        case 12:
                            colT+=5;
                            rowT-=5;
                            break;
                        case 17:
                            colT+=5;
                            rowT-=10;
                            break;
                    } 
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
                
                
                
                
            /////////////////////////////////////////////////////    
         rowT = 5;
         colT = 5;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
       while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                
                if (board[rowT][colT] == null){
                   switch (rowT) {
                        case 5:
                        case 10:
                        case 15:
                            rowT+=5;
                            break;
                    }    
                   
                     switch (colT) {
                         case 5:
                            break;
                        case 10:
                            rowT+=5;
                            colT-=5;
                            break;
                        case 15:
                            rowT+=5;
                            colT-=10;
                            break;
                    } 
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                     
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                       switch (colT) {
                         case 5:
                            break;
                        case 10:
                            rowT+=5;
                            colT-=5;
                            break;
                        case 15:
                            rowT+=5;
                            colT-=10;
                            break;
                    } 
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
            
            rowT = 6;
         colT = 6;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
       while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                
                if (board[rowT][colT] == null){
                   switch (rowT) {
                        case 6:
                        case 11:
                        case 16:
                            rowT+=5;
                            break;
                    }    
                   
                     switch (colT) {
                         case 6:
                            break;
                        case 11:
                            rowT+=5;
                            colT-=5;
                            break;
                        case 16:
                            rowT+=5;
                            colT-=10;
                            break;
                    } 
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                     
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                       switch (colT) {
                         case 6:
                            break;
                        case 11:
                            rowT+=5;
                            colT-=5;
                            break;
                        case 16:
                            rowT+=5;
                            colT-=10;
                            break;
                    } 
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
                
            
            rowT = 7;
         colT = 7;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
       while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
                
                if (board[rowT][colT] == null){
                   switch (rowT) {
                        case 7:
                        case 12:
                        case 17:
                            rowT+=5;
                            break;
                    }    
                   
                     switch (colT) {
                         case 7:
                            break;
                        case 12:
                            rowT+=5;
                            colT-=5;
                            break;
                        case 17:
                            rowT+=5;
                            colT-=10;
                            break;
                    } 
                         keepcount = 0;    
                         ValueCount = 0;
                         colorMatch = null; 
                     
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT+=5;
                       
                         if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                       switch (colT) {
                        case 7:
                            break;
                        case 12:
                            rowT+=5;
                            colT-=5;
                            break;
                        case 17:
                            rowT+=5;
                            colT-=10;
                            break;
                    } 
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
                
              }
                
            
            
                
             
            
            
            
            ////bottom right to Top left
         rowT = 15;
         colT = 15;
         keepcount = 0;
         ValueCount = 0;
         colorMatch = null;
         
        while (colT<NUM_COLUMNS-6){ 
            while(rowT<NUM_ROWS-6){
              
               
                if (board[rowT][colT] == null){
                    rowT = 20;        
                }
                
                else if ( board[rowT][colT].getColor() == colorMatch){
                       ValueCount += board[rowT][colT].getValue();
                       keepcount++;
                       colT-=4;
                       rowT-=4;
                       
                       if (keepcount == 3){
                            if (colorMatch == Color.BLUE){  
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P1);
                            }                             
                            if (colorMatch == Color.YELLOW ){
                                  NumPoints = ValueCount;
                            return (WinState.WIN_P2);        
                            } 
                            if (colorMatch == Color.RED){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P3); 
                            }
                            if (colorMatch == Color.GREEN){
                                  NumPoints = ValueCount;
                           return (WinState.WIN_P4);
                            }
                 }
                        
                     } 
                  
                 else if (board[rowT][colT].getColor() != colorMatch){
                      switch (colT) {
                        case 15:
                            break;
                        default:
                            return (WinState.NO_WIN); 
                    }
                       keepcount = 0;
                       ValueCount = 0;
                       if (board[rowT][colT] != null)
                       colorMatch = board[rowT][colT].getColor();
                           
                 }
                           
            
                
              }
        
          
         
            return WinState.NO_WIN;
        }  
        }
        }
        }
        }
        }
        }
        }
        }
        }
        
        
        
        
        
        
        
        
        
        }
        }
        }
        }
        }                  
        }             
        }       
        } 
        
        } 
        
    }   
        
    }    

}
} 
  return (WinState.NO_WIN);  
}
}

 






