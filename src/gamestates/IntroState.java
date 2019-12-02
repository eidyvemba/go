/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import handlers.GameStateManager;
import handlers.ImageLoader;
import handlers.Keys;
import handlers.Mouse;
import go.GamePanel;

public class IntroState extends GameState{
    private BufferedImage logo;
    private int logox;
    private int logoy;
    private int logow;
    private int logoh;
    private int alpha;
    private int ticks;

    private final int FADE_IN = 90;
    private final int LENGTH = 90;
    private final int FADE_OUT = 90;

    public IntroState(GameStateManager gsm) {
        super(gsm);
        init();
    }

    public void init() {
        ticks = 0;
        logo = ImageLoader.LOGO;
        logoh = GamePanel.HEIGHT;
        logow = logo.getWidth() * (logoh / logo.getHeight());
        logox = (GamePanel.WIDTH - logow) / 2;
        logoy = 0;
    }

    public void update() {
        handleInput();
        ticks++;
        if(ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if(alpha < 0) alpha = 0;
        }
        if(ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if(alpha > 255) alpha = 255;
        }
        if(ticks > FADE_IN + LENGTH + FADE_OUT) { gsm.setState(GameStateManager.MENU_STATE); }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.drawImage(logo, logox, logoy, logow, logoh, null);
        g.setColor(new Color(255, 255, 255, alpha));
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }

    public void handleInput() {
        if(Keys.isPressed(Keys.ENTER)) { gsm.setState(GameStateManager.MENU_STATE); }
        if(Mouse.isPressed()) { gsm.setState(GameStateManager.MENU_STATE); }
    }
}
