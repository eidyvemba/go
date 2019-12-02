/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Particle extends GameObject{
    protected Color color;
    protected int tick;
    protected int tickDelay;

    public Particle() { }

    public Particle(double x, double y, double dx, double dy, Color c) { this(x, y, dx, dy, 1, 1, c); }

    public Particle(double x, double y, double dx, double dy, int w, int h, Color c) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.color = c;
        this.width = w;
        this.height = h;
        tick = 0;
        tickDelay = 90;
    }

    public boolean update() {
        x += dx + Math.random() * 3 - 1.5;
        y += dy + Math.random() * 3 - 1.5;
        tick++;
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(255 - tick * 255 / tickDelay));
        return tick == tickDelay;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawOval((int)x - width / 2, (int)y - height / 2, width, height);
    }
}
