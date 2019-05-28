/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

/**
 *
 * @author chenm7302
 */
public class Bullet extends Hitbox {

    public int colCount = 0;

    public Bullet() {
        super();
    }

    public Bullet(int x, int y) {
        super(x, y);
        setW(5);
        setH(5);
    }

    public Bullet(Tank t) {
        setxS(t.getxS());
        setyS(t.getyS());
        setX((int) (Math.cos(t.getAngle()) * 0.75 * t.getW() + (t.getX() + t.getW() / 2)));
        setY((int) (Math.sin(t.getAngle()) * 0.75 * t.getW() + (t.getY() + t.getW() / 2)));
        setW(5);
        setH(5);
    }

    public Bullet(int x, int y, Tank t) {
        super(x, y);
        setW(5);
        setH(5);
        setxS(t.getxS());
        setyS(t.getyS());
    }

    public boolean didCol(Object O) {
        Hitbox h = (Hitbox) O;
        int tx = getX() + getxS() - h.getxS();
        int ty = getY() + getyS() - h.getyS();
        if (isBet(ty, h.getY(), h.getY() + h.getH()) ^ isBet(ty + getH(), h.getY(), h.getY() + h.getH())) {
            if (isBet(getX(), h.getX(), h.getX() + h.getW()) || isBet(getX() + getW(), h.getX(), h.getX() + h.getW())) {
                this.setyS(-getyS());
                //System.out.println("first");
                colCount++;
                return true;
            }
        }
        //Check side collisions
        if (isBet(tx, h.getX(), h.getX() + h.getW()) ^ isBet(tx + getW(), h.getX(), h.getX() + h.getW())) {
            if (isBet(ty, h.getY(), h.getY() + h.getH()) || isBet(ty + getH(), h.getY(), h.getY() + h.getH())) {
                this.setxS(-getxS());
                //System.out.println("second");
                colCount++;
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(getX(), getY(), getW(), getH());
    }

    public void moveAndDraw(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(getX(), getY(), getW(), getH());
        move();
        draw(window);
    }
}
