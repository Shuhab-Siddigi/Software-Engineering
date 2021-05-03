package dtu.pma.GUI.TablePanels;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.PMA;
import dtu.pma.Project;

public class ShowProjectsTable extends JPanel{
    
    private DefaultTableModel projectModel = new DefaultTableModel();
    private JTable projectTable = new JTable();;

    public ShowProjectsTable(PMA pma,int width, int height){
      
        setProjectTable(pma);
        

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(projectModel);
        projectTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(projectTable);
        scrollPane.setPreferredSize(new Dimension(width, height));
        this.add(scrollPane);

    }

    private void setProjectTable(PMA pma) {
        
        projectModel.addColumn("Title");
        projectModel.addColumn("ID");
        projectModel.addColumn("Start Date");
        projectModel.addColumn("End Date");
        projectModel.addColumn("Hours Worked");
        projectModel.addColumn("Expected Hours");
        projectModel.addColumn("Description");
        projectModel.addColumn("Project Leader");

       update(pma);
    }
    
    public void update(PMA pma){
        
        projectModel.setRowCount(0);
       
        for (Project p : pma.getProjects()) {
            if(p.getProjectLeader() != null){
            projectModel.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
          //          p.getInfo().getStartDate(), 
          //          p.getInfo().getEndDate(), 
                    p.getInfo().getHoursWorked(), 
                    p.getInfo().getExpectedHours(), 
                    p.getInfo().getDescription(), 
                    p.getProjectLeader().getID(), 
                }
            );
            }else{
            projectModel.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
            //        p.getInfo().getStartDate(), 
            //        p.getInfo().getEndDate(), 
                    p.getInfo().getHoursWorked(), 
                    p.getInfo().getExpectedHours(), 
                    p.getInfo().getDescription(), 
                    "", 
                }
            );
            }
        }
        projectTable.setModel(projectModel);
       
    }

    public JTable getProjectTable(){
        return projectTable;
    }
  
}
