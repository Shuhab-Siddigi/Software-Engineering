package dtu.pma.GUI.Panels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;


public class LeftPanel extends JPanel {

    JTextField IDTextfield;
    
    public LeftPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        this.setBackground(new Color(58,62,69,255));

        JLabel logoLabel = new JLabel();
        try {
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon("logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            logoLabel.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println(e);
        }

        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.weighty = 1;
        constrain.weightx = 1;
        constrain.anchor = GridBagConstraints.PAGE_START;
        this.add(logoLabel, constrain);
        
        // IDTextfield = new JTextField(1);
        // IDTextfield.setText("Insert ID ..");
        // IDTextfield.setFont(new Font("Serif", Font.ITALIC, 13));
        // constrain.gridx = 0;
        // constrain.gridy = 1;
        // constrain.fill = GridBagConstraints.HORIZONTAL;
        // constrain.anchor = GridBagConstraints.PAGE_START;
        // constrain.insets = new Insets(20, 0, 0, 0);
        // this.add(IDTextfield, constrain);

        
    }



 

}
