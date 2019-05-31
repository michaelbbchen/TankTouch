/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author chenm7302
 */
public class Map1 {
    static ArrayList<Hitbox> al = new ArrayList<Hitbox>(){{
        add(new Hitbox(0,0,1440,20));
        add(new Hitbox(0,0,20, 900));
        add(new Hitbox(1420,0,20,900));
        add(new Hitbox(0,880,1440,20));
        add(new Hitbox(700, 100, 40, 700));
        add(new Hitbox(120,150,120,120)); add(new Hitbox(1200,150,120,120));
        add(new Hitbox(450,150,120,120)); add(new Hitbox(870,150,120,120));
        add(new Hitbox(120,630,120,120)); add(new Hitbox(1200,630,120,120));
        add(new Hitbox(450,630,120,120)); add(new Hitbox(870,630,120,120));
    }};
    static ArrayList<int[]> sp = new ArrayList<int[]>(){{
       add(new int[]{350, 200}); 
       add(new int[]{350, 700});
       add(new int[]{1000, 200});
       add(new int[]{1000, 700}); 
    }};
    public static ArrayList<Hitbox> getMap(){
        return al;
    }
}
