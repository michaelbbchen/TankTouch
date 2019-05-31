/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import java.awt.Component;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author chenm7302
 */
public class TankTouch extends JFrame {

    private static final int WIDTH = 1450;
    private static final int HEIGHT = 910;

    public TankTouch() {
        super("TankTouch");
        //TitleFrame tf = new TitleFrame();
        
        setSize(WIDTH, HEIGHT);

        Game theGame = new Game();
        ((Component) theGame).setFocusable(true);
        getContentPane().add(theGame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        setVisible(true);

    }
    public TankTouch(ArrayList<int[]> kb, ArrayList<String> tl){
        super("TankTouch");
        //TitleFrame tf = new TitleFrame();
        
        setSize(WIDTH, HEIGHT);

        Game theGame = new Game(kb, tl);
        ((Component) theGame).setFocusable(true);
        getContentPane().add(theGame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TankTouch go = new TankTouch();
    }

}
