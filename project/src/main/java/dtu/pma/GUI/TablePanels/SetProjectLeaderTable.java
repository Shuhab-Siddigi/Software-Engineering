package dtu.pma.GUI.TablePanels;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;

public class SetProjectLeaderTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel workerModel = new DefaultTableModel();

    private JTable projectTable = new JTable();
    private JTable workerTable = new JTable();

    public SetProjectLeaderTable(PMA pma, int width, int height) {

        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        TableRowSorter<DefaultTableModel> workerSorter = new TableRowSorter<DefaultTableModel>(workerModel);
        projectTable.setRowSorter(projectSorter);
        workerTable.setRowSorter(workerSorter);

        setProjectTable(pma);
        setWorkerTable(pma);

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

    private void setProjectTable(PMA pma) {

        projectModel.addColumn("Title");
        projectModel.addColumn("ID");
        projectModel.addColumn("Project Leader");

        if(pma.getProjects() != null){
            for (Project p : pma.getProjects()) {
                if (p.getProjectLeader() != null) {
                    projectModel.addRow(
                            new Object[] { 
                            p.getInfo().getTitle(), 
                            p.getInfo().getID(), 
                            p.getProjectLeader().getID(), 
                        });
                } else {
                    projectModel.addRow(new Object[] { 
                        p.getInfo().getTitle(), 
                        p.getInfo().getID(), 
                        "", });
                }
            }
        }

        projectTable.setModel(projectModel);

    }

    public void addProject(Project p) {

        projectModel.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(), });

    }

    private void setWorkerTable(PMA pma) {

        workerModel.addColumn("Firstname");
        workerModel.addColumn("Lastname");
        workerModel.addColumn("ID");

        if(pma.getWorkers() != null){
            for (Worker w : pma.getWorkers()) {
                workerModel.addRow(new Object[] { 
                    w.getFirstname(), 
                    w.getLastname(), 
                    w.getID() });
            }
        }

        workerTable.setModel(workerModel);

    }

    public void update(PMA pma){
        
        workerModel.setRowCount(0);

        if(pma.getWorkers() != null){
            for (Worker w : pma.getWorkers()) {
                workerModel.addRow(new Object[] { 
                    w.getFirstname(), 
                    w.getLastname(), 
                    w.getID() });
            }
        }

        workerTable.setModel(workerModel);

        projectModel.setRowCount(0);
        if(pma.getProjects() != null){
            for (Project p : pma.getProjects()) {
                if (p.getProjectLeader() != null) {
                    projectModel.addRow(
                            new Object[] { 
                            p.getInfo().getTitle(), 
                            p.getInfo().getID(), 
                            p.getProjectLeader().getID(), 
                        });
                } else {
                    projectModel.addRow(new Object[] { 
                        p.getInfo().getTitle(), 
                        p.getInfo().getID(), 
                        "", });
                }
            }
        }
        projectTable.setModel(projectModel);
    }

    public void setProjectLeaderAtRow(String projectLeader, int row) {
        projectModel.setValueAt(projectLeader, row, 2);
    }

    public JTable getWorkerTable() {
        return workerTable;
    }

    public JTable getProjectTable() {
        return projectTable;
    }

}
