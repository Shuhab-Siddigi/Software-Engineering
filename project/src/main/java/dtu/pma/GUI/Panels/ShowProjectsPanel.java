package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import java.awt.*;

import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;

public class ShowProjectsPanel extends JPanel{


    public ShowProjectsPanel(PMA pma){
        setLayout(new GridBagLayout());
        GUITools guiTool = new GUITools();
        GridBagConstraints constrain = new GridBagConstraints();

        ProjectTable projectTable = new ProjectTable(pma, 800, 700);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(10, 0, 10, 10);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 1;
        constrain.gridy = 1;

        this.add(projectTable,constrain);
        
    }
}
