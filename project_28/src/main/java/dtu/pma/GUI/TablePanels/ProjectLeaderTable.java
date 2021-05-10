package dtu.pma.GUI.TablePanels;

import javax.swing.JPanel;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import dtu.pma.PMA;
import dtu.pma.Project;
public class ProjectLeaderTable extends JPanel {
    

    private DefaultTableModel model = new DefaultTableModel();
    private JTable projectLeaderTable = new JTable();

    public ProjectLeaderTable(PMA pma,int width, int height){

        setProjectLeaderTable(pma);
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        projectLeaderTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(projectLeaderTable);
        scrollPane.setPreferredSize(new Dimension(width, height));
        this.add(scrollPane);

    }

    private void setProjectLeaderTable(PMA pma) {
          
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Project Leader");

        update(pma);

    }

    public void update(PMA pma){
        
        model.setRowCount(0);

        if(pma.getProjects() != null){
        for (Project p : pma.getProjects()) {
            if(p.getProjectLeader() != null){
            model.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
                    p.getProjectLeader(), 
                });
            } else{
           
            model.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
                    "", 
                });
            }
        }
    }
    }

    public void addProject(Project p){
        model.addRow(
            new Object[] {   
                p.getInfo().getTitle(), 
                p.getInfo().getID(), 
                p.getProjectLeader(), 
            }
        );
    }
    
  
}
