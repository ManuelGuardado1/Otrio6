package otrio;

import java.awt.*;

public class Piece {
    private Color color;
    private SIZE size;
    private int ranValue;
    
//add or modify.  Enum added for you to use for enhancement 1.
    public static enum SIZE {BIG,SMALL,MEDUIM, BIGBD, MEDUIMBD, SMALLBD};    
    
    Piece(Color _color, SIZE _size)
    {
        color = _color;
        size = _size;
        ranValue = (int)(Math.random()*3+1);
    }
    public Color getColor()
    {
        return (color);
    }
    
    public SIZE getSize()
    {
        return (size);
    }
    
     public int getValue()
    {
        return (ranValue);
    }

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
     
           if (size == SIZE.BIG) {
                g.setStroke(new BasicStroke(6));
                g.setColor(color);
                g.drawOval(Window.getX(column*xdelta) + 5, Window.getY(row*ydelta) + 5, xdelta*5 - 10, ydelta*5 - 10) ;
                return;
           }       
           
           else if ( size == SIZE.MEDUIM){
                g.setStroke(new BasicStroke(6));
                g.setColor(color);
                g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta*3, ydelta*3);
                return;
           }
           else if (size == SIZE.SMALL){
//                g.setStroke(new BasicStroke(10));
                g.setColor(color);
                g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
                return;
           }
           
           if (size == SIZE.BIGBD) {
                g.setStroke(new BasicStroke(6));
                g.setColor(color);
                g.drawOval(Window.getX(column*xdelta) + 5, Window.getY(row*ydelta) + 5, xdelta*5 - 10, ydelta*5 - 10);
                return;
           } 
        
           else if (size == SIZE.MEDUIMBD){
           g.setStroke(new BasicStroke(6));
                g.setColor(color);
                g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta*3, ydelta*3);
                return;
           }
            else if (size == SIZE.SMALLBD) {
                g.setStroke(new BasicStroke(6));
                g.setColor(color);
                g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
                return;
           }   
           
           
                
          
           
        
           
           
 
//        else if (ranValue == 1){
//           g.setColor(color);
//           g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta); 
//            return;
//        }
//        else {
//            
//            int xval[] = {Window.getX(column*xdelta), Window.getX(column*xdelta) + xdelta, Window.getX(column*xdelta), Window.getX(column*xdelta)};
//            int yval[] = {Window.getY(row*ydelta), Window.getY(row*ydelta), Window.getY(row*ydelta) + ydelta, Window.getY(row*ydelta)};
//            g.setColor(color);
//            g.fillPolygon(xval, yval, xval.length);
//             
//            return;
//        }
        
        
//        g.setColor(color);
//        g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    
//    public void drawSmall(Graphics2D g,int row,int column,int xdelta,int ydelta) {
//     
//         
//           g.setColor(getColor());
//           g.drawOval(Window.getX(column*xdelta+xdelta), Window.getY(row*ydelta+ydelta), xdelta, ydelta);
//           return;
// 
//    }
//    
    
    
    
    
}

 