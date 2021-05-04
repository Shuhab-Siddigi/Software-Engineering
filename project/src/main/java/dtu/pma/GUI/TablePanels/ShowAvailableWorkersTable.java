package dtu.pma.GUI.TablePanels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;
import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;

public class ShowAvailableWorkersTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();
    private DefaultTableModel workerModel = new DefaultTableModel();
    private List<Worker> workers;

    private JTable projectTable = new JTable();
    private JTable activityTable = new JTable();
    private JTable workerTable = new JTable();

    public ShowAvailableWorkersTable(PMA pma, int width, int height) {

        setModels(pma);

        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(projectSorter);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        projectScrollPane.setPreferredSize(new Dimension(width / 3, height));

        

        TableRowSorter<DefaultTableModel> activitySorter = new TableRowSorter<DefaultTableModel>(activityModel);
        activityTable.setRowSorter(activitySorter);

        JScrollPane activityScrollPane = new JScrollPane(activityTable);
        activityScrollPane.setPreferredSize(new Dimension(width / 3, height));

        
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

   

    private void setModels(PMA pma) {

        projectModel.addColumn("Title");
        projectModel.addColumn("ID");

        activityModel.addColumn("Title");
        activityModel.addColumn("ID");

        workerModel.addColumn("Firstname");
        workerModel.addColumn("Lastname");
        workerModel.addColumn("ID");

        update(pma);

    }

    public void update(PMA pma){

        projectModel.setRowCount(0);
        
        if(pma.getProjects() != null){
            for (Project p : pma.getProjects()) {
                projectModel.addRow(new Object[] {
                     p.getInfo().getTitle(), 
                     p.getInfo().getID(), 
                });
            }
        }
    
        projectTable.setModel(projectModel);
    }

    public void setActivityModel(Project p) {

        activityModel.setRowCount(0);

        if (p.getActivities() != null) {
            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { a.getInfo().getTitle(), a.getInfo().getID(),

                });
            }
        activityTable.setModel(activityModel);
        }

        
    }

    public void setWorkerModel(PMA pma, Activity activity) throws Exception {

        workerModel.setRowCount(0);
        if (pma.getWorkers() != null) {

      workers = pma.findAvaliableWorkersByDates(
            pma.getWorkers(), 
            activity.getInfo().getStartDate(), 
            activity.getInfo().getEndDate()
            );
        if(workers != null){
           for (Worker worker : workers) {
            workerModel.addRow(new Object[] { worker.getFirstname(), worker.getFirstname(), worker.getID(), });       
           } 
        }
               
          
        workerTable.setModel(workerModel);
        }

    }

    public JTable getProjectTable() {
        return projectTable;
    }

    public JTable getActivityTable() {
        return activityTable;
    }
}
