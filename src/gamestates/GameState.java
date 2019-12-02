/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package gamestates;

import java.awt.Graphics2D;
import handlers.GameStateManager;

public abstract class GameState {
    protected GameStateManager gsm;
	
    public GameState(GameStateManager gsm) { this.gsm = gsm; }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics2D g);
    public abstract void handleInput();
}
