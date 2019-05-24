/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.*;
/**
 *
 * @author chenm7302
 */
public class Game extends Canvas implements KeyListener, Runnable {
    private ArrayList<KeyEvent> al;
    private boolean[] keys;
    private Tank t1;
    private BufferedImage back;
    private ArrayList<Hitbox> map;
    //private Hitbox h;
    public Game(){
        setBackground(Color.WHITE);
        t1 = new Tank(400, 400, 50, 50, Color.BLUE);
        //h = new Hitbox(100, 100, 100, 100);
        map = Map1.getMap();
        al = new ArrayList<KeyEvent>();
        keys  = new boolean[3];
        keys = new boolean[]{false, false, false};
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);
    }
    
    public void update(Graphics window){
        paint(window);
        
    }
    public void paint(Graphics window){
        Graphics2D twoDGraph = (Graphics2D) window;
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

	//Reference to background image
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(0, 0, 1440, 900);
        //System.out.println("HIIIIIIIIIIIII");
        
        //h.draw(graphToBack);
        t1.draw(graphToBack);
        //t1.colCirc(h);
        for(int i = 0; i < map.size(); i++){
            t1.colCirc(map.get(i));
            map.get(i).draw(graphToBack);
        }
        if(keys[0]){
            t1.setAngle(t1.getAngle() + 0.06);
            //t1.setxS(-2);
            t1.draw(graphToBack);
        }
        else if(keys[1]){
            //t1.setxS(2);
            t1.setAngle(t1.getAngle() - 0.06);
            t1.draw(graphToBack);
        }
        else if(keys[2]){
            //
            //t1.setyS(-2);
            t1.draw(graphToBack);
        }
        else{
            t1.moveAndDraw(graphToBack);
        }
        //System.out.println(t1.getxS() + " " + t1.getyS());
        twoDGraph.drawImage(back, null, 0, 0);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = true;
        }
        //repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = false;
        }
        //repaint();
    }

    public void keyTyped(KeyEvent e) {
        //no code needed here
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(15);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
