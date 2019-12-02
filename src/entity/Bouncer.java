/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: Bola (player)
 * File: Bouncer.java
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import handlers.LevelData;

public class Bouncer extends GameObject{
    private int impulse;
	
    public Bouncer() {
        color = new Color(128, 255, 128, 64);
        colorBorder = new Color(color.getRed(), color.getGreen(), color.getBlue());
        impulse = 128;
    }
    
    public Bouncer(int x, int y, int width, int height) { this(x, y, width, height, new Color(128, 255, 128, 64)); }
	
    public Bouncer(int x, int y, int width, int height, double dx, double dy) {
        this(x, y, width, height, new Color(128, 255, 128, 64));
        this.dx = dx;
        this.dy = dy;
    }
	
    public Bouncer(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = c;
        colorBorder = new Color(color.getRed(), color.getGreen(), color.getBlue());
        impulse = 128;
    }
	
    public int getImpulse() { return impulse; }

    public void setImpulse(int i) { impulse = i; }

    public void update() {
        x += dx;
        y += dy;
        if(x - width / 2 < 0 && dx < 0) dx = -dx;
        if(x + width / 2 > 640 && dx > 0) dx = -dx;
        if(y - height / 2 < 0 && dy < 0) dy = -dy;
        if(y + height / 2 > 480 && dy > 0) dy = -dy;
    }

    public void draw(Graphics2D g) {
        g.setStroke(LevelData.STROKE_2);
        drawCircle(g);
    }
}
