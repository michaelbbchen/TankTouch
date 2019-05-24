/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author chenm7302
 */
public abstract class MovingThing implements Moveable, Collidable{
    private int x, y, w, h;
    private int xs, ys;
    public MovingThing(){
        x = y = 10; w = h = 10;
        xs = 0; ys = 0;
    }
    public MovingThing(int X, int Y){
        x = X; y = Y; w = 10; h = 10;
        xs = 0; ys = 0;
    }
    public MovingThing(int X, int Y, int W, int H){
        x = X; y = Y; w = W; h = H;
        xs = 0; ys = 0;
    }
    public MovingThing(int X, int Y, int W, int H, int xS, int yS){
        x = X; y = Y; w = W; h = H;
        xs = xS; ys = yS;
    }
    //Moveable interface mathods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setPos(int X, int Y){
        x = X; y = Y;
    }
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getxS() {
        return xs;
    }

    public void setxS(int xs) {
        this.xs = xs;
    }

    public int getyS() {
        return ys;
    }

    public void setyS(int ys) {
        this.ys = ys;
    }
    
    public void move(){
        setX(getX() + getxS());
        setY(getY() + getyS());
    }
    public abstract void draw(Graphics window);
}
