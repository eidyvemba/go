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
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entity.Bubble;
import entity.GameButton;
import entity.Star;
import handlers.GameData;
import handlers.GameStateManager;
import handlers.ImageLoader;
import handlers.JukeBox;
import handlers.Keys;
import handlers.LevelData;
import handlers.Mouse;
import go.Go;
import go.GamePanel;


public class LevelSelectState extends GameState {
    private BufferedImage bg;
    private ArrayList<Bubble> bubbles;
    private int bubbleTimer;
    private GameButton[] buttons;
    private int currentChoice;
    private Star[][] stars;
    private Font titleFont;
    private Font font;
    private int fadeInTimer;
    private int fadeInDelay;
    private int fadeOutTimer;
    private int fadeOutDelay;
    private int alpha;
    private int nextState;

    public LevelSelectState(GameStateManager gsm) {
        super(gsm);
        init();
    }
	
    public void init() {
        GameData.load();
        bg = ImageLoader.BG;
        titleFont = LevelData.SC_FONT.deriveFont(46f);
        font = LevelData.SC_FONT.deriveFont(28f);

        buttons = new GameButton[LevelData.MAX_LEVELS];
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new GameButton(50, 130 + 35 * i);
            buttons[i].setFont(font);
            buttons[i].setType(GameButton.LEFT);
            String s = LevelData.getLevel(i * 4);
            s = s.substring(0, s.indexOf("   "));
            s += "  :  " + GameData.getScore(i) + " pontos";
            buttons[i].setText(s);
            if(i >= 7) buttons[i].setActive(false);
        }
        
        stars = new Star[LevelData.MAX_LEVELS][3];
        int[] info = LevelData.getStars();
        for(int i = 0; i < stars.length; i++) {
            for(int j = 0; j < stars[0].length; j++) {
                if(j < info[i]) { stars[i][j] = new Star(480 + 40 * j, 114 + 35 * i, true); }
                else {  stars[i][j] = new Star(480 + 40 * j, 114 + 35 * i, false); }
            }
        }

        Go.setCursor(Go.VISIBLE);

        fadeInTimer = 0;
        fadeInDelay = 60;
        fadeOutTimer = -1;
        fadeOutDelay = 60;

        JukeBox.stop("bgmusic1");
        bubbles = new ArrayList<Bubble>();
        bubbleTimer = 0;
    }
	
    public void update() {
        handleInput();
        for(int i = 0; i < buttons.length; i++) {
            if(currentChoice == i) { buttons[i].setHover(true); }
            else { buttons[i].setHover(false); }
        }

        for(int i = 0; i < stars.length; i++) {
            for(int j = 0; j < stars[0].length; j++) { stars[i][j].update(); }
        }

        if(fadeInTimer >= 0) {
            fadeInTimer++;
            alpha = (int) (255.0 * fadeInTimer / fadeInDelay);
            if(fadeInTimer == fadeInDelay) { fadeInTimer = -1; }
        }
        
        if(fadeOutTimer >= 0) {
            fadeOutTimer++;
            alpha = (int) (255.0 * fadeOutTimer / fadeOutDelay);
            if(fadeOutTimer == fadeOutDelay) { gsm.setState(nextState); }
        }
        if(alpha < 0) alpha = 0;
        if(alpha > 255) alpha = 255;

        bubbleTimer++;
        if(bubbleTimer == 60) {
            bubbles.add(new Bubble(Math.random() * 540 - 100, Math.random() * 100 + 480));
            bubbleTimer = 0;
        }
        for(int i = 0; i < bubbles.size(); i++) {
            if(bubbles.get(i).update()) { bubbles.remove(i);  i--; }
        }
    }
	
    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);

        for(int i = 0; i < bubbles.size(); i++) { bubbles.get(i).draw(g); }

        g.setColor(Color.BLACK);
        g.setFont(titleFont);
        g.drawString("    N I V E L", 20, 80);
        g.setStroke(LevelData.STROKE_2);
        g.drawLine(-5, 90, 600, 90);

        for(int i = 0; i < buttons.length; i++) { buttons[i].draw(g); }

        for(int i = 0; i < stars.length; i++) {
            for(int j = 0; j < stars[0].length; j++) {  stars[i][j].draw(g); }
        }

        if(fadeInTimer >= 0) {
            g.setColor(new Color(255, 255, 255, 255 - alpha));
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
        if(fadeOutTimer >= 0) {
            g.setColor(new Color(255, 255, 255, alpha));
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
    }
	
    private void select() {
        if(fadeOutTimer != -1) return;
        if(currentChoice >= 0 && currentChoice < buttons.length && fadeOutTimer == -1) {
            if(!buttons[currentChoice].isActive()) return;
            //LevelData.setLevel(LevelData.getList(currentChoice * 4));
            LevelData.setLevel(LevelData.getList(currentChoice * 4 + 0));
            nextState = GameStateManager.LEVEL_INFO_STATE;
            fadeInTimer = -1;
            fadeOutTimer = 0;
            GameData.resetScore();
            JukeBox.play("menuclick");
        }
    }
	
    public void handleInput() {

        if(Keys.isPressed(Keys.ESCAPE)) {
            nextState = GameStateManager.MENU_STATE;
            fadeInTimer = -1;
            fadeOutTimer = 0;
        }

        if(Mouse.isPressed()) { select(); }

        boolean hit = false;
        for(int i = 0; i < buttons.length; i++) {
            if(buttons[i].isHovering(Mouse.x, Mouse.y)) {
                currentChoice = i;
                hit = true;
                break;
            }
        }
        if(!hit) currentChoice = -1;
    }
}
