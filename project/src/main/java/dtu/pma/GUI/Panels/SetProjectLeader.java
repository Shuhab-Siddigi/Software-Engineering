package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dtu.pma.PMA;
import dtu.pma.GUI.GUITools;
import dtu.pma.GUI.TablePanels.ProjectTable;
import dtu.pma.GUI.TablePanels.ProjectWithoutProjectLeaderTable;

public class SetProjectLeader extends JPanel{


    public SetProjectLeader(PMA pma,ProjectWithoutProjectLeaderTable projectWithoutProjectLeaderTable){

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        JLabel projectLabel = new JLabel();
        projectLabel.setText("Projects");
        projectLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel workerLabel = new JLabel();
        workerLabel.setText("Workers");
        workerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.CENTER;
        constrain.weightx = 0.5;
        constrain.weighty = 0.1;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(workerLabel,constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(projectLabel,constrain);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.weighty = 0.8;
        constrain.gridwidth = 2;
        this.add(projectWithoutProjectLeaderTable,constrain);

    }
    
}
