package otrio;


import java.awt.Color;

public class Player {
    
    private static Player currentTurn;
    private static Player players[] = new Player[4];
    private Color color; 
    private String name; 
    

    public static void Reset()
    {
        players[0] = new Player(Color.BLUE, "Blue");
        players[1] = new Player(Color.YELLOW, "Yellow");
        players[2] = new Player(Color.RED, "Red");
        players[3] = new Player(Color.GREEN, "Green");
        currentTurn = players[0];
        
//        players[0] = new Player(Color.red);
//        players[1] = new Player(Color.black);
//        currentTurn = players[0];
    }
    public static Player GetCurrentPlayer()
    {
        return(currentTurn);
    }
    public static void SwitchTurn()
    {
        if (Board.BlueWon || Board.YellowWon || Board.GreenWon ||  Board.RedWon){
            
        if (Board.BlueWon){
            currentTurn = players[0];
            Board.BlueWon = false;
      
        }
        else if (Board.YellowWon){
            currentTurn = players[1];
             Board.YellowWon = false;
        } 
        else if (Board.RedWon){
            currentTurn = players[2];
             Board.RedWon = false;
        }
        else{
            currentTurn = players[3];
             Board.GreenWon = false;
        }
        
        
        }
        
        else{
                    
            if (currentTurn == players[0])
                currentTurn = players[1];
            else if (currentTurn == players[1])
                currentTurn = players[2];
            else if (currentTurn == players[2])
                currentTurn = players[3];
            else
                currentTurn = players[0];
        }
    }    
    
    Player(Color _color, String _name)
    {
        color = _color;
        name = _name;
    }
    public Color getColor()
    {
        return (color);
    }
    
    public static Player[] getPlayer(){
        return (players);
    }
    
     public String getName()
    {
        return (name);
    }
        
}

 