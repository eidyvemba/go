/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package go;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Go {
    public static JFrame window;	
    public static final int VISIBLE = 0;
    public static final int INVISIBLE = 1;
        
    public static void main(String[] args) {
        window = new JFrame("Go");
        ImageIcon icon;
        
        window.add(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setUndecorated(false);
        
        try{
            icon = new ImageIcon("/src/iconbg.png");
            //window.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/src/iconbg.png")));
            window.setIconImage(icon.getImage());
        }catch(Exception e){}
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    public static void setCursor(int i) {
        Cursor c = null;
        if(i == INVISIBLE) {
            BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            c = Toolkit.getDefaultToolkit().createCustomCursor(bi, new Point(0, 0), ".");
        }
        window.setCursor(c);
    }
    
}
