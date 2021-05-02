package dtu.pma.GUI.TablePanels;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dtu.pma.PMA;
import dtu.pma.Project;

public class AddActivityTable extends JPanel{
    private DefaultTableModel model;
    private JTable projectTable;
    
    public AddActivityTable(PMA pma,int width,int height){

        projectTable = new JTable();
        projectTable = setTable(pma, projectTable);
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        projectTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(projectTable);
        scrollPane.setPreferredSize(new Dimension(width/2, height));
        this.add(scrollPane);
    }
    private JTable setTable(PMA pma,JTable jTable) {
        
        model = new DefaultTableModel();
        
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Start Date");
        model.addColumn("End Date");

        for (Project p : pma.getProjects()) {
            
            model.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
                    p.getInfo().getStartDate(), 
                    p.getInfo().getEndDate(), 
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
                }
            );
            
        //model.fireTableDataChanged();
    }

    public JTable getProjectTable(){
        return projectTable;
    }
}
