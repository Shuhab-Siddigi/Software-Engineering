package dtu.pma.GUI.Panels;

import javax.swing.JPanel;
import java.awt.*;

import dtu.pma.PMA;
import dtu.pma.GUI.TablePanels.ProjectTable;

public class ShowProjectsPanel extends JPanel{
    private ProjectTable projectTable;
    public ShowProjectsPanel(PMA pma,ProjectTable projectTable){
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
    public ProjectTable getProjectTable(){
        return projectTable;
    }
}
