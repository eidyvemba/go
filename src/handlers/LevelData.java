/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package handlers;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import entity.Bouncer;
import entity.Goal;
import entity.Hole;
import entity.Player;
import entity.Spawner;

public class LevelData {
    private static String currentLevel;
	
    private static HashMap<String, Point> playerList;
    private static HashMap<String, Point> goalList;
    private static HashMap<String, Integer> limitList;
    private static HashMap<String, ArrayList<Bouncer>> bouncerList;
    private static HashMap<String, ArrayList<Hole>> holeList;
    private static HashMap<String, ArrayList<Spawner>> spawnerList;

    private static ArrayList<String> levelList;
    private static HashMap<String, String[]> levelDescriptions;
    private static int levelIndex;

    public static final int MAX_LEVELS = 8;
    public static final String LEVEL1_1 = "basico   1";
    public static final String LEVEL1_2 = "basico   2";
    public static final String LEVEL1_3 = "basico   3";
    public static final String LEVEL1_4 = "basico   4";
    public static final String LEVEL2_1 = "normal   1";
    public static final String LEVEL2_2 = "normal   2";
    public static final String LEVEL2_3 = "normal   3";
    public static final String LEVEL2_4 = "normal   4";
    public static final String LEVEL3_1 = "inercia   1";
    public static final String LEVEL3_2 = "inercia   2";
    public static final String LEVEL3_3 = "inercia   3";
    public static final String LEVEL3_4 = "inercia   4";
    public static final String LEVEL4_1 = "trilha   1";
    public static final String LEVEL4_2 = "trilha   2";
    public static final String LEVEL4_3 = "trilha   3";
    public static final String LEVEL4_4 = "trilha   4";
    public static final String LEVEL5_1 = "tempo   1";
    public static final String LEVEL5_2 = "tempo   2";
    public static final String LEVEL5_3 = "tempo   3";
    public static final String LEVEL5_4 = "tempo   4";
    public static final String LEVEL6_1 = "tiros   1";
    public static final String LEVEL6_2 = "tiros   2";
    public static final String LEVEL6_3 = "tiros   3";
    public static final String LEVEL6_4 = "tiros   4";
    public static final String LEVEL7_1 = "estrategia   1";
    public static final String LEVEL7_2 = "estrategia   2";
    public static final String LEVEL7_3 = "estrategia   3";
    public static final String LEVEL7_4 = "estrategia   4";
    public static final String LEVEL8_1 = "master   1";
    public static final String LEVEL8_2 = "master   2";
    public static final String LEVEL8_3 = "master   3";
    public static final String LEVEL8_4 = "master   4";

    public static final BasicStroke STROKE_1 = new BasicStroke(1);
    public static final BasicStroke STROKE_2 = new BasicStroke(2);
    public static final BasicStroke STROKE_3 = new BasicStroke(3);

    public static Font SC_FONT;
    public static Font LEVEL_INFO_FONT;

