package dtu.pma.GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class IntroPanel extends JPanel{
    JButton addProjectBtn;
    JButton setIDBtn;
    JButton showWorkersBtn;
    
    public IntroPanel(){
        
        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();
        
        JLabel backgroundLabel = new JLabel();
        try {
            ImageIcon imageIcon = new ImageIcon(
                    new ImageIcon("background.png").getImage().getScaledInstance(700-5, 650, Image.SCALE_SMOOTH));
            backgroundLabel.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println(e);
        }
            
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 3;
        this.add(backgroundLabel,constrain);
        

        guiTool.resetConstrains(constrain);

        addProjectBtn = new JButton();
        addProjectBtn.setText("Add Project");
        constrain.fill = GridBagConstraints.HORIZONTAL;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0,10,0,0);
        constrain.weightx = 0.5; 
        constrain.weighty = 0.5;
        constrain.gridx = 0;
        constrain.gridy = 1;
        this.add(addProjectBtn,constrain);

        showWorkersBtn = new JButton();
        showWorkersBtn.setText("Set ID");
        constrain.weightx = 0.5; 
        constrain.gridx = 1;
        constrain.gridy = 1;
        constrain.insets = new Insets(0,10,0,0);
        this.add(showWorkersBtn,constrain);
 
        setIDBtn = new JButton();
        setIDBtn.setText("Show Workers");
        constrain.weightx = 0.5; 
        constrain.gridx = 2;
        constrain.gridy = 1;
        constrain.insets = new Insets(0,10,0,20);
        this.add(setIDBtn,constrain);
    


    }
}
