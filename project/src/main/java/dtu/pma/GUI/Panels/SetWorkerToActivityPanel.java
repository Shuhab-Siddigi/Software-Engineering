package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import dtu.pma.GUI.TablePanels.SetWorkerToActivityTabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class SetWorkerToActivityPanel extends JPanel{
    private Project project;
    private Activity activity;
    private Worker worker;
    private String projectID;
    private String activityID;
    private String workerID;
    
    private int selectedProjectRow;
    private int selectedActivityRow;
    private int selectedWorkerRow;


    public SetWorkerToActivityPanel(PMA pma,SetWorkerToActivityTabel setWorkerToActivityTabel){
        
        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();
        
        JLabel projectLabel = new JLabel("Projects");
        projectLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel activitiesLabel = new JLabel("Activities");
        activitiesLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel workersLabel = new JLabel("Available Workers");
        workersLabel.setFont(new Font("Serif", Font.BOLD, 20));

        JTextField setProjectLeaderTextField = new JTextField("Set Project Leader ID ..");
        JLabel setProjectLeaderLabel = new JLabel();
        setProjectLeaderLabel.setText("Set Project Leader");
        setProjectLeaderLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        JButton setWorkerToActivityBtn = new JButton();
        setWorkerToActivityBtn.setText("Set Worker to Activity");
        setWorkerToActivityBtn.setFont(new Font("Serif", Font.BOLD, 15));



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
        this.add(setWorkerToActivityTabel, constrain);

        constrain.insets = new Insets(20, 0, 0, 0);
        constrain.anchor = GridBagConstraints.WEST;
  
        constrain.weightx = 0.1;
        constrain.weighty = 0.03;
        constrain.gridx = 0;
        constrain.gridy = 2;
        constrain.gridwidth = 1;
        this.add(setProjectLeaderLabel,constrain);

        constrain.gridx = 1;
        constrain.gridy = 2;
        constrain.weightx = 1;
        this.add(setProjectLeaderTextField,constrain);
        
        constrain.gridx = 2;
        constrain.gridy = 2;
        constrain.weightx = 0.1;
        this.add(setWorkerToActivityBtn,constrain);



        setWorkerToActivityTabel.getProjectTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setWorkerToActivityTabel.getProjectTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedProjectRow = rowSelectionModel.getMinSelectionIndex();
                    projectID = setWorkerToActivityTabel.getProjectTable().getModel().getValueAt(selectedProjectRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(projectID));
                    setWorkerToActivityTabel.setActivityModel(project);
                }
            }
        });

        setWorkerToActivityTabel.getActivityTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setWorkerToActivityTabel.getActivityTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedActivityRow = rowSelectionModel.getMinSelectionIndex();
                    activityID = setWorkerToActivityTabel.getActivityTable().getModel().getValueAt(selectedActivityRow, 1).toString();
                    activity = project.getActivityFromID(Integer.parseInt(activityID));
                    try {
                        setWorkerToActivityTabel.setWorkerModel(pma,activity);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(setWorkerToActivityTabel, e1.getMessage());
                        e1.printStackTrace();
                    }
                }
            }
        });

        setWorkerToActivityTabel.getWorkerTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setWorkerToActivityTabel.getWorkerTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedWorkerRow = rowSelectionModel.getMinSelectionIndex();
                    workerID = setWorkerToActivityTabel.getWorkerTable().getModel().getValueAt(selectedWorkerRow, 2).toString();
                    worker = pma.getWorkerWithID(workerID);
                }
            }
        });

              

        setWorkerToActivityBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if(worker == null){
                    JOptionPane.showMessageDialog(setWorkerToActivityBtn, "No worker choosen");
                } else if (activity == null){
                    JOptionPane.showMessageDialog(setWorkerToActivityBtn, "No activity choosen");
                } else{
                    try {
                        project.addWorkerToActivity(activity, worker, pma.getWorkerWithID(setProjectLeaderTextField.getText()));
                        JOptionPane.showMessageDialog(setWorkerToActivityBtn, "Worker added to activity");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(setWorkerToActivityBtn, e1.getMessage());
                    }
                }
            }
        });

        setProjectLeaderTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setProjectLeaderTextField.setText("");
            }
        });
    }

}
