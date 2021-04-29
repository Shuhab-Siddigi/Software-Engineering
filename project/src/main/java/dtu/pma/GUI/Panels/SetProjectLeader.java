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
        GUITools guiTools = new GUITools();

        JLabel projectLabel = new JLabel();
        projectLabel.setText("Projects");
        projectLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel workerLabel = new JLabel();
        workerLabel.setText("Workers");
        workerLabel.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel projectLabel2 = new JLabel();
        projectLabel2.setText("Projects:");
        projectLabel2.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel projectLabel3 = new JLabel();
        projectLabel3.setText("Press on Project ..");
        projectLabel3.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel workerLabel2 = new JLabel();
        workerLabel2.setText("Workers:");
        workerLabel2.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel workerLabel3 = new JLabel();
        workerLabel3.setText("Press on Worker ..");
        workerLabel3.setFont(new Font("Serif", Font.BOLD, 15));

        JButton addProjectLeader = new JButton();
        addProjectLeader.setText("ADD PROJECT LEADER");
        addProjectLeader.setFont(new Font("Serif", Font.BOLD, 15));
        

        constrain.fill = GridBagConstraints.CENTER;
        constrain.weightx = 0.4;
        constrain.weighty = 0.1;
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 2;
        this.add(workerLabel,constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(projectLabel,constrain);
        
        constrain.fill = GridBagConstraints.BOTH;
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.weighty = 0.8;
        constrain.gridwidth = 4;
        this.add(projectWithoutProjectLeaderTable,constrain);

        guiTools.resetConstrains(constrain);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.gridx = 0;
        constrain.gridy = 2;
        constrain.weighty = 0.2;
        constrain.weightx = 0.2;
        this.add(projectLabel2,constrain);
        constrain.gridx = 1;
        constrain.gridy = 2;
        this.add(projectLabel3,constrain);
        constrain.gridx = 2;
        constrain.gridy = 2;
        this.add(workerLabel2,constrain);
        constrain.gridx = 3;
        constrain.gridy = 2;
        this.add(workerLabel3,constrain);

        constrain.gridx = 0;
        constrain.gridy = 3;
        constrain.gridwidth = 4;
        constrain.weighty = 0.1;
        this.add(addProjectLeader,constrain);

    }
    
}
