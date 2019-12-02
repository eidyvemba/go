/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import handlers.JukeBox;
import handlers.LevelData;
import handlers.ParticleFactory;

public class Player extends GameObject {
    private double stopSpeed; // atrito
    private double launchSpeed; // força do impacto do mouse

    private int hitCounter; // hit tempo
    private int hitDelay; // atraso antes pode ser atingido novamente
    private boolean hitReady; // pode bater novamente
    private int numHits; // número de vezes que o mouse bateu
    private int hitLimit; // número máximo de hits permitidos
    private Arc2D.Double arc; // representação visual do atraso de acerto
    private int alpha; // representação visual de numHits / hitLimit

    private boolean hole; // caiu no buraco, parar de mexer
    private boolean goal; // atingiu o objetivo, parar de mover
    private int goalTimer; // temporizador do ponto objectivo

    private boolean dead; // limite atingido

    private double pulldx; // puxar direção
    private double pulldy;

    public Player() {
        width = height = 65;
        stopSpeed = 0.98;
        launchSpeed = 3;
        hitCounter = -90;
        hitDelay = 30;
        numHits = 0;
        hitLimit = LevelData.getLimit();

        goal = false;
        goalTimer = 9;
        arc = new Arc2D.Double(x - width / 2, y - height / 2, width, height, 0, 0, Arc2D.OPEN);
        alpha = 128;

        pulldx = pulldy = 0;

        color = new Color(255, 255, 255, alpha);
        colorBorder = new Color(color.getRed(), color.getGreen(), color.getBlue());

    }

    public void setPosition(double x, double y) {
        super.setPosition(x, y);
        arc.x = x - width / 2;
        arc.y = y - height / 2;
    }

    public void setPosition(GameObject o) {
        super.setPosition(o);
        arc.x = x - width / 2;
        arc.y = y - height / 2; 
    }

    public void setDimensions(int w, int h) {
        super.setDimensions(w, h);
        arc.width = w;
        arc.height = h;
    }

    public void setStopSpeed(double d) { stopSpeed = d; }
    public void setLaunchSpeed(double d) { launchSpeed = d; }

    public void setPull(double dx, double dy) {
        pulldx = dx;
        pulldy = dy;
    }

    public void setHitDelay(int i) {
        hitDelay = i;
        if(hitDelay < 2) hitDelay = 2;
    }

    public void fellInHole() {
        if(hole) return;
        hole = true;
        JukeBox.play("hole");
    }

    public void reachedGoal() {
        if(goal) return;
        goal = true;
        JukeBox.play("finish");
    }

    public int getNumHits() { return numHits; }
    public boolean isDead() { return dead;  }

    // refletir o player fora dos limites de nível
    public void fixBounds(int w, int h) {
        if(x - width / 2 < 0 && dx < 0) dx = -dx;
        if(x + width / 2 > w && dx > 0) dx = -dx;
        if(y - height / 2 < 0 && dy < 0) dy = -dy;
        if(y + height / 2 > h && dy > 0) dy = -dy;
    }

    // refletir o player longe do obstáculo
    public void reflect(double x, double y, int r, int i) {
        double dx = x - this.x;
        double dy = y - this.y;
        double nn = dx * dx + dy * dy;
        this.dx -= (2.0 * (i / nn)) * dx;
        this.dy -= (2.0 * (i / nn)) * dy;
        double dist = Math.sqrt(this.dx * this.dx + this.dy * this.dy);
        this.dx /= dist;
        this.dy /= dist;
        this.dx *= launchSpeed;
        this.dy *= launchSpeed;
        double ratio = 1.0 * width / (width + r);
        ParticleFactory.createExplosion(this.x + dx * ratio, this.y + dy * ratio);
        JukeBox.play("bouncer");
    }

    // empurrar o jogador com o mouse
    public boolean checkHit(double dx, double dy, int r) {
        if(hitCounter < hitDelay || numHits == hitLimit || goal) return false;
        double dist = Math.sqrt(dx * dx + dy * dy);
        if(dist < width / 2 + r) {
            dx /= dist;
            dy /= dist;
            this.dx = dx * launchSpeed;
            this.dy = dy * launchSpeed;
            hitCounter++;
            numHits++;
            ParticleFactory.createWave(this.x, this.y, this.width);
            alpha = (int) (128.0 * numHits / hitLimit);
            if(alpha < 0) alpha = 0;
            if(alpha > 128) alpha = 128;
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 128 - alpha);
            JukeBox.play("hit");
            hitCounter = 0;
            return true;
        }
        return false;
    }

    public boolean isReady() { return hitReady; }

    public void loseHit() {
        if(numHits == hitLimit || goal) return;
        numHits++;
    }

    public void setDead() {
        if(dead) return;
        ParticleFactory.createWave(x, y, width);
        dead = true;
    }

    public void update() {

        // falhou
        if(numHits == hitLimit && dx == 0 && dy == 0 && !goal && !dead) { setDead(); }
        if(dead) return;       
        hitCounter++; // tempo de atualização desde o último hit
        
        // puxar
        dx += pulldx;
        dy += pulldy;

        // atrito
        dx *= stopSpeed;
        dy *= stopSpeed;

        if(dx > -0.02 && dx < 0.02) dx = 0;
        if(dy > -0.02 && dy < 0.02) dy = 0;

        // mover para o próximo local
        x += dx;
        y += dy;

        // atualizar arco
        arc.x = x - width / 2;
        arc.y = y - height / 2;
        
        if(hitCounter < 0) { arc.extent = 0; }
        else if(numHits == hitLimit) { arc.extent = 360; }
        else { arc.extent = (int) (360.0 * hitCounter / hitDelay); }

        // verificar se está pronto
        hitReady = hitCounter >= hitDelay;

    }

    public void draw(Graphics2D g) {

        if(dead) return;

        g.setStroke(LevelData.STROKE_2);
        drawCircleNoBorder(g);

        // desenhar arco
        g.setColor(colorBorder);
        g.setStroke(LevelData.STROKE_3);
        g.draw(arc);

        // meta alcançada
        if(goal) {
            goalTimer++;
            if(goalTimer == 30) {
                ParticleFactory.createWave(x, y, width);
                goalTimer = 0;
            }
        }

    }
}
