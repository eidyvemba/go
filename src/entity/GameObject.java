/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: Class para gerenciar os objetos do jogo
 * File: GameObject.java
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameObject {
    protected double x;
    protected double y;

    protected double dx;
    protected double dy;

    protected int width;
    protected int height;

    protected Color color;
    protected Color colorBorder;

    protected GameObject() {}

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(GameObject o) {
        this.x = o.getx();
        this.y = o.gety();
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getx() { return x; }
    public double gety() { return y; }
    public double getdx() { return dx; }
    public double getdy() { return dy; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void flipHorizontal() { dx = -dx; }
    public void flipVertical() { dy = -dy; }

    public boolean intersects(GameObject o) {  return getRectangle().intersects(o.getRectangle()); }

    public boolean intersectsCircle(GameObject o) {
        double dx = x - o.getx();
        double dy = y - o.gety();
        double dist2 = dx * dx + dy * dy;
        return dist2 < ((width + o.getWidth()) / 2) * ((width + o.getWidth()) / 2);
    }

    public boolean contains(GameObject o) { return getRectangle().contains(o.getRectangle()); }

    public boolean containsCircle(GameObject o) {
        double dx = x - o.getx();
        double dy = y - o.gety();
        double dist = Math.sqrt(dx * dx + dy * dy);
        return dist + o.getWidth() / 2 < width / 2;
    }

    public Rectangle getRectangle() { return new Rectangle((int) x - width / 2, (int) y - height / 2, width, height); }

    public void drawCircle(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) x - width / 2, (int) y - height / 2, width, height);
        g.setColor(colorBorder);
        g.drawOval((int) x - width / 2, (int) y - height / 2, width, height);
    }

    public void drawCircleNoBorder(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) x - width / 2, (int) y - height / 2, width, height);
    }
}
