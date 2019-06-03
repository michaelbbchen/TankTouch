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
public class Tank extends Hitbox {

    private double angle;
    private Color c;
    private double speed;
    private String name = "";
    //Constructors
    public Tank() {
        super();
        angle = 0;
        c = Color.BLACK;
    }

    public Tank(int x, int y) {
        super(x, y);
        angle = 0;
        c = Color.BLACK;
        speed = 10;
    }

    public Tank(int x, int y, int w, int h) {
        super(x, y, w, h);
        angle = 0;
        c = Color.BLACK;
        speed = 5;
    }

    public Tank(int x, int y, int w, int h, Color C) {
        super(x, y, w, h);
        angle = 0;
        c = C;
        speed = 5;
    }
    public Tank(int x, int y, String n){
        super(x, y, 50, 50); c = Color.BLUE; angle = 0; speed = 5;
        name = n;
    }
    public Tank(int x, int y, int w, int h, double a) {
        super(x, y, w, h);
        angle = a;
        c = Color.BLACK;
        speed = 10;
    }

    public Tank(int x, int y, int w, int h, double a, Color C) {
        super(x, y, w, h);
        angle = a;
        c = C;
        speed = 10;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double d) {
        angle = d;
        setSpeed();
    }
    
    public void setColor(Color C){
        c = C;
    }
    
    public String getName(){
        return name;
    }
    
    //Calculates direction based on angle
    public void setSpeed() {
        setxS((int) (Math.cos(angle) * speed));
        setyS((int) (Math.sin(angle) * speed));
    }

    public boolean colCirc(Object O) {
        Hitbox h = (Hitbox) O;
        int tx = getX() + getxS() - h.getxS();
        int ty = getY() + getyS() - h.getyS();
        
        //Check bot/top collisions
        if (isBet(ty, h.getY(), h.getY() + h.getH()) ^ isBet(ty + getH(), h.getY(), h.getY() + h.getH())) {
            if (isBet(getX(), h.getX(), h.getX() + h.getW()) || isBet(getX() + getW(), h.getX(), h.getX() + h.getW())
                    || isBet(h.getX(), getX(), getX() + getW()) || isBet(h.getX() + h.getW(), getX(), getX() + getW())) {
                this.setyS(-getyS());
                //System.out.println("first");
                return true;
            }
        }
        //Check side collisions
        if (isBet(tx, h.getX(), h.getX() + h.getW()) ^ isBet(tx + getW(), h.getX(), h.getX() + h.getW())) {
            if (isBet(ty, h.getY(), h.getY() + h.getH()) || isBet(ty + getH(), h.getY(), h.getY() + h.getH())
                    || isBet(h.getY(), getY(), getY() + getH()) || isBet(h.getY() + h.getH(), getY(), getY() + getH())) {
                this.setxS(-getxS());
                //System.out.println("second");
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics window) {
        window.setColor(c);
        Color dc = c.darker();
        window.fillRect(getX(), getY(), getW(), getW());
        window.setColor(dc);
        window.fillOval((int) (getX() + 5 * getW() / 12 + getW() * Math.cos(angle) / 6), (int) (getY() + 5 * getW() / 12 + getW() * Math.sin(angle) / 6), getW() / 5, getW() / 5);
        window.drawString(name, getX(), getY());
    }

    public void moveAndDraw(Graphics window) {
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getW(), getH());
        move();
        draw(window);
    }
}
