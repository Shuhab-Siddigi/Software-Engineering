package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.*;

import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TablePanels.ShowProjectActivitysTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.Worker;
import dtu.pma.GUI.GUITools;
import dtu.pma.GUI.TablePanels.SetProjectLeaderTable;

public class ShowProjectActivitysPanel extends JPanel {

    private Project project;
    private Activity activity;
    private Worker worker;
    private String projectID;
    private String activityID;
    private String workerID;
    private int selectedProjectRow;
    private int selectedActivityRow;
    private int selectedWorkerRow;
    private JButton removeProjectBtn;
    private JButton removeActivityBtn;
    private JButton removeWorkerBtn;

    private JTable projectTable;
    private JTable activityTable;
    private JTable workerTable;
    private TableModel projectModel;
    private TableModel activtiyModel;
    private TableModel workerModel;

    private Worker projectLeader1;
    private String projectLeaderID1;
    private Worker projectLeader2;
    private String projectLeaderID2;
    private Worker projectLeader3;
    private String projectLeaderID3;

    public ShowProjectActivitysPanel(PMA pma, ShowProjectActivitysTable showProjectActivitysTable) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        removeProjectBtn = new JButton();
        removeProjectBtn.setText("Remove Project");

        removeActivityBtn = new JButton();
        removeActivityBtn.setText("Remove Activity from Project");

        removeWorkerBtn = new JButton();
        removeWorkerBtn.setText("Remove Worker from Activity");

        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.BOTH;
        constrain.weighty = 0.05;
        constrain.weightx = 1;
        constrain.gridx = 0;
        constrain.gridy = 1;
        this.add(removeProjectBtn, constrain);

        constrain.gridx = 1;
        constrain.gridy = 1;
        this.add(removeActivityBtn, constrain);

        constrain.gridx = 2;
        constrain.gridy = 1;
        this.add(removeWorkerBtn, constrain);

        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.BOTH;
        constrain.weightx = 1;
        constrain.weighty = 0.9;
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 3;

        this.add(showProjectActivitysTable, constrain);

        projectTable = showProjectActivitysTable.getProjectTable();
        activityTable = showProjectActivitysTable.getActivityTable();
        workerTable = showProjectActivitysTable.getWorkerTable();

        projectModel = showProjectActivitysTable.getProjectTable().getModel();
        activtiyModel = showProjectActivitysTable.getActivityTable().getModel();
        workerModel = showProjectActivitysTable.getWorkerTable().getModel();

        projectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        projectTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedProjectRow = rowSelectionModel.getMinSelectionIndex();
                    projectID = projectModel.getValueAt(selectedProjectRow, 1).toString();
                    project = pma.getProjectWithID(Integer.parseInt(projectID));
                    showProjectActivitysTable.setActivityModel(project);
                    if(worker != null){
                        showProjectActivitysTable.flushWorkerTable();
                    }

                }
            }
        });

        activityTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        activityTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedActivityRow = rowSelectionModel.getMinSelectionIndex();
                    activityID = activtiyModel.getValueAt(selectedActivityRow, 1).toString();
                    activity = project.getActivityFromID(Integer.parseInt(activityID));
                    showProjectActivitysTable.setWorkerModel(pma, activity);

                }
            }
        });

        workerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        workerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel rowSelectionModel = (ListSelectionModel) e.getSource();
                if (!rowSelectionModel.isSelectionEmpty()) {

                    selectedWorkerRow = rowSelectionModel.getMinSelectionIndex();
                    workerID = workerModel.getValueAt(selectedWorkerRow, 2).toString();
                    worker = pma.getWorkerWithID(workerID);

                }
            }
        });

        removeProjectBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                int a = JOptionPane.showConfirmDialog(removeProjectBtn, "Are you sure?");

                if (a == JOptionPane.YES_OPTION) {
                    try {
                        if (project.getProjectLeader() != null) {
                            projectLeaderID1 = JOptionPane.showInputDialog(removeProjectBtn,
                                    "Enter Project Leader ID ");
                            projectLeader1 = pma.getWorkerWithID(projectLeaderID1);
                        }
                        pma.removeProject(projectLeader1, project);
                        JOptionPane.showMessageDialog(removeProjectBtn, "Project Removed");
                        showProjectActivitysTable.update(pma);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(removeProjectBtn, e1.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(removeWorkerBtn, "Wuss");
                }
            }
        });

        removeActivityBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                int a = JOptionPane.showConfirmDialog(removeActivityBtn, "Are you sure?");

                if (a == JOptionPane.YES_OPTION) {
                    if (project.getProjectLeader() != null) {
                        projectLeaderID2 = JOptionPane.showInputDialog(removeProjectBtn, "Enter Project Leader ID ");
                        projectLeader2 = pma.getWorkerWithID(projectLeaderID2);
                    }
                    try {
                        project.removeActivity(projectLeader2, activity);
                        JOptionPane.showMessageDialog(removeProjectBtn, "Activ Removed");
                        showProjectActivitysTable.update(pma);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(removeProjectBtn, e1.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(removeWorkerBtn, "Wuss");
                }

            }
        });

        removeWorkerBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int a = JOptionPane.showConfirmDialog(removeWorkerBtn, "Are you sure?");

                if (a == JOptionPane.YES_OPTION) {
                    if (project.getProjectLeader() != null) {
                        projectLeaderID3 = JOptionPane.showInputDialog(removeProjectBtn, "Enter Project Leader ID ");
                        projectLeader3 = pma.getWorkerWithID(projectLeaderID3);
                    }
                    try {
                        project.removeWorkerFromActivity(activity, worker, projectLeader3);
                        JOptionPane.showMessageDialog(removeProjectBtn, "Worker Removed");
                        showProjectActivitysTable.update(pma);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(removeProjectBtn, e1.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(removeWorkerBtn, "Wuss");
                }
            }
        });

    }

}
