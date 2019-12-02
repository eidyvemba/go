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
import handlers.GameStateManager;
import handlers.ImageLoader;
import handlers.JukeBox;
import handlers.Mouse;
import go.Go;
import go.GamePanel;
import handlers.LevelData;

public class MenuState extends GameState{
    private BufferedImage bg;
    private ArrayList<Bubble> bubbles;
    private int bubbleTimer;
    private int currentChoice = 0;
    private GameButton[] options;
    private Color titleColor;
    private Font titleFont;
    private Font font;
    private Font font2;
    private int fadeInTimer;
    private int fadeInDelay;
    private int fadeOutTimer;
    private int fadeOutDelay;
    private int alpha;
    private int nextState;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        init();
    }

    public void init() {
        bg = ImageLoader.BG;
        try {
            Font scFont = Font.createFont( Font.TRUETYPE_FONT, getClass().getResourceAsStream("/src/fonts/DeadFontWalking.otf"));
            //Font scFont = Font.createFont( Font.TRUETYPE_FONT, getClass().getResourceAsStream("/src/fonts/SECRCODE.TTF"));
            titleColor = Color.BLACK;
            titleFont = scFont.deriveFont(86f);
            font = scFont.deriveFont(26f);
            font2 = scFont.deriveFont(14f);
        }
        catch(Exception e) { e.printStackTrace(); }
        Go.setCursor(Go.VISIBLE);
        options = new GameButton[2];
        options[0] = new GameButton(320, 300, 100, 50);
        options[0].setText("n o v o  j o g o", font);
        options[1] = new GameButton(320, 350, 100, 50);
        options[1].setText("s a i r", font);

        fadeInTimer = 0;
        fadeInDelay = 60;
        fadeOutTimer = -1;
        fadeOutDelay = 60;

        //if(!JukeBox.isPlaying("menumusic")) { JukeBox.loop("menumusic", 3000, JukeBox.getFrames("menumusic") - 3000);  }
        JukeBox.stop("bgmusic1");

        bubbles = new ArrayList<Bubble>();
        bubbleTimer = 0;
    }
	
    public void update() {
        handleInput();
        for(int i = 0; i < options.length; i++) {
            if(currentChoice == i) { options[i].setHover(true); }
            else { options[i].setHover(false); }
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
            if(bubbles.get(i).update()) {
                bubbles.remove(i);
                i--;
            }
        }

    }
	
    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
        for(int i = 0; i < bubbles.size(); i++) { bubbles.get(i).draw(g); }

        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("     G O", 100, 200);

        g.setFont(font);
        g.setColor(Color.WHITE);

        for(int i = 0; i < options.length; i++) { options[i].draw(g); }

        g.setFont(font2);
        g.setColor(Color.BLACK);
        g.drawString("Ev", 10, 470);

        if(fadeInTimer >= 0) {
            g.setColor(new Color(255, 255, 255, 255 - alpha));
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
        if(fadeOutTimer >= 0) {
            g.setColor(new Color(255, 255, 255, alpha));
            g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        }
        //backButton.draw(g);
    }
	
    private void select() {
        if(fadeOutTimer != -1) return;

        if(currentChoice == 0) {
            nextState = GameStateManager.LEVEL_SELECT_STATE;
            fadeInTimer = -1;
            fadeOutTimer = 0;
            JukeBox.play("menuclick");
        }
        else if(currentChoice == 1) { System.exit(0); }
    }
	
    public void handleInput() {
        if(Mouse.isPressed()) { select(); }

        boolean hit = false;
        for(int i = 0; i < options.length; i++) {
            if(options[i].isHovering(Mouse.x, Mouse.y)) {
                currentChoice = i;
                hit = true;
                break;
            }
        }        
        if(!hit) currentChoice = -1;
    }
}
