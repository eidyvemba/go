/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: Class para gerenciar Pontuação
 * File: Goal.java
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import handlers.ParticleFactory;
public class Goal extends GameObject {
    private int tick;
	
    public Goal() {
        width = height = 85;
        color = new Color(255, 128, 128, 64);
        colorBorder = new Color(color.getRed(), color.getGreen(), color.getBlue());
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
