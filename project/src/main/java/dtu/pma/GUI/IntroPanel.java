package dtu.pma.GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class IntroPanel extends JPanel {
    
    public IntroPanel() {

        Dimension size = getPreferredSize();
        size.width = 100;
        size.height = 100;
        setPreferredSize(size);
        //this.setBackground(Color.WHITE);

      //  this.setLayout(new GridBagLayout());
      //  GridBagConstraints cg = new GridBagConstraints();
    
        
      /*  cg.gridx = 0;
        cg.gridy = 0;
        this.add(imgLabel);

        JLabel welcomeLabel = new JLabel("Welcome to the Project Management System");
        cg.gridx = 0;
        cg.gridy = 0;
        cg.fill = 2;
        cg.weighty = 0.45;
        this.add(welcomeLabel, cg);

        JButton enterBtn = new JButton("Enter");
        cg.gridx = 0;
        cg.gridy = 1;
        cg.fill = 2;
        this.add(enterBtn,cg);
        */
        this.add(imgLabel);


    }

}
