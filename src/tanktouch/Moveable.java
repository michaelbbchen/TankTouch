/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chenm7302
 */
public interface Moveable {

    public void setPos(int x, int y);

    public void setX(int x);

    public void setY(int y);

    public int getX();

    public int getY();

    public int getW();

    public int getH();

    public void setW(int w);

    public void setH(int h);

    public void setxS(int s);

    public int getxS();
    
    public void setyS(int s);
    
    public int getyS();
    
    //public void setAngle(int t);
    
    //public double getAngle();
}
