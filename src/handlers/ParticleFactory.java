/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package handlers;

import java.awt.Color;
import java.util.ArrayList;

import entity.Particle;
import entity.Wave;

public class ParticleFactory {
    public static ArrayList<Particle> particles;	
    public static final int MAX_PARTICLES = 64;
    public static void init(ArrayList<Particle> p) { particles = p;  }
    public static void createExplosion(double x, double y) { createExplosion(x, y, Color.WHITE); }
	
    public static void createExplosion(double x, double y, Color c) {
        for(int i = 0; i < 10; i++) {
            double dx = Math.random() * 4 - 2;
            double dy = Math.random() * 4 - 2;
            particles.add(new Particle(x, y, dx, dy, c));
        }
        checkLimit();
    }

    public static void createWave(double x, double y, int width) { createWave(x, y, width, Color.WHITE); }

    public static void createWave(double x, double y, int width, Color c) {
        particles.add(new Wave(x, y, width, c));
        checkLimit();
    }
	
    public static void createSmallWave(double x, double y, int width) { createSmallWave(x, y, width, Color.WHITE); }

    public static void createSmallWave(double x, double y, int width, Color c) {
        Wave w = new Wave(x, y, width, c);
        w.setTickDelay(30);
        particles.add(w);
        checkLimit();
    }

    public static void checkLimit() {
        int extra = particles.size() - MAX_PARTICLES;
        if(extra <= 0) return;
        for(int i = 0; i < extra; i++) { particles.remove(0); }
    }
}
