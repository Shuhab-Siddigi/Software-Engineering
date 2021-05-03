package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import java.awt.*;

import dtu.pma.PMA;
import dtu.pma.GUI.TablePanels.ShowProjectsTable;

public class ShowProjectsPanel extends JPanel{
    private ShowProjectsTable projectTable;
    public ShowProjectsPanel(PMA pma,ShowProjectsTable projectTable){
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        this.projectTable = projectTable;

        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 1;
        constrain.gridy = 1;

        this.add(projectTable,constrain);

        
    }
    public ShowProjectsTable getProjectTable(){
        return projectTable;
    }
}
