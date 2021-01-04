
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otrio;


/**
 *
 * @author jeffreyyee
 */
public class Window {
    private static final int XBORDER = 20;
//    private static final int YBORDER = 20;
    private static final int TOP_BORDER = 40;
    private static final int BOTTOM_BORDER = 10;
    private static final int YTITLE = 100;
    private static final int WINDOW_BORDER = 8;
    
    
    static final int WINDOW_WIDTH = 2*(WINDOW_BORDER + XBORDER) + 600;
    static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 600;
    static int xsize = -1;
    static int ysize = -1;


/////////////////////////////////////////////////////////////////////////
    public static int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }

    public static int getY(int y) {
//        return (y + YBORDER + YTITLE );
        return (y + TOP_BORDER + YTITLE );
        
    }

    public static int getYNormal(int y) {
//          return (-y + YBORDER + YTITLE + getHeight2());
      return (-y + TOP_BORDER + YTITLE + getHeight2());
        
    }
    
    public static int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }

    public static int getHeight2() {
//        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
        return (ysize - (BOTTOM_BORDER + TOP_BORDER) - WINDOW_BORDER - YTITLE);
    }    
    

}