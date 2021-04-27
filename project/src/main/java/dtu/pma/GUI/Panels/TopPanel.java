package dtu.pma.GUI.Panels;

import java.awt.*;
import javax.swing.*;

import dtu.pma.GUI.GUITools;

public class TopPanel extends JPanel{
    
    JButton homeBtn;
    JButton addProjectBtn;
    JButton setIDBtn;
    JButton showWorkersBtn;
    
    public TopPanel() {

        this.setBackground(new Color(58,62,69,255));
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        homeBtn = new JButton();
        homeBtn.setText("Home");
        constrain.fill = GridBagConstraints.HORIZONTAL;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0,10,0,0);
        constrain.weightx = 0.5; 
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(homeBtn,constrain);

        addProjectBtn = new JButton();
        addProjectBtn.setText("Add Project");

        constrain.weighty = 0.5;
        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(addProjectBtn,constrain);

        showWorkersBtn = new JButton();
        showWorkersBtn.setText("Set ID");
        constrain.weightx = 0.5; 
        constrain.gridx = 2;
        constrain.gridy = 0;
        constrain.insets = new Insets(0,10,0,0);
        this.add(showWorkersBtn,constrain);
 
        setIDBtn = new JButton();
        setIDBtn.setText("Show Workers");
        constrain.weightx = 0.5; 
        constrain.gridx = 3;
        constrain.gridy = 0;
        constrain.insets = new Insets(0,10,0,20);
        this.add(setIDBtn,constrain);


            
    }

    public JButton getHomeBtn() {
        return homeBtn;
    }
    public JButton getAddProjectBtn() {
        return addProjectBtn;
    }






    
}
