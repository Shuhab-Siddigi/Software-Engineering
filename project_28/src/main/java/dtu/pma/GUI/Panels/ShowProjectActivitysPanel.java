package dtu.pma.GUI.Panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;

import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.GUI.TablePanels.ShowProjectActivitysTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.Box;
import dtu.pma.Worker;

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
    private JButton editActvityBtn;

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
    private String startDate;
    private String endDate;

    public ShowProjectActivitysPanel(PMA pma, ShowProjectActivitysTable showProjectActivitysTable) {

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        removeProjectBtn = new JButton();
        removeProjectBtn.setText("Remove Project");

        removeActivityBtn = new JButton();
        removeActivityBtn.setText("Remove Activity from Project");

        removeWorkerBtn = new JButton();
        removeWorkerBtn.setText("Remove Worker from Activity");

        editActvityBtn = new JButton();
        editActvityBtn.setText("Edit activity dates");

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

        constrain.gridx = 3;
        constrain.gridy = 1;
        this.add(editActvityBtn, constrain);

        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.fill = GridBagConstraints.BOTH;
        constrain.weightx = 1;
        constrain.weighty = 0.9;
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.gridwidth = 4;

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
                    if (worker != null) {
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
                if (project == null) {
                    JOptionPane.showMessageDialog(editActvityBtn, "No project chosen");
                } else {
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
                    }
                }
            }
        });

        removeActivityBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (activity == null) {
                    JOptionPane.showMessageDialog(editActvityBtn, "No activity chosen");
                } else {
                    int a = JOptionPane.showConfirmDialog(removeActivityBtn, "Are you sure?");

                    if (a == JOptionPane.YES_OPTION) {
                        if (project.getProjectLeader() != null) {
                            projectLeaderID2 = JOptionPane.showInputDialog(removeProjectBtn,
                                    "Enter Project Leader ID ");
                            projectLeader2 = pma.getWorkerWithID(projectLeaderID2);
                        }
                        try {
                            project.removeActivity(projectLeader2, activity);
                            JOptionPane.showMessageDialog(removeProjectBtn, "Activity Removed");
                            showProjectActivitysTable.update(pma);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(removeProjectBtn, e1.getMessage());
                        }
                    }
                }
            }
        });

        removeWorkerBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (worker == null) {
                    JOptionPane.showMessageDialog(editActvityBtn, "No worker chosen");
                } else {
                    int a = JOptionPane.showConfirmDialog(removeWorkerBtn, "Are you sure?");
                    if (a == JOptionPane.YES_OPTION) {
                        if (project.getProjectLeader() != null) {
                            projectLeaderID3 = JOptionPane.showInputDialog(removeProjectBtn,
                                    "Enter Project Leader ID ");
                            projectLeader3 = pma.getWorkerWithID(projectLeaderID3);
                        }
                        try {
                            project.removeWorkerFromActivity(activity, worker, projectLeader3);
                            JOptionPane.showMessageDialog(removeProjectBtn, "Worker Removed");
                            showProjectActivitysTable.update(pma);
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(removeProjectBtn, e1.getMessage());
                        }
                    }
                }

            }
        });

        editActvityBtn.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (activity == null) {
                    JOptionPane.showMessageDialog(editActvityBtn, "No activity chosen");
                } else {
                    changeDateInputDialog();
                    try {
                        if(activity.isDateAllowed(startDate) && activity.isDateAllowed(endDate)){
                            Date start = Date.valueOf(startDate);
                            Date end = Date.valueOf(endDate);
                            pma.changeStartDateActivity(project, activity, start);
                            pma.changeEndDateActivity(project, activity, end);
                            showProjectActivitysTable.update(pma);
                            JOptionPane.showMessageDialog(editActvityBtn, "Dates changed! " + start + "\n" + end);
                        }
                    } catch (OperationNotAllowedException e1) {
                        JOptionPane.showMessageDialog(editActvityBtn, e1.getMessage());
                    }
                }

            }
        });
    }

    public void changeDateInputDialog() {
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Start Date:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("End Date:"));
        myPanel.add(yField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter X and Y Values",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            startDate = xField.getText();
            endDate = yField.getText();
        }

    }

}
