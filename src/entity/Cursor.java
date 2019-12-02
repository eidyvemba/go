/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: Class para gerenciar o movimento do cursor
 * File: Cursor.java
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import handlers.LevelData;
import handlers.Mouse;

public class Cursor extends GameObject {
    public Cursor() {
        width = height = 10;
        color = new Color(255, 128, 128, 64);
        colorBorder = new Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    public void update() {
        x = Mouse.x;
        y = Mouse.y;
    }

    public void draw(Graphics2D g) {
        g.setStroke(LevelData.STROKE_2);
        drawCircle(g);
    }
}