    public static void init() {
        try {
            SC_FONT = Font.createFont( Font.TRUETYPE_FONT, LevelData.class.getResourceAsStream("/src/fonts/DeadFontWalking.otf"));
            LEVEL_INFO_FONT = new Font("Arial", Font.PLAIN, 20);
        }
        catch(Exception e) { e.printStackTrace(); }

        levelList = new ArrayList<String>();
        levelList.add(LEVEL1_1);
        levelList.add(LEVEL1_2);
        levelList.add(LEVEL1_3);
        levelList.add(LEVEL1_4);
        levelList.add(LEVEL2_1);
        levelList.add(LEVEL2_2);
        levelList.add(LEVEL2_3);
        levelList.add(LEVEL2_4);
        levelList.add(LEVEL3_1);
        levelList.add(LEVEL3_2);
        levelList.add(LEVEL3_3);
        levelList.add(LEVEL3_4);
        levelList.add(LEVEL4_1);
        levelList.add(LEVEL4_2);
        levelList.add(LEVEL4_3);
        levelList.add(LEVEL4_4);
        levelList.add(LEVEL5_1);
        levelList.add(LEVEL5_2);
        levelList.add(LEVEL5_3);
        levelList.add(LEVEL5_4);
        levelList.add(LEVEL6_1);
        levelList.add(LEVEL6_2);
        levelList.add(LEVEL6_3);
        levelList.add(LEVEL6_4);
        levelList.add(LEVEL7_1);
        levelList.add(LEVEL7_2);
        levelList.add(LEVEL7_3);
        levelList.add(LEVEL7_4);
        levelList.add(LEVEL8_1);
        levelList.add(LEVEL8_2);
        levelList.add(LEVEL8_3);
        levelList.add(LEVEL8_4);

        playerList = new HashMap<String, Point>();
        goalList = new HashMap<String, Point>();
        limitList = new HashMap<String, Integer>();
        bouncerList = new HashMap<String, ArrayList<Bouncer>>();
        holeList = new HashMap<String, ArrayList<Hole>>();
        spawnerList = new HashMap<String, ArrayList<Spawner>>();
        levelDescriptions = new HashMap<String, String[]>();

        ArrayList<Bouncer> bouncers;
        ArrayList<Hole> holes;
        ArrayList<Spawner> spawners;
        String[] descriptions;

        // basico 1
        playerList.put(LEVEL1_1, new Point(100, 100));
        goalList.put(LEVEL1_1, new Point(500, 380));
        limitList.put(LEVEL1_1, 14);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(100, 400, 200, 200));
        bouncers.add(new Bouncer(240, 100, 120, 120));
        bouncers.add(new Bouncer(340, 340, 170, 170));
        bouncers.add(new Bouncer(470, 180, 140, 140));
        bouncerList.put(LEVEL1_1, bouncers);

