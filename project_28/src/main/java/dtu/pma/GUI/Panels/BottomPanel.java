package dtu.pma.GUI.Panels;


import java.awt.*;
import javax.swing.*;


public class BottomPanel extends JPanel{


    public BottomPanel(){

        this.setBackground(new Color(58,62,69,255));
        JLabel sh = new JLabel("System Huset A/S");
        sh.setFont(new Font("Serif", Font.BOLD, 30));
        sh.setForeground(Color.WHITE);
        this.add(sh);

    }
    
}
