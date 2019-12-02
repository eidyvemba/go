/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package handlers;

import gamestates.GameState;
import gamestates.IntroState;
import gamestates.LevelInfoState;
import gamestates.LevelSelectState;
import gamestates.MenuState;
import gamestates.PlayingState;
import go.GamePanel;

public class GameStateManager {
    private GameState gameState;
    private int currentState;

    public static final int INTRO_STATE = -1;
    public static final int MENU_STATE = 0;
    public static final int LEVEL_INFO_STATE = 1;
    public static final int PLAYING_STATE = 2;
    public static final int LEVEL_SELECT_STATE = 3;

    public GameStateManager() {
        currentState = INTRO_STATE;
        loadState(currentState);
    }

    private void loadState(int state) {
        if(state == INTRO_STATE) gameState = new IntroState(this);
        else if(state == MENU_STATE) gameState = new MenuState(this);
        else if(state == LEVEL_INFO_STATE) gameState = new LevelInfoState(this);
        else if(state == PLAYING_STATE) gameState = new PlayingState(this);
        else if(state == LEVEL_SELECT_STATE) gameState = new LevelSelectState(this);
    }

    public void setState(int state) {
        currentState = state;
        loadState(currentState);
    }

    public void update() { if(gameState != null) gameState.update(); }

    public void draw(java.awt.Graphics2D g) {
        if(gameState != null) gameState.draw(g);
        else {
            g.setColor(java.awt.Color.BLACK);
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
    }
}
