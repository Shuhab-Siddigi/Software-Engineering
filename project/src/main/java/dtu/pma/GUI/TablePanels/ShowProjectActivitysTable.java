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



public class ShowProjectActivitysTable extends JPanel{
       
    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();

    private JTable projectTable = new JTable();
    private JTable activityTable = new JTable();
   
    public ShowProjectActivitysTable (PMA pma, int width, int height){

        projectTable.setModel(getModel(pma,projectModel));
    
        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(projectSorter);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        projectScrollPane.setPreferredSize(new Dimension(width/2, height));

        
        activityTable.setModel(getModel(pma,activityModel));
    
        TableRowSorter<DefaultTableModel> activitySorter = new TableRowSorter<DefaultTableModel>(activityModel);
        activityTable.setRowSorter(activitySorter);

        JScrollPane activityScrollPane = new JScrollPane(activityTable);
        activityScrollPane.setPreferredSize(new Dimension(width, height/2));

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        JLabel project = new JLabel("Projects");
        project.setFont(new Font("Serif", Font.BOLD, 20));

        JLabel activities = new JLabel("Activities");
        activities.setFont(new Font("Serif", Font.BOLD, 20));

        constrain.fill = GridBagConstraints.CENTER;
        constrain.weightx = 1;
        constrain.weighty = 0.05;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(project, constrain);

        constrain.gridx = 0;
        constrain.gridy = 2;
        this.add(activities, constrain);

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

    }

    private DefaultTableModel getModel(PMA pma,DefaultTableModel model) {
        
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn( "Expected hours");
        model.addColumn("Hours Worked");
        model.addColumn("Start Date");
        model.addColumn("End Date");

        for (Project p : pma.getProjects()) {
            model.addRow(new Object[] { 
                p.getInfo().getTitle(), 
                p.getInfo().getID(),
                p.getInfo().getExpectedHours(),
                p.getInfo().getHoursWorked(),
            //    p.getInfo().getStartDate().toString(),
            //    p.getInfo().getEndDate().toString(), 
            });
        }

        return model;
    }

    public void update(PMA pma){
        projectModel.setRowCount(0);
        for (Project p : pma.getProjects()) {
            projectModel.addRow(new Object[] { 
                p.getInfo().getTitle(), 
                p.getInfo().getID(),
                p.getInfo().getExpectedHours(),
                p.getInfo().getHoursWorked(),
            //    p.getInfo().getStartDate().toString(),
            //    p.getInfo().getEndDate().toString(), 
            });
        }
        projectTable.setModel(projectModel);
    }
    
    public void setModel(Project p){
        
        activityModel.setRowCount(0);

        if(p.getActivities() != null){
            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { 
                    a.getInfo().getTitle(), 
                    a.getInfo().getID(),
                    a.getInfo().getExpectedHours(),
                    a.getInfo().getHoursWorked(),
                //    a.getInfo().getStartDate().toString(),
                //    a.getInfo().getEndDate().toString(), 
                });
            }
        }
    }

    public void addProject(Project p) {
        projectModel.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(), });
    }

    public JTable getProjectTable() {
        return projectTable;
    }

    public void addActivity(Activity activity) {
        activityModel.addRow(new Object[] {         
            activity.getInfo().getTitle(), 
            activity.getInfo().getID(),
            activity.getInfo().getStartDate().toString(),
            activity.getInfo().getEndDate().toString(), });
    }
}


