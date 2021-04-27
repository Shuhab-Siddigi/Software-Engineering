package dtu.pma.GUI;

import java.awt.*;

public class GUITools {
    
    public void resetConstrains(GridBagConstraints constrain) {
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.fill = GridBagConstraints.NONE;
        constrain.anchor = GridBagConstraints.LINE_START;
        constrain.weightx = 0.0;
        constrain.weighty = 0.0;
        constrain.insets = new Insets(0, 0, 0, 0); // Padding
        constrain.ipadx = 0; // request any extra vertical space
        constrain.ipady = 0; // request any extra vertical space
        constrain.gridwidth = 1;
    }

}
