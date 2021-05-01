package dtu.pma.GUI.TablePanels;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;

public class AddWorkerToActivityTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel workerModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();

    private JTable projectTable;
    private JTable workerTable;
    private JTable activityTable;

    public AddWorkerToActivityTable(PMA pma, int width, int height) {

        workerTable = new JTable();
        projectTable = new JTable();
        activityTable = new JTable();

        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        TableRowSorter<DefaultTableModel> workerSorter = new TableRowSorter<DefaultTableModel>(workerModel);
        TableRowSorter<DefaultTableModel> activitySorter = new TableRowSorter<DefaultTableModel>(projectModel);

        projectTable.setRowSorter(projectSorter);
        workerTable.setRowSorter(workerSorter);
        activityTable.setRowSorter(activitySorter);

        projectTable = setProjectTable(pma, projectTable);
        workerTable = setWorkerTable(pma, workerTable);
        activityTable = setActivityTable(pma, activityTable);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        JScrollPane workerScrollPane = new JScrollPane(workerTable);
        JScrollPane activityScrollPane = new JScrollPane(activityTable);
        projectTable.setPreferredSize(new Dimension(width / 3, height));
        workerTable.setPreferredSize(new Dimension(width / 3, height));
        activityTable.setPreferredSize(new Dimension(width / 3, height));

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(workerScrollPane, constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(projectScrollPane, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(activityScrollPane, constrain);

    }

    private JTable setProjectTable(PMA pma, JTable jTable) {

        projectModel.addColumn("Title");
        projectModel.addColumn("ID");

        for (Project p : pma.getProjects()) {
            projectModel.addRow(
                    new Object[] { 
                        p.getInfo().getTitle(), 
                        p.getInfo().getID() }
            );
        }

        jTable.setModel(projectModel);

        return jTable;
    }

    public void addProject(Project p) {
        projectModel.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(), });

    }

    public JTable getProjectTable() {
        return projectTable;
    }

    private JTable setWorkerTable(PMA pma, JTable jTable) {

        workerModel.addColumn("Firstname");
        workerModel.addColumn("Lastname");
        workerModel.addColumn("ID");

        for (Worker w : pma.getWorkers()) {
            workerModel.addRow(new Object[] { w.getFirstname(), w.getLastname(), w.getID() });
        }

        jTable.setModel(workerModel);

        return jTable;
    }

    public void setProjectLeaderAtRow(String projectLeader, int row) {
        projectModel.setValueAt(projectLeader, row, 2);
    }

    public JTable getWorkerTable() {
        return workerTable;
    }

    private JTable setActivityTable(PMA pma, JTable jTable) {

        activityModel.addColumn("Title");
        activityModel.addColumn("ID");

        for (Project p : pma.getProjects()) {
            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { 
                    a.getInfo().getTitle(), 
                    a.getInfo().getID(),
                });
            }
        }

         jTable.setModel(activityModel);

        return jTable;
    }

    public void addActivity(Project p,Activity a) {

        //activityModel.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(), });

    }

}
