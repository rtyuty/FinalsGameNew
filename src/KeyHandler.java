import java.awt.event.*;
import java.awt.*;


public class KeyHandler implements MouseMotionListener, MouseListener{

    
    public void mouseDragged(MouseEvent e) {
          Screen.mse = new Point((e.getX()) + ((Frame.size.width - Screen.myWidth)/2),(e.getY())+((Frame.size.height -(Screen.myWidth))));
  
    }

    
    public void mouseMoved(MouseEvent e) {
        Screen.mse = new Point((e.getX()) - ((Frame.size.width - Screen.myWidth)/2),(e.getY())-((Frame.size.height -(Screen.myWidth))));
    }

    public void mouseClicked(MouseEvent e) {
     
    }

    
    public void mousePressed(MouseEvent e) {
 
    }

  
    public void mouseReleased(MouseEvent e) {
   
    }

    
    public void mouseEntered(MouseEvent e) {
      
    }

   
    public void mouseExited(MouseEvent e) {
  
    }
    
}
