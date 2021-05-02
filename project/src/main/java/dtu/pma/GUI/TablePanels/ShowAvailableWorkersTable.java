package dtu.pma.GUI.TablePanels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;

public class ShowAvailableWorkersTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();
    private DefaultTableModel workerModel = new DefaultTableModel();

    private JTable projectTable = new JTable();
    private JTable activityTable = new JTable();
    private JTable workerTable = new JTable();

    public ShowAvailableWorkersTable(PMA pma, int width, int height) {

        projectTable.setModel(getModel(pma, projectModel));

        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(projectSorter);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        projectScrollPane.setPreferredSize(new Dimension(width / 3, height));

        activityTable.setModel(getModel(pma, activityModel));

        TableRowSorter<DefaultTableModel> activitySorter = new TableRowSorter<DefaultTableModel>(activityModel);
        activityTable.setRowSorter(activitySorter);

        JScrollPane activityScrollPane = new JScrollPane(activityTable);
        activityScrollPane.setPreferredSize(new Dimension(width / 3, height));

        workerTable.setModel(getWorkerModel(pma, workerModel));

        TableRowSorter<DefaultTableModel> workerSorter = new TableRowSorter<DefaultTableModel>(workerModel);
        workerTable.setRowSorter(workerSorter);

        JScrollPane workerScrollPane = new JScrollPane(workerTable);
        workerScrollPane.setPreferredSize(new Dimension(width / 3, height));

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.weightx = 1;
        constrain.weighty = 1;
        this.add(projectScrollPane, constrain);

        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(activityScrollPane, constrain);

        constrain.gridx = 2;
        constrain.gridy = 0;
        this.add(workerScrollPane, constrain);

    }

    private DefaultTableModel getModel(PMA pma, DefaultTableModel model) {

        model.addColumn("Title");
        model.addColumn("ID");

        for (Project p : pma.getProjects()) {
            model.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(), });
        }

        return model;
    }

    private DefaultTableModel getWorkerModel(PMA pma, DefaultTableModel model) {

        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("ID");
        return model;
    }

    public void setActivityModel(Project p) {

        activityModel.setRowCount(0);

        if (p.getActivities() != null) {
            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { a.getInfo().getTitle(), a.getInfo().getID(),

                });
            }
        }
    }

    public void setWorkerModel(PMA pma, Activity activity) {

        workerModel.setRowCount(0);
        if (pma.getWorkers() != null) {
// @WIP
            for (Worker w : pma.getWorkers()) {
                
                if (w.getActivities() != null) {
                   
                        //if (activity.getInfo().isFree(a.getInfo().getStartDate(), a.getInfo().getEndDate())) {
                 workerModel.addRow(new Object[] { w.getFirstname(), w.getFirstname(), w.getID(), });
                        //}
                    
                }

            }
        }

    }

    public void addActivity(Activity activity) {
        activityModel.addRow(new Object[] { activity.getInfo().getTitle(), activity.getInfo().getID(), });
    }

    public JTable getProjectTable() {
        return projectTable;
    }

    public JTable getActivityTable() {
        return activityTable;
    }
}
