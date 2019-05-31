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
    private PlayerList pl = new PlayerList();
    private ArrayList<int[]> keybinds = new ArrayList<int[]>();
    private ArrayList<boolean[]> keypress = new ArrayList<boolean[]>();
    private ArrayList<Bullet> b = new ArrayList<Bullet>();
    private BufferedImage back;
    private ArrayList<Hitbox> map;

    //private Hitbox h;
    public Game() {
        setBackground(Color.WHITE);
        //t1 = new Tank(400, 400, 50, 50, Color.BLUE);
        t1 = new Tank(400, 400, "T1");
        pl.add(t1);
        //h = new Hitbox(100, 100, 100, 100);
        map = Map1.getMap();
        al = new ArrayList<KeyEvent>();
        keys = new boolean[3];
        keypress.add(keys);
        keybinds.add(new int[]{37, 38, 39});
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);
    }

    public Game(ArrayList<int[]> kb, ArrayList<String> tl) {
        for (int i = 0; i < kb.size(); i++) {
            keybinds.add(kb.get(i));
            keypress.add(new boolean[]{false, false, false});
        }
        for (int i = 0; i < tl.size(); i++) {
            pl.add(new Tank(Map1.sp.get(i)[0], Map1.sp.get(i)[1], tl.get(i)));
        }
        map = Map1.getMap();
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);
    }

    public void update(Graphics window) {
        paint(window);

    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //Reference to background image
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(0, 0, 1440, 900);
        for (int i = 0; i < map.size(); i++) {
            map.get(i).draw(graphToBack);
        }
        for (int i = 0; i < pl.pl.size(); i++) {
            if (pl.alive.get(i)) {
                pl.pl.get(i).draw(graphToBack);
            }
        }
        //t1.draw(graphToBack);
        pl.checkCol(map, b);

        for (int i = 0; i < pl.pl.size(); i++) {
            if (keypress.get(i)[0]) {
                pl.pl.get(i).setAngle(pl.pl.get(i).getAngle() + 0.06);
                pl.pl.get(i).draw(graphToBack);
            } else if (keypress.get(i)[1]) {
                pl.pl.get(i).setAngle(pl.pl.get(i).getAngle() - 0.06);
                pl.pl.get(i).draw(graphToBack);
            } else if (keypress.get(i)[2]) {
                b.add(new Bullet(pl.pl.get(i)));
                pl.pl.get(i).draw(graphToBack);
                keypress.get(i)[2] = false;
            } else {
                pl.pl.get(i).moveAndDraw(graphToBack);
            }
        }
        /*if (keys[0]) {
         t1.setAngle(t1.getAngle() + 0.06);
         t1.draw(graphToBack);
         } else if (keys[1]) {
         t1.setAngle(t1.getAngle() - 0.06);
         t1.draw(graphToBack);
         } else if (keys[2]) {
         b.add(new Bullet(t1));
         t1.draw(graphToBack);
         keys[2] = false;
         } else {
         t1.moveAndDraw(graphToBack);
         }*/
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < map.size(); j++) {
                b.get(i).didCol(map.get(j));
            }
            b.get(i).draw(graphToBack);
        }
        for (int i = 0; i < b.size(); i++) {
            b.get(i).moveAndDraw(window);
            if (b.get(i).colCount > 5) {
                b.remove(i);
                i--;
            }
        }
        //System.out.println(t1.getxS() + " " + t1.getyS());
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        /*if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         keys[0] = true;
         }
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         keys[1] = true;
         }
         if (e.getKeyCode() == KeyEvent.VK_UP) {
         keys[2] = true;
         }*/
        for (int i = 0; i < keybinds.size(); i++) {
            if (pl.alive.get(i)) {
                if (e.getKeyCode() == keybinds.get(i)[0]) {
                    keypress.get(i)[0] = true;
                }
                if (e.getKeyCode() == keybinds.get(i)[1]) {
                    keypress.get(i)[1] = true;
                }
                if (e.getKeyCode() == keybinds.get(i)[2]) {
                    keypress.get(i)[2] = true;
                }
            }
        }
        //repaint();
    }

    public void keyReleased(KeyEvent e) {
        /*if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         keys[0] = false;
         }
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         keys[1] = false;
         }
         if (e.getKeyCode() == KeyEvent.VK_UP) {
         keys[2] = false;
         }*/
        for (int i = 0; i < keybinds.size(); i++) {
            if (e.getKeyCode() == keybinds.get(i)[0]) {
                keypress.get(i)[0] = false;
            }
            if (e.getKeyCode() == keybinds.get(i)[1]) {
                keypress.get(i)[1] = false;
            }
            if (e.getKeyCode() == keybinds.get(i)[2]) {
                keypress.get(i)[2] = false;
            }
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
