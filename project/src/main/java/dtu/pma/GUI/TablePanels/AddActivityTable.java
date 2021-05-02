package dtu.pma.GUI.TablePanels;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import dtu.pma.GUI.TablePanels.GenerateReportTable;

public class AddActivityTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();
    private DefaultTableModel activityModel = new DefaultTableModel();

    private JTable projectTable = new JTable();
    private JTable activityTable = new JTable();

    public AddActivityTable(PMA pma, int width, int height) {
        

        projectTable.setModel(getModel(pma,projectModel)); ;
    
        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(projectSorter);

        JScrollPane projectScrollPane = new JScrollPane(projectTable);
        projectScrollPane.setPreferredSize(new Dimension(width, height/2));

        
        activityTable.setModel(getModel(pma,activityModel));
    
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

 

    private DefaultTableModel getModel(PMA pma,DefaultTableModel model) {
        
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Start Date");
        model.addColumn("End Date");

        for (Project p : pma.getProjects()) {
            model.addRow(new Object[] { 
                p.getInfo().getTitle(), 
                p.getInfo().getID(),
                p.getInfo().getStartDate().toString(),
                p.getInfo().getEndDate().toString(), 
            });
        }

        return model;
    }
    public void setModel(Project p){
        
        activityModel.setRowCount(0);

        if(p.getActivities() != null){
            for (Activity a : p.getActivities()) {
                activityModel.addRow(new Object[] { 
                    a.getInfo().getTitle(), 
                    a.getInfo().getID(),
                    a.getInfo().getStartDate().toString(),
                    a.getInfo().getEndDate().toString(), 
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
