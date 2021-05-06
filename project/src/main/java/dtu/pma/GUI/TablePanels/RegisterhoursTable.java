package dtu.pma.GUI.TablePanels;

import javax.swing.JPanel;
import java.awt.*;

import dtu.pma.Activity;
import dtu.pma.PMA;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import dtu.pma.Worker;

public class RegisterhoursTable extends JPanel{

    private DefaultTableModel workerModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();

    private JTable workerTable = new JTable();
    private JTable activityTable = new JTable();

    public RegisterhoursTable(PMA pma){
       
        TableRowSorter<DefaultTableModel> workerSorter = new TableRowSorter<DefaultTableModel>(workerModel);
        workerTable.setRowSorter(workerSorter);
        JScrollPane workerScrollPane = new JScrollPane(workerTable);

        TableRowSorter<DefaultTableModel> acitivtySorter = new TableRowSorter<DefaultTableModel>(activityModel);
        activityTable.setRowSorter(acitivtySorter);

        setModels(pma);

        JScrollPane activityScrollPane = new JScrollPane(activityTable);


        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.weightx = 1;
        constrain.weighty = 1;
        this.add(workerScrollPane, constrain);
        
        constrain.gridx = 1;
        constrain.gridy = 0;
        this.add(activityScrollPane, constrain);

    }

    private void setModels(PMA pma) {

        workerModel.addColumn("Firstname");
        workerModel.addColumn("Lastname");
        workerModel.addColumn("ID");

        activityModel.addColumn("Title");
        activityModel.addColumn("ID");
        activityModel.addColumn("Hours Worked");
        activityModel.addColumn("Expected Hours");

        
        if(pma.getWorkers() != null){
            for (Worker w : pma.getWorkers()) {
                workerModel.addRow(new Object[] { 
                    w.getFirstname(), 
                    w.getLastname(), 
                    w.getID() });
            }
        }
        update(pma);
        
        workerTable.setModel(workerModel);
        
        activityTable.setModel(activityModel);

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
        workerTable.setModel(workerModel);
        }

        

    }

    public void setActivityModel(Worker w) {

        activityModel.setRowCount(0);

        if (w.getActivities() != null) {
            for (Activity a : w.getActivities()) {
                activityModel.addRow(new Object[] { 
                    a.getInfo().getTitle(), 
                    a.getInfo().getID(),
                    a.getInfo().getHoursWorked(),
                    a.getInfo().getExpectedHours(),
                });
            }
        activityTable.setModel(activityModel);
        }

        
    }


    public JTable getWorkerTable() {
        return workerTable;
    }
    public JTable getActivityTable(){
        return activityTable;
    }
    
}
