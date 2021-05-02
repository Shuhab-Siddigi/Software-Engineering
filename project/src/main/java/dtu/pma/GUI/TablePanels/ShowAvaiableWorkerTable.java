package dtu.pma.GUI.TablePanels;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.Activity;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;


public class ShowAvaiableWorkerTable extends JPanel{
    
    private DefaultTableModel model;

    private JTable activityTable;
    
    public ShowAvaiableWorkerTable(PMA pma,int width,int height){

            
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        activityTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(activityTable);
        scrollPane.setPreferredSize(new Dimension(width/2, height));
        this.add(scrollPane);
    }
    public void setTable(PMA pma,Project project,Worker worker) {
        
        model = new DefaultTableModel();
        
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Start Date");
        model.addColumn("End Date");

        if(project.getActivities() != null){
            for (Activity a : project.getActivities()) {
                
                model.addRow(
                    new Object[] {   
                        a.getInfo().getTitle(), 
                        a.getInfo().getID(), 
                        a.getInfo().getStartDate(), 
                        a.getInfo().getEndDate(), 
                    }
                );
                
            }
        }
       

        activityTable.setModel(model);
    }

    public void addProject(Project p){
    
            model.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
                    p.getInfo().getStartDate(), 
                    p.getInfo().getEndDate(),  
                }
            );
            
        //model.fireTableDataChanged();
    }

}
