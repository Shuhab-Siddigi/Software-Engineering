package dtu.pma.GUI.TablePanels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import dtu.pma.PMA;
import dtu.pma.Project;

public class GenerateReportTable extends JPanel {

    private DefaultTableModel projectModel = new DefaultTableModel();

    private JTable generateReportTable = new JTable();;

    public GenerateReportTable(PMA pma, int width, int height) {
        

        TableRowSorter<DefaultTableModel> projectSorter = new TableRowSorter<DefaultTableModel>(projectModel);
        generateReportTable.setRowSorter(projectSorter);

        setProjectTable(pma);

        JScrollPane generateReportScrollPane = new JScrollPane(generateReportTable);
        generateReportTable.setPreferredSize(new Dimension(width, height));

        setLayout(new GridBagLayout());
        GridBagConstraints constrain = new GridBagConstraints();

        constrain.fill = GridBagConstraints.BOTH;
        constrain.anchor = GridBagConstraints.CENTER;
        constrain.insets = new Insets(0, 0, 0, 0);
        constrain.weightx = 1;
        constrain.weighty = 1;
        constrain.gridx = 0;
        constrain.gridy = 0;
        this.add(generateReportScrollPane, constrain);

    }

    private void setProjectTable(PMA pma) {

        projectModel.addColumn("Title");
        projectModel.addColumn("ID");
        projectModel.addColumn("Project Leader");
       
        update(pma);
    }

    public void update(PMA pma){

        projectModel.setRowCount(0);
        if(pma.getProjects() != null){
        for (Project p : pma.getProjects()) {
            
            if(p.getProjectLeader() != null){
            projectModel.addRow(new Object[] { 
                p.getInfo().getTitle(), 
                p.getInfo().getID(),
                p.getProjectLeader().getID(), 
            });
            }else{
            projectModel.addRow(new Object[] { 
                p.getInfo().getTitle(), 
                p.getInfo().getID(), 
                "", 
            });
            }
        }
        }

        generateReportTable.setModel(projectModel);
    }

    public void addProject(Project p) {
        projectModel.addRow(new Object[] { p.getInfo().getTitle(), p.getInfo().getID(), });

    }

    public void setProjectLeaderAtRow(String projectLeader, int row) {
        projectModel.setValueAt(projectLeader, row, 2);
    }

    public JTable getProjectTable() {
        return generateReportTable;
    }
}
