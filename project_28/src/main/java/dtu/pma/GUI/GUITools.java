package dtu.pma.GUI;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUITools {
    
    public void resetConstrains(GridBagConstraints constrain) {
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.fill = GridBagConstraints.NONE;
        constrain.anchor = GridBagConstraints.LINE_START;
        constrain.weightx = 0.0;
        constrain.weighty = 0.0;
        constrain.insets = new Insets(0, 0, 0, 0); 
        constrain.ipadx = 0;
        constrain.ipady = 0;
        constrain.gridwidth = 1;
    }


      public void showBorder(JPanel panel) {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
    }

}