        // basico 2
        playerList.put(LEVEL1_2, new Point(80, 80));
        goalList.put(LEVEL1_2, new Point(550, 410));
        limitList.put(LEVEL1_2, 20);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 2; j++) { bouncers.add(new Bouncer(160 + 100 * i, 160 + 160 * j, 70, 70)); }
        }
        bouncers.add(new Bouncer(60, 160, 70, 70));
        bouncers.add(new Bouncer(560, 320, 70, 70));
        bouncerList.put(LEVEL1_2, bouncers);

        // basico 3
        playerList.put(LEVEL1_3, new Point(70, 100));
        goalList.put(LEVEL1_3, new Point(500, 400));
        limitList.put(LEVEL1_3, 9);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(80, 280, 150, 150));
        bouncers.add(new Bouncer(270, 400, 130, 130));
        bouncers.add(new Bouncer(400, 80, 150, 150));
        bouncers.add(new Bouncer(560, 280, 150, 150));
        bouncerList.put(LEVEL1_3, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(200, 100, 150, 150));
        holes.add(new Hole(340, 270, 150, 150));
        holeList.put(LEVEL1_3, holes);

        // basico 4
        playerList.put(LEVEL1_4, new Point(70, 100));
        goalList.put(LEVEL1_4, new Point(560, 100));
        limitList.put(LEVEL1_4, 10);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(60, 280, 100, 100));
        bouncers.add(new Bouncer(190, 420, 100, 100));
        bouncers.add(new Bouncer(450, 420, 100, 100));
        bouncers.add(new Bouncer(580, 280, 100, 100));
        bouncerList.put(LEVEL1_4, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(320, 180, 340, 340));
        holeList.put(LEVEL1_4, holes);

        // normal 1
        playerList.put(LEVEL2_1, new Point(100, 240));
        goalList.put(LEVEL2_1, new Point(540, 240));
        limitList.put(LEVEL2_1, 8);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 7; i++) {
            if(i == 3) continue;
            bouncers.add(new Bouncer(320, 30 + 71 * i, 71, 71));
        }
        bouncerList.put(LEVEL2_1, bouncers);

        // normal 2
        playerList.put(LEVEL2_2, new Point(100, 380));
        goalList.put(LEVEL2_2, new Point(540, 380));
        limitList.put(LEVEL2_2, 10);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 100, 100));
        bouncers.add(new Bouncer(160, 80, 200, 200));
        bouncers.add(new Bouncer(480, 80, 200, 200));
        bouncerList.put(LEVEL2_2, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(320, 380, 250, 250));
        holeList.put(LEVEL2_2, holes);

        // normal 3
        playerList.put(LEVEL2_3, new Point(100, 100));
        goalList.put(LEVEL2_3, new Point(560, 400));
        limitList.put(LEVEL2_3, 10);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(80, 240, 100, 100));
        bouncers.add(new Bouncer(210, 60, 100, 100));
        bouncers.add(new Bouncer(330, 100, 100, 100));
        bouncers.add(new Bouncer(270, 300, 100, 100));
        bouncers.add(new Bouncer(410, 390, 130, 120));
        bouncers.add(new Bouncer(550, 250, 130, 120));
        bouncerList.put(LEVEL2_3, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(160, 140, 100, 100));
        holes.add(new Hole(300, 180, 100, 100));
        holes.add(new Hole(640, 480, 250, 250));
        holeList.put(LEVEL2_3, holes);

        // normal 4
        playerList.put(LEVEL2_4, new Point(320, 50));
        goalList.put(LEVEL2_4, new Point(320, 400));
        limitList.put(LEVEL2_4, 5);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 6; j++) {
                if(j % 2 != 0 || i == 5) continue;
                bouncers.add(new Bouncer(64 * i, 104 + 64 * j, 64, 64));
            }
        }
        bouncerList.put(LEVEL2_4, bouncers);

        // inercia 1
        playerList.put(LEVEL3_1, new Point(80, 80));
        goalList.put(LEVEL3_1, new Point(560, 80));
        limitList.put(LEVEL3_1, 7);
        descriptions = new String[3];
        descriptions[0] = "- atritos";
        descriptions[1] = "- 2 segungos de atraso";
        descriptions[2] = "- mover devagar";
        levelDescriptions.put(LEVEL3_1, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 140, 300, 300));
        bouncerList.put(LEVEL3_1, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(106, 440, 150, 150));
        holes.add(new Hole(212, 440, 150, 150));
        holes.add(new Hole(320, 440, 150, 150));
        holes.add(new Hole(426, 440, 150, 150));
        holes.add(new Hole(542, 440, 150, 150));
        holeList.put(LEVEL3_1, holes);

        // inercia 2
        playerList.put(LEVEL3_2, new Point(80, 380));
        goalList.put(LEVEL3_2, new Point(560, 80));
        limitList.put(LEVEL3_2, 9);
        descriptions = new String[2];
        descriptions[0] = "- atritos";
        descriptions[1] = "- tempo: 20 seg";
        levelDescriptions.put(LEVEL3_2, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(220, 180, 100, 100));
        bouncers.add(new Bouncer(380, 240, 100, 100));
        bouncers.add(new Bouncer(200, 400, 100, 100));
        bouncers.add(new Bouncer(350, 100, 100, 100));
        bouncers.add(new Bouncer(550, 400, 100, 100));
        bouncerList.put(LEVEL3_2, bouncers);

        // inercia 3
        playerList.put(LEVEL3_3, new Point(80, 380));
        goalList.put(LEVEL3_3, new Point(560, 80));
        limitList.put(LEVEL3_3, 14);
        descriptions = new String[3];
        descriptions[0] = "- atrito";
        descriptions[1] = "- tempo: 20 seg";
        descriptions[2] = "- mover depressa";
        levelDescriptions.put(LEVEL3_3, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 50, 50));
        bouncers.add(new Bouncer(106, 100, 70, 70));
        bouncers.add(new Bouncer(212, 200, 80, 80));
        bouncers.add(new Bouncer(320, 410, 60, 60));
        bouncers.add(new Bouncer(542, 200, 70, 70));
        bouncerList.put(LEVEL3_3, bouncers);

        // inercia 4
        playerList.put(LEVEL3_4, new Point(150, 240));
        goalList.put(LEVEL3_4, new Point(490, 240));
        limitList.put(LEVEL3_4, 1);
        descriptions = new String[3];
        descriptions[0] = "- atrito";
        descriptions[1] = "- tempo: 15 seg";
        descriptions[2] = "- uma chance";
        levelDescriptions.put(LEVEL3_4, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 100, 100));
        bouncerList.put(LEVEL3_4, bouncers);

        // trilha 1
        playerList.put(LEVEL4_1, new Point(230, 60));
        goalList.put(LEVEL4_1, new Point(410, 60));
        limitList.put(LEVEL4_1, 12);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 300, 300));
        for(int i = 0; i < 7; i++) {
            double radians = Math.toRadians(-135 - 45 * i);
            int x = (int) (Math.cos(radians) * 280 + 320);
            int y = (int) (Math.sin(radians) * 280 + 240);
            bouncers.add(new Bouncer(x, y, 100, 100));
        }
        
        bouncerList.put(LEVEL4_1, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(320, 40, 100, 100));
        holeList.put(LEVEL4_1, holes);

        // trilha 2
        playerList.put(LEVEL4_2, new Point(80, 100));
        goalList.put(LEVEL4_2, new Point(560, 240));
        limitList.put(LEVEL4_2, 10);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 100, 100, 0, 3));
        bouncerList.put(LEVEL4_2, bouncers);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(320, 0, 450, 450));
        holes.add(new Hole(320, 480, 450, 450));
        holeList.put(LEVEL4_2, holes);

        // trilha 3
        playerList.put(LEVEL4_3, new Point(80, 300));
        goalList.put(LEVEL4_3, new Point(560, 140));
        limitList.put(LEVEL4_3, 12);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 7; i++) {
            double PI2 = Math.PI * 2;
            int x = 40 + 80 * i;
            int y = (int) (100.0 * Math.sin((1.0 * x / 640) * PI2));
            bouncers.add(new Bouncer(x, y + 120, 100, 100));
            bouncers.add(new Bouncer(x, y + 340, 100, 100));
        }
        bouncerList.put(LEVEL4_3, bouncers);

        // trilha 4
        playerList.put(LEVEL4_4, new Point(105, 112));
        goalList.put(LEVEL4_4, new Point(416, 240));
        limitList.put(LEVEL4_4, 24);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 7; j++) {
                if((j == 1 && i > 0 && i < 9) || (i == 8 && j > 0 && j < 6) || (j == 5 && i > 0 && i < 9) || (i == 1 && j == 4) || (j == 3 && i > 0 && i < 7) || (j == 0) || (j == 1)) continue;
                bouncers.add(new Bouncer(32 + 64 * i, 48 + 64 * j, 64, 64));
            }
        }
        bouncerList.put(LEVEL4_4, bouncers);

        // velocidade 1
        playerList.put(LEVEL5_1, new Point(80, 80));
        goalList.put(LEVEL5_1, new Point(560, 400));
        limitList.put(LEVEL5_1, 15);
        descriptions = new String[1];
        descriptions[0] = "- tempo: 15 seg";
        levelDescriptions.put(LEVEL5_1, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(200, 100, 100, 100));
        bouncers.add(new Bouncer(200, 250, 100, 100));
        bouncers.add(new Bouncer(440, 380, 100, 100));
        bouncers.add(new Bouncer(440, 230, 100, 100));
        bouncerList.put(LEVEL5_1, bouncers);

        // velocidade 2
        playerList.put(LEVEL5_2, new Point(80, 240));
        goalList.put(LEVEL5_2, new Point(560, 240));
        limitList.put(LEVEL5_2, 12);
        descriptions = new String[2];
        descriptions[0] = "- tempo: 12 seg";
        descriptions[1] = "- mover depressa";
        levelDescriptions.put(LEVEL5_2, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(230, 180, 20, 20));
        bouncers.add(new Bouncer(160, 250, 20, 20));
        bouncers.add(new Bouncer(380, 340, 20, 20));
        bouncers.add(new Bouncer(440, 120, 20, 20));
        bouncers.add(new Bouncer(140, 400, 20, 20));
        bouncers.add(new Bouncer(310, 300, 20, 20));
        bouncers.add(new Bouncer(80, 100, 20, 20));
        bouncers.add(new Bouncer(320, 80, 20, 20));
        bouncers.add(new Bouncer(420, 240, 20, 20));
        bouncers.add(new Bouncer(520, 400, 20, 20));
        bouncers.add(new Bouncer(260, 390, 20, 20));
        bouncerList.put(LEVEL5_2, bouncers); 

        // velocidade 3
        playerList.put(LEVEL5_3, new Point(80, 400));
        goalList.put(LEVEL5_3, new Point(560, 400));
        limitList.put(LEVEL5_3, 20);
        descriptions = new String[1];
        descriptions[0] = "- tempo: 15 seg";
        levelDescriptions.put(LEVEL5_3, descriptions);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 7; j++) {
                if((i == 1 && j >= 1 && j <= 5) || ((i == 2 || i == 3) && (j == 1 || j == 5)) || (i == 4 && (j <= 1 || j >= 5))) continue;
                bouncers.add(new Bouncer(20 + j * 100, i * 100, 100, 100));
            }
        }
        bouncers.add(new Bouncer(320, 240, 20, 20, 4, 0));
        bouncers.add(new Bouncer(320, 240, 20, 20, 0, 4));
        bouncerList.put(LEVEL5_3, bouncers);

        // velocidade 4
        playerList.put(LEVEL5_4, new Point(560, 80));
        goalList.put(LEVEL5_4, new Point(560, 400));
        limitList.put(LEVEL5_4, 20);
        descriptions = new String[1];
        descriptions[0] = "- tempo: 15 seg";
        levelDescriptions.put(LEVEL5_4, descriptions);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 6; i++) { bouncers.add(new Bouncer(600 - 80 * i, 240, 80, 80)); }
        bouncers.add(new Bouncer(320, 240, 20, 20, 3, 1));
        bouncers.add(new Bouncer(320, 240, 20, 20, -1, -3));
        bouncers.add(new Bouncer(320, 240, 20, 20, 2, -2));
        bouncers.add(new Bouncer(320, 240, 20, 20, -2, 2));
        bouncerList.put(LEVEL5_4, bouncers);

        // tempo 1
        playerList.put(LEVEL6_1, new Point(80, 80));
        goalList.put(LEVEL6_1, new Point(80, 400));
        limitList.put(LEVEL6_1, 14);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 6; i++) { bouncers.add(new Bouncer(40 + 80 * i, 240, 80, 80)); }
        bouncerList.put(LEVEL6_1, bouncers);
        spawners = new ArrayList<Spawner>();
        spawners.add(new Spawner(320, 240, 100, 100, 120, 1.8));
        spawnerList.put(LEVEL6_1, spawners);

        // tempo 2
        playerList.put(LEVEL6_2, new Point(80, 240));
        goalList.put(LEVEL6_2, new Point(560, 240));
        limitList.put(LEVEL6_2, 10);
        spawners = new ArrayList<Spawner>();
        spawners.add(new Spawner(320, 50, 80, 80, 120, 1.8));
        spawners.add(new Spawner(320, 430, 80, 80, 120, 1.8));
        spawnerList.put(LEVEL6_2, spawners);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 50, 100, 100));
        bouncers.add(new Bouncer(320, 430, 100, 100));
        bouncers.add(new Bouncer(320, 240, 30, 30));
        bouncerList.put(LEVEL6_2, bouncers);
        holes = new ArrayList<Hole>();
        holeList.put(LEVEL6_2, holes);

        // tempo 3
        playerList.put(LEVEL6_3, new Point(80, 240));
        goalList.put(LEVEL6_3, new Point(560, 240));
        limitList.put(LEVEL6_3, 12);
        spawners = new ArrayList<Spawner>();
        spawners.add(new Spawner(320, 240, 80, 80, 90, 2));
        spawnerList.put(LEVEL6_3, spawners);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 100, 100));
        bouncers.add(new Bouncer(320, 160, 30, 30, 2, 0));
        bouncers.add(new Bouncer(320, 320, 30, 30, -2, 0));
        bouncers.add(new Bouncer(213, 240, 30, 30, 0, 2));
        bouncers.add(new Bouncer(416, 240, 30, 30, 0, -2));
        bouncers.add(new Bouncer(320, 120, 30, 30));
        bouncers.add(new Bouncer(320, 360, 30, 30));
        bouncerList.put(LEVEL6_3, bouncers);

        // tempo 4
        playerList.put(LEVEL6_4, new Point(80, 240));
        goalList.put(LEVEL6_4, new Point(560, 240));
        limitList.put(LEVEL6_4, 20);
        spawners = new ArrayList<Spawner>();
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 100, 100));
        bouncerList.put(LEVEL6_4, bouncers);
        spawners.add(new Spawner(80, 80, 80, 80, 60, 2));
        spawners.add(new Spawner(80, 400, 80, 80, 60, 2));
        spawners.add(new Spawner(560, 80, 80, 80, 60, 2));
        spawners.add(new Spawner(560, 400, 80, 80, 60, 2));
        spawnerList.put(LEVEL6_4, spawners);

        // estategia 1
        playerList.put(LEVEL7_1, new Point(80, 400));
        goalList.put(LEVEL7_1, new Point(560, 80));
        limitList.put(LEVEL7_1, 14);
        descriptions = new String[1];
        descriptions[0] = "- mover devagar";
        levelDescriptions.put(LEVEL7_1, descriptions);
        bouncers = new ArrayList<Bouncer>();
        bouncers.add(new Bouncer(320, 240, 120, 120));
        bouncers.add(new Bouncer(220, 390, 100, 100));
        bouncers.add(new Bouncer(90, 80, 100, 100));
        bouncers.add(new Bouncer(340, 50, 100, 100));
        bouncers.add(new Bouncer(540, 380, 100, 100));
        bouncers.add(new Bouncer(500, 210, 100, 100));
        bouncers.add(new Bouncer(80, 270, 100, 100));
        bouncerList.put(LEVEL7_1, bouncers);

        // estategia 2
        playerList.put(LEVEL7_2, new Point(80, 80));
        goalList.put(LEVEL7_2, new Point(560, 400));
        limitList.put(LEVEL7_2, 20);
        descriptions = new String[2];
        descriptions[0] = "- mover devagar";
        descriptions[1] = "- tempo: 30 seg";
        levelDescriptions.put(LEVEL7_2, descriptions);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 1; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0) continue;
                bouncers.add(new Bouncer(80 * j, 80 * i, 30, 30));
            }
        }
        bouncerList.put(LEVEL7_2, bouncers);
        holes = new ArrayList<Hole>();
        for(int i = 0; i < 3; i++) { holes.add(new Hole(80 + 160 * i, 400, 130, 130)); }
        holeList.put(LEVEL7_2, holes);

        // estategia 3
        playerList.put(LEVEL7_3, new Point(80, 400));
        goalList.put(LEVEL7_3, new Point(560, 100));
        limitList.put(LEVEL7_3, 10);
        descriptions = new String[1];
        descriptions[0] = "- parar";
        levelDescriptions.put(LEVEL7_3, descriptions);
        bouncers = new ArrayList<Bouncer>();
        for(int i = 0; i < 7; i++) { bouncers.add(new Bouncer(120 + 80 * i, 0, 100, 100)); }
        bouncerList.put(LEVEL7_3, bouncers);
        holes = new ArrayList<Hole>();
        for(int i = 0; i < 7; i++) { holes.add(new Hole(120 + 80 * i, 140, 100, 100)); }
        holeList.put(LEVEL7_3, holes);

        // estategia 4
        playerList.put(LEVEL7_4, new Point(80, 240));
        goalList.put(LEVEL7_4, new Point(560, 240));
        limitList.put(LEVEL7_4, 20);
        descriptions = new String[1];
        descriptions[0] = "- encostar a esquerda";
        levelDescriptions.put(LEVEL7_4, descriptions);
        spawners = new ArrayList<Spawner>();
        spawners.add(new Spawner(560, 120, 100, 100, 120, 2));
        spawners.add(new Spawner(560, 360, 100, 100, 120, 2));
        spawnerList.put(LEVEL7_4, spawners);

    }

    public static void setLevel(String s) {
        currentLevel = s;
        for(int i = 0; i < levelList.size(); i++) {
            if(levelList.get(i).equals(s)) {
                levelIndex = i;
                break;
            }
        }
    }

    public static String getLevel() { return currentLevel; }

    public static String getLevel(int i) {
        if(i >= levelList.size()) return "--   ";
        return levelList.get(i);
    }

    public static int getLevelIndex() {
        for(int i = 0; i < levelList.size(); i++) {
            if(levelList.get(i).equals(currentLevel)) { return i; }
        }
        return -1;
    }

    public static void nextLevel() {
        if(levelIndex < levelList.size() - 1) { levelIndex++; }
        currentLevel = levelList.get(levelIndex);
    }

    public static String getList(int i) { return levelList.get(i); }

    public static ArrayList<Bouncer> getBouncers() {
        if(bouncerList.get(currentLevel) == null) return new ArrayList<Bouncer>();
        return bouncerList.get(currentLevel);
    }

    public static ArrayList<Hole> getHoles() {
        if(holeList.get(currentLevel) == null) return new ArrayList<Hole>();
        return holeList.get(currentLevel);
    }

    public static ArrayList<Spawner> getSpawners() {
        if(spawnerList.get(currentLevel) == null) return new ArrayList<Spawner>();
        return spawnerList.get(currentLevel);
    }

    public static String[] getDescription() {
        if(levelDescriptions.get(currentLevel) == null) return new String[0];
        return levelDescriptions.get(currentLevel);
    }

    public static int getLimit() { return limitList.get(currentLevel); }

    public static void setPlayer(Player player) {
        Point p = playerList.get(currentLevel);
        player.setPosition(p.x, p.y);
        if(currentLevel.equals(LEVEL2_4)) { player.setDimensions(58, 58); }
        if(currentLevel.equals(LEVEL3_1)) {
            player.setStopSpeed(1);
            player.setHitDelay(120);
            player.setLaunchSpeed(1.5);
        }
        if(currentLevel.equals(LEVEL3_2)) { player.setStopSpeed(1); }
        if(currentLevel.equals(LEVEL3_3)) {
            player.setStopSpeed(1);
            player.setLaunchSpeed(6);
        }
        if(currentLevel.equals(LEVEL3_4)) { player.setStopSpeed(1); }
        if(currentLevel.equals(LEVEL4_4)) { player.setDimensions(40, 40); }
        if(currentLevel.equals(LEVEL5_2)) {  player.setLaunchSpeed(6); }
        if(currentLevel.equals(LEVEL7_1)) { player.setPull(0, 0.04); }
        if(currentLevel.equals(LEVEL7_2)) {  player.setPull(0, 0.04); }
        if(currentLevel.equals(LEVEL7_3)) { player.setPull(0, -0.04); }
        if(currentLevel.equals(LEVEL7_4)) { player.setPull(-0.05, 0); }
    }

    public static void setGoal(Goal goal) {
        Point p = goalList.get(currentLevel);
        goal.setPosition(p.x, p.y);
    }

    public static int getTime() {
        if(currentLevel.equals(LEVEL3_2)) return 60 * 20;
        if(currentLevel.equals(LEVEL3_3)) return 60 * 20;
        if(currentLevel.equals(LEVEL3_4)) return 60 * 15;
        if(currentLevel.equals(LEVEL5_1)) return 60 * 15;
        if(currentLevel.equals(LEVEL5_2)) return 60 * 12;
        if(currentLevel.equals(LEVEL5_3)) return 60 * 15;
        if(currentLevel.equals(LEVEL5_4)) return 60 * 15;
        if(currentLevel.equals(LEVEL7_2)) return 60 * 30;
        return -1;
    }

    public static int[] getStars() {
        int[] stars = new int[MAX_LEVELS];
        int[] star3 = new int[] {22, 14, 17, 15, 25, 14, 16, 100};
        int[] star2 = new int[] {15, 11, 11, 10, 18, 10, 12, 100};
        int[] star1 = new int[] {8, 6, 6, 5, 10, 5, 6, 100};
        for(int i = 0; i < MAX_LEVELS; i++) {
            int score = GameData.getScore(i);
            if(score >= star3[i]) { stars[i] = 3; }
            else if(score >= star2[i]) { stars[i] = 2; }
            else if(score >= star1[i]) { stars[i] = 1; }
            else { stars[i] = 0; }
        }
        return stars;
    }
}
