/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: class para gerenciar os botões durante o jogo
 * File: GameButton.java
 */
package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;

import handlers.LevelData;

public class GameButton {
    private int x;
    private int y;
    private int width;
    private int height;

    private Font font;
    private String text;
    private GlyphVector gv;
    private int textWidth;
    private int textHeight;

    private boolean hover;
    private boolean active;

    private int type;
    public static final int CENTER = 0;
    public static final int LEFT = 1;

    public GameButton(int x, int y) {
        this.x = x;
        this.y = y;
        active = true;
        type = CENTER;
    }

    public GameButton(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        active = true;
        type = CENTER;
    }

    public void setActive(boolean b) { active = b; }
    public boolean isActive() { return active; }
    public void setType(int i) { type = i; }
    public void setFont(Font f) {  font = f; }
    public void setText(String s) {  setText(s, font); }

    public void setText(String s, Font f) {
        text = s;
        font = f;
        AffineTransform at = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(at, true, true);
        gv = font.createGlyphVector(frc, text);
        textWidth = (int) gv.getPixelBounds(null, 0, 0).width;
        textHeight = (int) gv.getPixelBounds(null, 0, 0).height;
        width = textWidth + 20;
        height = textHeight + 10;
    }

    public boolean isHovered() { return hover; }

    public boolean isHovering(int x, int y) {
        if(type == CENTER) { return x > this.x - width / 2 && x < this.x + width / 2 && y > this.y - height / 2 && y < this.y + height / 2; }
        else if(type == LEFT) { return x > this.x && x < this.x + width && y > this.y - height / 2 && y < this.y + height / 2; }
        return false;
    }

    public void setHover(boolean b) { hover = b; }

    public void draw(Graphics2D g) {
        if(active) g.setColor(Color.BLACK);
        else g.setColor(Color.GRAY);

        if(hover && active) {
            g.setStroke(LevelData.STROKE_2);
            if(type == CENTER) {
                g.drawLine(
                    x - width / 2,
                    y + height / 2 + 4,
                    x + width / 2,
                    y + height / 2 + 4
                );
            }
            else if(type == LEFT) {
                g.drawLine(
                    x,
                    y + height / 2 + 4,
                    x + width,
                    y + height / 2 + 4
                );
            }
        }

        g.setFont(font);
        if(type == CENTER) { g.drawString(text, x - textWidth / 2, y + 10); }
        else if(type == LEFT) {  g.drawString(text, x, y + 10); }
    }
}
