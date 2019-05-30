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
public class PlayerList {
    public ArrayList<Tank> pl = new ArrayList<Tank>();
    public ArrayList<Boolean> alive = new ArrayList<Boolean>();
    public PlayerList(){
        
    }
    public void add(Tank t){
        pl.add(t);
        alive.add(true);
    }
    public void checkCol(ArrayList<Hitbox> m, ArrayList<Bullet> b){
        for(int i = 0; i < pl.size(); i++){
            for(int j = 0; j < m.size(); j++){
                pl.get(i).colCirc(m.get(j));
            }
        }
        for(int i = 0; i < pl.size(); i++){
            for(int j = 0; j < b.size(); j++){
                if(pl.get(i).colCirc(b.get(j))){
                    alive.set(i, false);
                    b.remove(j); j--;
                }
            }
        }
    }
    public ArrayList<Tank> getPList(){
        return pl;
    }
}
