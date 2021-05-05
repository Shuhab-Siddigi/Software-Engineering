package dtu.pma.GUI.TablePanels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;


public class ShowProjectActivitysTable extends JPanel{
       
    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();
    private DefaultTableModel workerModel = new DefaultTableModel();

    private JTable projectTable = new JTable();
    private JTable activityTable = new JTable();
    private JTable workerTable = new JTable();
   
    public ShowProjectActivitysTable (PMA pma, int width, int height){

       
        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(projectSorter);
        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        projectScrollPane.setPreferredSize(new Dimension(width/3, height));
    
        TableRowSorter<DefaultTableModel> activitySorter = new TableRowSorter<DefaultTableModel>(activityModel);
        activityTable.setRowSorter(activitySorter);
        JScrollPane activityScrollPane = new JScrollPane(activityTable);
        activityScrollPane.setPreferredSize(new Dimension(width, height/3));

        TableRowSorter<DefaultTableModel> workerSorter = new TableRowSorter<DefaultTableModel>(workerModel);
        workerTable.setRowSorter(workerSorter);
        JScrollPane workerScrollPane = new JScrollPane(workerTable);
        workerScrollPane.setPreferredSize(new Dimension(width / 3, height));

        getModel(pma);

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        JLabel project = new JLabel("Projects");
        project.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel activities = new JLabel("Activities");
        activities.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel workers = new JLabel("Workers");
        workers.setFont(new Font("Serif", Font.BOLD, 20));

        constrain.fill = GridBagConstraints.CENTER;
        constrain.weightx = 1;
        constrain.weighty = 0.05;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(project, constrain);

        constrain.gridx = 0;
        constrain.gridy = 2;
        this.add(activities, constrain);


        constrain.gridx = 0;
        constrain.gridy = 4;
        this.add(workers, constrain);

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.gridx = 0;
        constrain.gridy = 1;
        constrain.weightx =1;
        constrain.weighty = 1;
        this.add(projectScrollPane, constrain);

        constrain.gridx = 0;
        constrain.gridy = 3;
        this.add(activityScrollPane, constrain);

        constrain.gridx = 0;
        constrain.gridy = 5;
        this.add(workerScrollPane, constrain);

    }

    private void getModel(PMA pma) {
        
        projectModel.addColumn("Title");
        projectModel.addColumn("ID");
        projectModel.addColumn( "Expected hours");
        projectModel.addColumn("Hours Worked");
        projectModel.addColumn("Start Date");
        projectModel.addColumn("End Date");

        activityModel.addColumn("Title");
        activityModel.addColumn("ID");
        activityModel.addColumn( "Expected hours");
        activityModel.addColumn("Hours Worked");
        activityModel.addColumn("Start Date");
        activityModel.addColumn("End Date");

        workerModel.addColumn("Firstname");
        workerModel.addColumn("Lastname");
        workerModel.addColumn("ID");

        update(pma);

       
    }

    public void update(PMA pma){
        projectModel.setRowCount(0);
        for (Project p : pma.getProjects()) {
            projectModel.addRow(new Object[] { 
                p.getInfo().getTitle(), 
                p.getInfo().getID(),
                p.getInfo().getExpectedHours(),
                p.getInfo().getHoursWorked(),
                p.getInfo().getStartDate(),
                p.getInfo().getEndDate(), 
            });
        }
        projectTable.setModel(projectModel);
        activityTable.setModel(activityModel);
        workerTable.setModel(workerModel);
        activityModel.setRowCount(0);
        workerModel.setRowCount(0);
    }
    
    public void setActivityModel(Project p){
        
        activityModel.setRowCount(0);

            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { 
                    a.getInfo().getTitle(), 
                    a.getInfo().getID(),
                    a.getInfo().getExpectedHours(),
                    a.getInfo().getHoursWorked(),
                    a.getInfo().getStartDate(),
                    a.getInfo().getEndDate(), 
                });
            }
        activityTable.setModel(activityModel);
    }

    public void setWorkerModel(PMA pma, Activity activity) {

        workerModel.setRowCount(0);
            for (Worker worker : activity.getWorkers()) {
                workerModel.addRow(new Object[]{
                    activity.getWorker(worker.getID()).getFirstname(),
                    activity.getWorker(worker.getID()).getLastname(),
                    activity.getWorker(worker.getID()).getID(),
                });
            }
        workerTable.setModel(workerModel);
    }

    public JTable getProjectTable() {
        return projectTable;
    }
    public JTable getActivityTable() {
        return activityTable;
    }
    
    public JTable getWorkerTable() {
        return workerTable;
    }
    public void flushActivityTable(){
        activityModel.setRowCount(0);
    }
    public void flushWorkerTable(){
        workerModel.setRowCount(0);
    }

  
 
}


