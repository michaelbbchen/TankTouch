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
public class Hitbox extends MovingThing implements Collidable{
    //Constructors
    public Hitbox(){
        super();
    }
    public Hitbox(int X, int Y){
        super(X, Y);
    }
    public Hitbox(int X, int Y, int W, int H){
        super(X, Y, W, H);
    }
    public Hitbox(int X, int Y, int W, int H, int xS, int yS){
        super(X, Y, W, H, xS, yS);
    }
    public boolean isBet(int x, int y, int z){
        return x >= y && x <= z;
    }
    //Checks for collision
    public boolean didCol(Object O){
        Hitbox h = (Hitbox) O;
        int tx = getX() + getxS() - h.getxS(); int ty = getY() + getyS() - h.getyS();
        if (isBet(ty, h.getY(), h.getY() + h.getH()) ^ isBet(ty + getH(), h.getY(), h.getY() + h.getH())) {
            if (isBet(getX(), h.getX(), h.getX() + h.getW()) || isBet(getX() + getW(), h.getX(), h.getX() + h.getW())) {
                this.setyS(-getyS());
                //System.out.println("first");
                return true;
            }
        }
        //Check side collisions
        if (isBet(tx, h.getX(), h.getX() + h.getW()) ^ isBet(tx + getW(), h.getX(), h.getX() + h.getW())) {
            if (isBet(ty, h.getY(), h.getY() + h.getH()) || isBet(ty + getH(), h.getY(), h.getY() + h.getH())) {
                this.setxS(-getxS());
                //System.out.println("second");
                return true;
            }
        }
        return false;
    }
    public boolean colCirc(Object O){
        return false;
    }
    public void draw(Graphics window){
        window.setColor(Color.GRAY);
        window.fillRect(getX(), getY(), getW(), getH());
    }
    public void moveAndDraw(Graphics window){
        window.setColor(Color.WHITE);
        window.fillRect(getX(), getY(), getW(), getH());
        move();
        draw(window);
    }
}
