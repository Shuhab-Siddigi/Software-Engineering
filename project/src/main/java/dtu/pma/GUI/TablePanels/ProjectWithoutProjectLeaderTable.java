package dtu.pma.GUI.TablePanels;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;

public class ProjectWithoutProjectLeaderTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel workerModel = new DefaultTableModel();

    JTable projectTable = new JTable();
    JTable workerTable = new JTable();
    PMA pma;

    public ProjectWithoutProjectLeaderTable(PMA pma, int width, int height) {

        this.pma = pma;

        workerTable = new JTable();
        projectTable = new JTable();

        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        TableRowSorter<DefaultTableModel> workerSorter = new TableRowSorter<DefaultTableModel>(workerModel);
        projectTable.setRowSorter(projectSorter);
        workerTable.setRowSorter(workerSorter);

        projectTable = setProjectTable(pma, projectTable);
        workerTable = setWorkerTable(pma, workerTable);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        JScrollPane workerScrollPane = new JScrollPane(workerTable);
        projectTable.setPreferredSize(new Dimension(width / 2, height));
        workerTable.setPreferredSize(new Dimension(width / 2, height));

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

    }

    private JTable setProjectTable(PMA pma, JTable jTable) {

        projectModel.addColumn("Title");
        projectModel.addColumn("ID");
        projectModel.addColumn("Project Leader");

        for (Project p : pma.getProjects()) {
            projectModel.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(),
                    p.getInfo().getDescription(), p.getProjectLeader(), });
        }

        jTable.setModel(projectModel);

        return jTable;
    }

    public void addProject(Project p) {
        projectModel.addRow(new Object[] { 
            p.getInfo().getTitle(), 
            p.getInfo().getID(),
        });

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

    public void setProjectLeaderAtRow(String projectLeader,int row) {
        projectModel.setValueAt(projectLeader, row, 2);
    }

    public JTable getWorkerTable() {
        return workerTable;
    }

    public JTable getProjectTable() {
        return projectTable;
    }

}
