package dtu.pma.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class Frame extends JFrame {

    public final int HEIGHT = 800;
    public final int WIDTH = 800;

    public Frame(String title) {
        this.setTitle(title);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); 
    }
    
    private void initialize(){
        
    }

}
