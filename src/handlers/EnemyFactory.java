/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package handlers;

import java.util.ArrayList;
import entity.Player;
import entity.PushBall;

public class EnemyFactory {
    private static ArrayList<PushBall> pushBalls;
    private static Player player;

    public static void init(ArrayList<PushBall> pb, Player p) {
        pushBalls = pb;
        player = p;
    }
    public static void spawn(double x, double y, double speed) { pushBalls.add(new PushBall(x, y, speed, player)); }
}
