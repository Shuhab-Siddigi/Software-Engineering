package dtu.pma.GUI.TablePanels;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;


public class AddActivityTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();

    private JTable projectTable = new JTable();
    private JTable activityTable = new JTable();

    public AddActivityTable(PMA pma, int width, int height) {
    
        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(projectSorter);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        projectScrollPane.setPreferredSize(new Dimension(width, height/2));

        setModels(pma);
    
        TableRowSorter<DefaultTableModel> activitySorter = new TableRowSorter<DefaultTableModel>(activityModel);
        activityTable.setRowSorter(activitySorter);

        JScrollPane activityScrollPane = new JScrollPane(activityTable);
        activityScrollPane.setPreferredSize(new Dimension(width, height/2));

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();


        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.gridx = 0;
        constrain.gridy = 0;
        constrain.weightx =1;
        constrain.weighty = 1;
        this.add(projectScrollPane, constrain);

        constrain.gridx = 0;
        constrain.gridy = 1;
        this.add(activityScrollPane, constrain);

    }

    private void setModels(PMA pma) {
        
         projectModel.addColumn("Title");
        projectModel.addColumn("ID");
        projectModel.addColumn("Start Date");
        projectModel.addColumn("End Date");

        activityModel.addColumn("Title");
        activityModel.addColumn("ID");
        activityModel.addColumn("Start Date");
        activityModel.addColumn("End Date");

        projectTable.setModel(projectModel);
        activityTable.setModel(activityModel);
        
        update(pma);
    }
    public void update(PMA pma){
        projectModel.setRowCount(0);

        if(pma.getProjects() != null){
            for (Project p : pma.getProjects()) {
                projectModel.addRow(new Object[] { 
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(),
                    p.getInfo().getStartDate(),
                    p.getInfo().getEndDate(), 
                });
            }
        projectTable.setModel(projectModel);
        
        }
    }

    public void setActivityModel(Project p){
        activityModel.setRowCount(0);
        
        if(p.getActivities() != null){
            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { 
                    a.getInfo().getTitle(), 
                    a.getInfo().getID(),
                    a.getInfo().getStartDate(),
                    a.getInfo().getEndDate(), 
                });
            }
        activityTable.setModel(activityModel);
        }
    }

    public void addActivity(Activity activity) {
        if(activity != null){
        activityModel.addRow(new Object[] {         
             activity.getInfo().getTitle(), 
             activity.getInfo().getID(),
             activity.getInfo().getStartDate(),
             activity.getInfo().getEndDate(), 
        });
        }
    }

  

    public JTable getProjectTable() {
        return projectTable;
    }


}
