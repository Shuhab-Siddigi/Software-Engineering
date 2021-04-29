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
    JTable projectLeaderTable = new JTable();

    public ProjectLeaderTable(PMA pma,int width, int height){

        projectLeaderTable = setTable(pma, projectLeaderTable);
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        projectLeaderTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(projectLeaderTable);
        scrollPane.setPreferredSize(new Dimension(width, height));
        this.add(scrollPane);

    }

    private JTable setTable(PMA pma,JTable jTable) {
          
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Project Leader");

        for (Project p : pma.getProjects()) {
            model.addRow(
                new Object[] {   
                    p.getInfo().getTitle(), 
                    p.getInfo().getID(), 
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
                p.getProjectLeader(), 
            }
        );
    }
    
  
}
