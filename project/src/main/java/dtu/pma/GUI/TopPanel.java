package dtu.pma.GUI;

import java.awt.*;
import javax.swing.*;

public class TopPanel extends JPanel{
    
    JButton homeBtn;
    JButton leftBtn;
    JButton rightBtn;
    
    public TopPanel() {

        this.setBackground(new Color(58,62,69,255));
        GUITools guiTool = new GUITools();
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        homeBtn = new JButton();
        homeBtn.setText("Home");
        
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.insets = new Insets(0, 15, 0, 0); // Padding
        constrain.anchor = GridBagConstraints.WEST;
        constrain.weightx = 0.8;
        this.add(homeBtn,constrain);
        guiTool.resetConstrains(constrain);
          
        leftBtn = new JButton();
        leftBtn.setText(" < ");

        constrain.gridx = 1;
        constrain.gridy = 0;
        constrain.weightx = 0.1;
        constrain.insets = new Insets(0, 20, 0, 0); // Padding
        this.add(leftBtn,constrain);

        rightBtn = new JButton();
        rightBtn.setText(" > ");
        constrain.gridx = 2;
        constrain.gridy = 0;
        constrain.weightx = 0.1;
        this.add(rightBtn,constrain);
            
    }

    public JButton getHomeBtn() {
        return homeBtn;
    }
    public JButton getLeftBtn() {
        return leftBtn;
    }
    public JButton getRightBtn() {
        return rightBtn;
    }




    
}
