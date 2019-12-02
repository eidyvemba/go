/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import handlers.GameStateManager;
import handlers.LevelData;
import handlers.Mouse;
import go.GamePanel;

public class LevelInfoState extends GameState{
    private Color color;
    private String[] descriptions;
    private Font dFont;
    private int fadeDelay;
    private int fadeInTimer;
    private int fadeInDelay;
    private int fadeOutTimer;
    private int fadeOutDelay;
    private int alpha;

    public LevelInfoState(GameStateManager gsm) {
        super(gsm);
        init();
    }

    public void init() {
        color = Color.BLACK;
        fadeInTimer = 0;
        fadeInDelay = 60;
        fadeOutTimer = -1;
        fadeOutDelay = 60;
        descriptions = LevelData.getDescription();
        dFont = LevelData.LEVEL_INFO_FONT.deriveFont(14f);
        fadeDelay = 90 + descriptions.length * 30;

    }

    public void update() {
        handleInput();
        if(fadeInTimer >= 0) {
            fadeInTimer++;
            alpha = (int) (255.0 * fadeInTimer / fadeInDelay);
            if(fadeInTimer == fadeDelay) {
                fadeInTimer = -1;
                fadeOutTimer = 0;
            }
        }
        if(fadeOutTimer >= 0) {
            fadeOutTimer++;
            alpha = (int) (255.0 * fadeOutTimer / fadeOutDelay);
            if(fadeOutTimer == fadeOutDelay) { gsm.setState(GameStateManager.PLAYING_STATE); }
        }
        if(alpha < 0) alpha = 0;
        if(alpha > 255) alpha = 255;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setFont(LevelData.LEVEL_INFO_FONT);
        g.drawString(LevelData.getLevel(), 20, 220);
        g.setStroke(LevelData.STROKE_1);
        g.drawLine(15, 225, 300, 225);
        g.setFont(dFont);
        for(int i = 0; i < descriptions.length; i++) { g.drawString(descriptions[i], 20, 250 + 20 * i); }

        if(fadeInTimer >= 0) {
            g.setColor(new Color(255, 255, 255, 255 - alpha));
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
        if(fadeOutTimer >= 0) {
            g.setColor(new Color(255, 255, 255, alpha));
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
    }

    public void handleInput() {
        if(Mouse.isPressed() && fadeOutTimer == -1) {
            fadeInTimer = -1;
            fadeOutTimer = 0;
        }
    }
}
