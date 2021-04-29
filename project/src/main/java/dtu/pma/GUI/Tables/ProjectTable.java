package dtu.pma.GUI.Tables;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.PMA;
import dtu.pma.Project;

public class ProjectTable extends JPanel{
    
    private DefaultTableModel model = new DefaultTableModel();
    JTable projectTable = new JTable();

    public ProjectTable(PMA pma,int width, int height){

        projectTable = setTable(pma, projectTable);
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        projectTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(projectTable);
        scrollPane.setPreferredSize(new Dimension(width, height));
        this.add(scrollPane);

    }

    private JTable setTable(PMA pma,JTable jTable) {
      
        
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Hours Worked");
        model.addColumn("Expected Hours");
        model.addColumn("Description");
        model.addColumn("Project Leader");

        for (Project p : pma.getProjects()) {
            model.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
                    p.getInfo().getStartDate(), 
                    p.getInfo().getEndDate(), 
                    p.getInfo().getHoursWorked(), 
                    p.getInfo().getExpectedHours(), 
                    p.getInfo().getDescription(), 
                    p.getProjectLeader(), 
                }
            );
        }

        jTable.setModel(model);

        return jTable;
    }
    public void addProject(Project p){
        model.addRow(
            new Object[] {   
                p.getInfo().getTitle(), 
                p.getInfo().getID(), 
                p.getInfo().getStartDate(), 
                p.getInfo().getEndDate(), 
                p.getInfo().getHoursWorked(), 
                p.getInfo().getExpectedHours(), 
                p.getInfo().getDescription(), 
                p.getProjectLeader(), 
            }
        );
    }
    
  
}
