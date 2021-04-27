package dtu.pma.GUI.Panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dtu.pma.GUI.GUITools;

import java.awt.*;

public class IntroPanel extends JPanel{

    
    public IntroPanel(){
        
        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();
        
        JLabel backgroundLabel = new JLabel();
        try {
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon("background.png").getImage().getScaledInstance(800, 700, Image.SCALE_SMOOTH));
            backgroundLabel.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setText("Welcome to Project Management Application");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));

        constrain.anchor = GridBagConstraints.PAGE_START;
        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(welcomeLabel);

        constrain.anchor = GridBagConstraints.PAGE_START;
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.gridwidth = 3;     
         constrain.insets = new Insets(25,0,0,0);
        this.add(backgroundLabel,constrain);
        

        guiTool.resetConstrains(constrain);

      

    }
}
