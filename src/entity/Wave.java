/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import handlers.LevelData;

public class Wave extends Particle {
    public Wave(double x, double y, int width, Color c) {
        this.x = x;
        this.y = y;
        this.width = this.height = width;
        this.color = c;
        tick = 0;
        tickDelay = 90;
    }
	
    public void setTickDelay(int i) { tickDelay = i; }
	
    public boolean update() {
        width++;
        height++;
        tick++;
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(255 - tick * 255 / tickDelay));
        return tick == tickDelay;
    }

    public void draw(Graphics2D g) {
        g.setStroke(LevelData.STROKE_2);
        super.draw(g);
    }
}
