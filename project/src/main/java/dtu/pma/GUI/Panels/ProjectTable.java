package dtu.pma.GUI.Panels;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dtu.pma.PMA;
import dtu.pma.Project;

public class ProjectTable extends JPanel{

    public ProjectTable(PMA pma,int width, int height){

        JTable projectTable = new JTable();

        projectTable = setTable(pma, projectTable);

        JScrollPane scrollPane = new JScrollPane(projectTable);
        scrollPane.setPreferredSize(new Dimension(width, height - 5));
        this.add(scrollPane);

    }

    private JTable setTable(PMA pma,JTable jTable) {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Title");
        model.addColumn("ID");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Hours Worked");
        model.addColumn("Expected Hours");
        model.addColumn("Description");

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
                }
            );
        }

        jTable.setModel(model);

        return jTable;
    }
}
