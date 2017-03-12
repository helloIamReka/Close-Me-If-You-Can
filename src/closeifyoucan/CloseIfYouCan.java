package closeifyoucan;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class CloseIfYouCan extends JFrame implements MouseMotionListener {
    public JButton btClose = new JButton ("Close");
    public Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
    public Point loc = btClose.getLocation();
    
    
public CloseIfYouCan() {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);       // cannot be closed by clicking on the X
    setResizable(false);
    setTitle("Hello");
    setBounds(sSize.width/2-200, sSize.height/2-150, 400, 300);
    setLayout(new FlowLayout());
    add(btClose);
    setVisible(true);
    addMouseMotionListener(this);
        
}    

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point loc = btClose.getLocation(); 
        int x = e.getX();
        int y = e.getY();
        if (Math.abs(loc.x - x) < 50 || Math.abs(loc.y - y) < 50){          // increase window size when mouse moves near
            setBounds(sSize.width/2-400, sSize.height/2-300, 800, 600);
         }
        if (Math.abs(loc.x - x)<30 || Math.abs(loc.y - y)<30){
            moveIt ();
         }
    }

    
    public void moveIt(){
        Point loc = btClose.getLocation();
        int whichDir = (int) (Math.random()*4);
        int whichDist = (int) (Math.random()*100);
        switch (whichDir){
        case 0:
            if (loc.y - whichDist >= 0) {
                loc.y -= whichDist; break; }
        case 1:
            if (loc.x - whichDist >= 0) {
                loc.x -= whichDist; break;}
        case 2:
            if (loc.x + btClose.getWidth() + whichDist <= getContentPane().getWidth()){
                loc.x += whichDist; break; }
        case 3:
            if (loc.y + btClose.getHeight() + whichDist <= getContentPane().getHeight())
                loc.y += whichDist; break;
        }
        btClose.setLocation(loc);
        }

    public static void main(String[] args) {
        new CloseIfYouCan();
    }
}

