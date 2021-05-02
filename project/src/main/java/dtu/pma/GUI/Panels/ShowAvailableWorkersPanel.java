package dtu.pma.GUI.Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TablePanels.ShowAvailableWorkersTable;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ShowAvailableWorkersPanel extends JPanel{
    private Project project;
    private Activity activity;
    private String projectID;
    private String activityID;
    
    private int selectedProjectRow;
    private int selectedActivityRow;


    public ShowAvailableWorkersPanel(PMA pma,ShowAvailableWorkersTable showAvailableWorkersTable){
        
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        
        JLabel projectLabel = new JLabel("Projects");
        projectLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel activitiesLabel = new JLabel("Activities");
        activitiesLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel workersLabel = new JLabel("Available Workers");
        workersLabel.setFont(new Font("Serif", Font.BOLD, 20));

        constrain.fill = GridBagConstraints.CENTER;
        constrain.weightx = 1;
        constrain.weighty = 0.05;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(projectLabel, constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(activitiesLabel, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(workersLabel, constrain);
    
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.BOTH;
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.gridwidth = 3;
        this.add(showAvailableWorkersTable, constrain);

        showAvailableWorkersTable.getProjectTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showAvailableWorkersTable.getProjectTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedProjectRow = rowSelectionModel.getMinSelectionIndex();
                    projectID = showAvailableWorkersTable.getProjectTable().getModel().getValueAt(selectedProjectRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(projectID));
                    showAvailableWorkersTable.setActivityModel(project);
                }
            }
        });

        showAvailableWorkersTable.getActivityTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showAvailableWorkersTable.getActivityTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedActivityRow = rowSelectionModel.getMinSelectionIndex();
                    activityID = showAvailableWorkersTable.getActivityTable().getModel().getValueAt(selectedActivityRow, 1).toString();
                    activity = project.getActivityFromID(Integer.parseInt(activityID));
                    showAvailableWorkersTable.setWorkerModel(pma,activity);
                }
            }
        });
    }
    
}
