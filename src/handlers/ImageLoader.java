/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package handlers;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageLoader {
    public static BufferedImage LOGO = load("/src/logo.gif");
    public static BufferedImage BG = load("/src/menubg.png");
    public static BufferedImage BG2 = load("/src/menubggame.png");
    public static BufferedImage STAR = load("/src/star.png");
    public static BufferedImage STAROUTLINE = load("/src/staroutline.png");

    private static BufferedImage load(String s) {
        BufferedImage image = null;
        try { image = ImageIO.read(ImageLoader.class.getResourceAsStream(s)); }
        catch(Exception e) { e.printStackTrace(); }
        return image;
    }
}
