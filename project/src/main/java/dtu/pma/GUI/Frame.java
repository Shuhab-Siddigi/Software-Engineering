package dtu.pma.GUI;
import javax.swing.JFrame;


public class Frame extends JFrame {

    public final int HEIGHT = 800;
    public final int WIDTH = 1000;

    public Frame(String title) {
        this.setTitle(title);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); 
    }
    

}
