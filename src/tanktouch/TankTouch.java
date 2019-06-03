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

    public TankTouch(ArrayList<int[]> kb, ArrayList<String> tl) {
        super("TankTouch");
        //TitleFrame tf = new TitleFrame();

        setSize(WIDTH, HEIGHT);

        Game theGame = new Game(kb, tl);
        ((Component) theGame).setFocusable(true);
        getContentPane().add(theGame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            File file = new File("keys.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < tl.size(); i++) {
                bw.write(tl.get(i));
                for (int j = 0; j < 3; j++) {
                    bw.write(" " + (char) kb.get(i)[j]);
                }
                bw.write('\n');
            }
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        TankTouch go = new TankTouch();
    }

}
