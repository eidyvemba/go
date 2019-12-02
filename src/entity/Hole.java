/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import handlers.ParticleFactory;

public class Hole extends GameObject{
    private int tick;
	
    public Hole() {
        width = height = 100;
        color = new Color(0, 0, 0, 64);
        colorBorder = Color.BLACK;
        tick = 0;
    }

    public Hole(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = new Color(0, 0, 0, 64);
        colorBorder = Color.BLACK;
        tick = 0;
    }

    public void update() {
        tick++;
        if(tick == 60) {
            tick = 0;
            ParticleFactory.createWave(x, y, width, color);
        }
    }

    public void draw(Graphics2D g) { drawCircleNoBorder(g); }
}
