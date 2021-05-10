package dtu.pma.GUI;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Frame extends JFrame {

    public final int HEIGHT = 1080;
    public final int WIDTH = 1920;

    public Frame(String title) {
        this.setTitle(title);
        this.setSize(WIDTH,HEIGHT);
        this.setMinimumSize(new Dimension(900,1100));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); 
    }
    

}
