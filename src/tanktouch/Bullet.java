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
public class Bullet extends Hitbox{
    public Bullet(){
        super();
    }
    public Bullet(int x, int y){
        super(x, y); setW(5); setH(5);
    }
    public Bullet(Tank t){
        setxS(t.getxS()); setyS(t.getyS());
        setX((int)(Math.cos(t.getAngle()) *(t.getX() + t.getW()/2)));
        setY((int)(Math.sin(t.getAngle()) *(t.getY() + t.getW()/2)));
    }
    public Bullet(int x, int y, Tank t){
        super(x, y); setW(5); setH(5); setxS(t.getxS()); setyS(t.getyS());
    }
    public void draw(Graphics window){
        window.setColor(Color.BLACK);
        window.fillRect(getX(), getY(), getW(), getH());
    }
}
